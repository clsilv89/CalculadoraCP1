package com.example.calculadoracp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.calculadoracp1.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding

    private val valores = arrayListOf(0.0, 0.0)
    private var position = 0
    private var limparDisplay = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        with(binding) {
            button0.setOnClickListener {
                atualizarValores(binding.button0.text.toString())
            }
            button1.setOnClickListener {
                atualizarValores(binding.button1.text.toString())
            }
            button2.setOnClickListener {
                atualizarValores(binding.button2.text.toString())
            }
            button3.setOnClickListener {
                atualizarValores(binding.button3.text.toString())
            }
            button4.setOnClickListener {
                atualizarValores(binding.button4.text.toString())
            }
            button5.setOnClickListener {
                atualizarValores(binding.button5.text.toString())
            }
            button6.setOnClickListener {
                atualizarValores(binding.button6.text.toString())
            }
            button7.setOnClickListener {
                atualizarValores(binding.button7.text.toString())
            }
            button8.setOnClickListener {
                atualizarValores(binding.button8.text.toString())
            }
            button9.setOnClickListener {
                atualizarValores(binding.button9.text.toString())
            }
            buttonAC.setOnClickListener {
                limparDisplay()
            }
            buttonInverter
            buttonPorcetagem
            buttonDividir.setOnClickListener {
                limparDisplay = true
                position = 1
            }
            buttonMultiplicar.setOnClickListener {
                limparDisplay = true
                position = 1
            }
            buttonSomar.setOnClickListener {
                limparDisplay = true
                position = 1
            }
            buttonSubtrair.setOnClickListener {
                limparDisplay = true
                position = 1
            }
            buttonResultado
        }

        atualizarDisplay(valores[position].toString())
    }

    private fun atualizarValores(texto: String) {
        val valorDisplay = if (limparDisplay) "" else binding.textViewDisplay.text
        if (valorDisplay != "0" || texto != "0") {
            val novoValor = "$valorDisplay$texto"
            atualizarDisplay(novoValor)
            limparDisplay = false
        }
    }

    private fun limparDisplay() {
        val novoValor = "0"
        atualizarDisplay(novoValor)
    }

    private fun somar(valor1: Int, valor2: Int): Int {
        return valor1 + valor2
    }

    private fun subtrair(valor1: Int, valor2: Int): Int {
        return valor1 - valor2
    }

    private fun multiplicar(valor1: Int, valor2: Int): Int {
        return valor1 * valor2
    }

    private fun dividir(valor1: Int, valor2: Int): Int {
        return if (valor2 == 0) 0 else valor1 / valor2
    }

    private fun atualizarDisplay(valor: String) {
        valores[position] = valor.toDouble()
        binding.textViewDisplay.text = valor
    }
}