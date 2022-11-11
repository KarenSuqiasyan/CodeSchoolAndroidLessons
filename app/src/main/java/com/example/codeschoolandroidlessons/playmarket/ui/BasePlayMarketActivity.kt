package com.example.codeschoolandroidlessons.playmarket.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

open class BasePlayMarketActivity : AppCompatActivity() {

    fun replaceFragment(fragment: Fragment, resId: Int) {
        supportFragmentManager.beginTransaction().replace(resId, fragment).commit()
    }
}