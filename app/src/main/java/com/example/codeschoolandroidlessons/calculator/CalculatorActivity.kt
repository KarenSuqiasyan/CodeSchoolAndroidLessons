package com.example.codeschoolandroidlessons.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.codeschoolandroidlessons.R
import com.example.codeschoolandroidlessons.databinding.ActivityCalculatorBinding
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn0.setOnClickListener { appendWriting("0") }
        binding.btn1.setOnClickListener { appendWriting("1") }
        binding.btn2.setOnClickListener { appendWriting("2") }
        binding.btn3.setOnClickListener { appendWriting("3") }
        binding.btn4.setOnClickListener { appendWriting("4") }
        binding.btn5.setOnClickListener { appendWriting("5") }
        binding.btn6.setOnClickListener { appendWriting("6") }
        binding.btn7.setOnClickListener { appendWriting("7") }
        binding.btn8.setOnClickListener { appendWriting("8") }
        binding.btn9.setOnClickListener { appendWriting("9") }


        binding.btnComa.setOnClickListener { appendWriting(".") }
        binding.btnDivide.setOnClickListener { appendWriting("/") }
        binding.btnMultiply.setOnClickListener { appendWriting("*") }
        binding.btnPercent.setOnClickListener { appendWriting("%") }
        binding.btnPlus.setOnClickListener { appendWriting("+") }
        binding.btnMinus.setOnClickListener { appendWriting("-") }


        binding.btnC.setOnClickListener {
            binding.tvResult.text = ""
            binding.tvWriting.text = ""
        }

        binding.btnBack.setOnClickListener {
            val string = binding.tvWriting.text.toString()
            if (string.isNotEmpty()) {
                binding.tvWriting.text = string.substring(0, string.length - 1)
            }
            binding.tvResult.text = ""
        }
        binding.btnEquals.setOnClickListener {
            val expression = ExpressionBuilder(binding.tvWriting.text.toString()).build()
            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble())
                binding.tvResult.text = longResult.toString()
            else
                binding.tvResult.text = result.toString()
        }
    }

    private fun appendWriting(string: String) {

        if (binding.tvResult.text.isNotEmpty()) {
            binding.tvWriting.text = ""
        }
        binding.tvWriting.append(binding.tvResult.text)
        binding.tvWriting.append(string)
        binding.tvResult.text = ""
    }
    }
