package com.cshomework.codeschoolandroidlessons.login_registration.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.common.codeschoolandroidlessons.R
import com.common.codeschoolandroidlessons.databinding.ActivityLoginOrRegistrationBinding
import com.cshomework.codeschoolandroidlessons.login_registration.fragments.HomeFragment
import com.cshomework.codeschoolandroidlessons.login_registration.fragments.LogInFragment

class LoginOrRegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginOrRegistrationBinding
    val bundle = Bundle()
    private val loginFragment = LogInFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginOrRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, HomeFragment.newInstance())
            .commit()
    }
}

