package com.example.buttonstest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.buttonstest.databinding.FragmentButtonsBinding
import com.google.android.material.tabs.TabLayout

class ButtonsFragment : Fragment() {

    //O binding é uma variável que basicamente representa uma ligação direta entre teu fragment/activity e tua view (xml).
    //Como ele é uma variável que vai iniciar apenas quando tua tela for criada, ele recebe a propriedade Lateinit.
    private lateinit var binding: FragmentButtonsBinding

    //Cria a view da tela
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        //Aqui o binding é inicializado com a nossa view (xml) que está ligada ao fragment.
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_buttons, container, false)

        //Após nossa view ser iniciada, os botões e td o resto que a gente por no xml será de fácil acesso através do [binding . nomeDoComponente] como exemplificado a seguir

        //Como nesse mini tutorial a gente quer interagir com os eventos possíveis de um botão, acessaremos cada botão por meio do binding.nomeDoBotão
        //e a seguir, iremos atribuir um listener de evento Click para cada um.

        //Quando cada um dos botões for clicado, ele chamará uma função respectiva que se encontra dentro dessas chaves.

        //normalButton chama a função normalButtonClick() quando clicado
        binding.normalButton.setOnClickListener{ normalButtonClick() }

        //radioButton 1 e 2 chamam a função radioButtonClick() quando clicados
        binding.firstRadioButton.setOnClickListener { radioButtonClick("Primeiro") }
        binding.secondRadioButton.setOnClickListener { radioButtonClick("Segundo") }

        //imageButton chama a função imageButtonClick() quando clicado
        binding.imageButton.setOnClickListener { imageButtonClick() }


        //Contudo, no Kotlin existem algumas exceções que não precisam terem atribuídas a si um clickListener pois já possuem um listener de click inbutidos em si.
        //No nosso caso, estamos tratando de um TabLayout e nele temos como selecionar um evento quando um item do tabLayout é selecionado, desselecionado e seleciconado novamente
        binding.tabLayout.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {

            //Quando um elemento é clicado, na função de listener para itens selecionados nos pegamos a posição do item clicado com tab.position e a partir disso printamos
            //na tela o número do ícone clicado.
            override fun onTabSelected(tab: TabLayout.Tab) {

                //Esse when é uma forma mais bonita de um if else para testar se a posição clicada foi 0, 1 ou 2.
                when (tab.position) {
                    0 -> Toast.makeText(context, "Você clicou no ${(tab.position)+1}º botão do tabLayout", Toast.LENGTH_SHORT).show()
                    1 -> Toast.makeText(context, "Você clicou no ${(tab.position)+1}º botão do tabLayout", Toast.LENGTH_SHORT).show()
                    2 -> Toast.makeText(context, "Você clicou no ${(tab.position)+1}º botão do tabLayout", Toast.LENGTH_SHORT).show()
                }
            }

            //Aqui são funções para caso o item seja desselecionado ou selecionado novamente, porém, como quase nunca as utilizamos, deixei elas vazias.
            override fun onTabReselected(tab: TabLayout.Tab) {}
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
        })

        //Após criar toda essa view e setar os listeners para clicks e eventos dos botões a gente retorna nosso binding.root que é a junção do que criamos com oq foi criado
        return binding.root
    }


    //Dessa parte em diante tudo é função e o comportamento das mesmas é sempre no padrão : Nome da função, parâmetro e corpo, quando necessários, da função e oq ela faz.
    fun normalButtonClick() {
        Toast.makeText(context, "Você clicou no botão normal", Toast.LENGTH_SHORT).show()
    }

    fun radioButtonClick(buttonClicked: String) {
        if (buttonClicked == "Primeiro") {
            binding.secondRadioButton.isChecked = false
            Toast.makeText(context, "Você selecionou o primeiro radio button", Toast.LENGTH_SHORT).show()
        } else {
            binding.firstRadioButton.isChecked = false
            Toast.makeText(context, "Você selecionou o segundo radio button", Toast.LENGTH_SHORT).show()
        }
    }

    fun imageButtonClick() {
        Toast.makeText(context, "Você clicou no botão imagem", Toast.LENGTH_SHORT).show()
    }
}