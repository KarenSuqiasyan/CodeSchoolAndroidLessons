package com.example.codeschoolandroidlessons

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.codeschoolandroidlessons.calculator.CalculatorActivity
import com.example.codeschoolandroidlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        CodeSchoolHomeworkEnum.values().forEach {
            val button = AppCompatButton(this)
            button.text = it.name.replace("_", " ")
            button.tag = it
            binding.linearLayout.addView(button)
            button.setOnClickListener(this)
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.tag as CodeSchoolHomeworkEnum) {
            CodeSchoolHomeworkEnum.CALCULATOR -> {
                startActivity(Intent(this, CalculatorActivity::class.java))
            }
            CodeSchoolHomeworkEnum.TIC_TAC_TOE -> {

            }
        }
    }
}

enum class CodeSchoolHomeworkEnum {
    CALCULATOR,
    TIC_TAC_TOE



}