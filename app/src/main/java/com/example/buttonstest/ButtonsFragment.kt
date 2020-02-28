package com.example.buttonstest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.buttonstest.databinding.FragmentButtonsBinding
import com.google.android.material.tabs.TabLayout

class ButtonsFragment : Fragment() {

    private lateinit var binding: FragmentButtonsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_buttons, container, false)

        context?.let { Glide.with(it)
            .load("https://ifce.edu.br/prpi/documentos-1/semic/2017/logo-horizontal-ifce.png/@@images/de79e070-1bc2-4aba-88a4-9aad10a9cd69.png")
            .into(binding.imageButton)
        }

        binding.normalButton.setOnClickListener{ normalButtonClick() }
        binding.firstRadioButton.setOnClickListener { radioButtonClick("Primeiro") }
        binding.secondRadioButton.setOnClickListener { radioButtonClick("Segundo") }
        binding.imageButton.setOnClickListener { imageButtonClick() }

        binding.tabLayout.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> Toast.makeText(context, "Você clicou no ${(tab.position)+1}º botão do tabLayout", Toast.LENGTH_SHORT).show()
                    1 -> Toast.makeText(context, "Você clicou no ${(tab.position)+1}º botão do tabLayout", Toast.LENGTH_SHORT).show()
                    2 -> Toast.makeText(context, "Você clicou no ${(tab.position)+1}º botão do tabLayout", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onTabReselected(tab: TabLayout.Tab) {}
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
        })

        return binding.root
    }

    fun normalButtonClick() {
        Toast.makeText(context, "Você clicou no botão normal", Toast.LENGTH_LONG).show()
    }

    fun radioButtonClick(buttonClicked: String) {
        if (buttonClicked == "Primeiro") {
            binding.secondRadioButton.isChecked = false
            Toast.makeText(context, "Você selecionou o primeiro radio button", Toast.LENGTH_LONG).show()
        } else {
            binding.firstRadioButton.isChecked = false
            Toast.makeText(context, "Você selecionou o segundo radio button", Toast.LENGTH_LONG).show()
        }
    }

    fun imageButtonClick() {
        Toast.makeText(context, "Você clicou no botão imagem", Toast.LENGTH_LONG).show()
    }
}