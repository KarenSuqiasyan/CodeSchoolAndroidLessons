package com.cshomework.codeschoolandroidlessons

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.common.codeschoolandroidlessons.databinding.ActivityMainBinding
import com.cshomework.codeschoolandroidlessons.calculator.CalculatorActivity
import com.cshomework.codeschoolandroidlessons.guardianv2.ui.activity.NewsActivity
import com.cshomework.codeschoolandroidlessons.login_registration.activity.LoginOrRegistrationActivity
import com.cshomework.codeschoolandroidlessons.multiple_recyclerview.ui.activity.posthome.PostHomeActivity
import com.cshomework.codeschoolandroidlessons.pickers_and_menues.PickerAndMenuActivity
import com.cshomework.codeschoolandroidlessons.playmarket.ui.home.activity.PlayMarketHomeActivity
import com.cshomework.codeschoolandroidlessons.recyclerview_countries.ui.countrieslist.CountriesActivity
import com.cshomework.codeschoolandroidlessons.tictactoe.PlayersActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        com.cshomework.codeschoolandroidlessons.CodeSchoolHomeworkEnum.values().forEach {
            val button = AppCompatButton(this)
            button.text = it.name.replace("_", " ")
            button.tag = it
            binding.linearLayout.addView(button)
            button.setOnClickListener(this)
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.tag as com.cshomework.codeschoolandroidlessons.CodeSchoolHomeworkEnum) {
            com.cshomework.codeschoolandroidlessons.CodeSchoolHomeworkEnum.CALCULATOR -> startActivity(
                Intent(this, CalculatorActivity::class.java)
            )
            com.cshomework.codeschoolandroidlessons.CodeSchoolHomeworkEnum.TIC_TAC_TOE -> startActivity(
                Intent(this, PlayersActivity::class.java)
            )
            com.cshomework.codeschoolandroidlessons.CodeSchoolHomeworkEnum.RECYCLERVIEW_COUNTRIES -> startActivity(
                Intent(this, CountriesActivity::class.java)
            )
            com.cshomework.codeschoolandroidlessons.CodeSchoolHomeworkEnum.POST -> startActivity(
                Intent(this, PostHomeActivity::class.java)
            )
            com.cshomework.codeschoolandroidlessons.CodeSchoolHomeworkEnum.PICKERS_AND_MENUS -> startActivity(
                Intent(this, PickerAndMenuActivity::class.java)
            )
            com.cshomework.codeschoolandroidlessons.CodeSchoolHomeworkEnum.LOGIN_OR_REGISTRATION -> startActivity(
                Intent(this, LoginOrRegistrationActivity::class.java)
            )
            com.cshomework.codeschoolandroidlessons.CodeSchoolHomeworkEnum.PLAY_MARKET -> startActivity(
                Intent(this, PlayMarketHomeActivity::class.java)
            )
            com.cshomework.codeschoolandroidlessons.CodeSchoolHomeworkEnum.GUARDIAN -> startActivity(
                Intent(this, NewsActivity::class.java)
            )
        }
    }
}

enum class CodeSchoolHomeworkEnum {
    CALCULATOR,
    TIC_TAC_TOE,
    RECYCLERVIEW_COUNTRIES,
    POST,
    PICKERS_AND_MENUS,
    LOGIN_OR_REGISTRATION,
    PLAY_MARKET,
    GUARDIAN
}