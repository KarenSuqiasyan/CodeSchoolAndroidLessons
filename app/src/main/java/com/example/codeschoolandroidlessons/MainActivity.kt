package com.example.codeschoolandroidlessons

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.codeschoolandroidlessons.calculator.CalculatorActivity
import com.example.codeschoolandroidlessons.databinding.ActivityMainBinding
import com.example.codeschoolandroidlessons.login_registration.activity.LoginOrRegistrationActivity
import com.example.codeschoolandroidlessons.multiple_recyclerview.ui.activity.posthome.PostHomeActivity
import com.example.codeschoolandroidlessons.pickers_and_menues.PickerAndMenuActivity
import com.example.codeschoolandroidlessons.recyclerview_countries.ui.countrieslist.CountriesActivity
import com.example.codeschoolandroidlessons.tictactoe.PlayersActivity

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
            CodeSchoolHomeworkEnum.CALCULATOR -> startActivity(Intent(this, CalculatorActivity::class.java))
            CodeSchoolHomeworkEnum.TIC_TAC_TOE -> startActivity(Intent(this, PlayersActivity::class.java))
            CodeSchoolHomeworkEnum.RECYCLERVIEW_COUNTRIES -> startActivity(Intent(this, CountriesActivity::class.java))
            CodeSchoolHomeworkEnum.POST -> startActivity(Intent(this, PostHomeActivity::class.java))
            CodeSchoolHomeworkEnum.PICKERS_AND_MENUS->startActivity(Intent(this, PickerAndMenuActivity::class.java))
            CodeSchoolHomeworkEnum.LOGIN_OR_REGISTRATION->startActivity(Intent(this, LoginOrRegistrationActivity::class.java))

        }
    }
}

enum class CodeSchoolHomeworkEnum {
    CALCULATOR,
    TIC_TAC_TOE,
    RECYCLERVIEW_COUNTRIES,
    POST,
    PICKERS_AND_MENUS,
    LOGIN_OR_REGISTRATION
}