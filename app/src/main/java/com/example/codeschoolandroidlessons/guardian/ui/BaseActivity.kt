package com.example.codeschoolandroidlessons.guardian.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

open class BaseActivity : AppCompatActivity() {

    fun replaceFragment(fragment: Fragment, resId: Int) {
        supportFragmentManager.beginTransaction().replace(resId, fragment).commit()
    }
}