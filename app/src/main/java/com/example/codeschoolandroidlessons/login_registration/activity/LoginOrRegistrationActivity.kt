package com.example.codeschoolandroidlessons.login_registration.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.codeschoolandroidlessons.R
import com.example.codeschoolandroidlessons.databinding.ActivityLoginOrRegistrationBinding
import com.example.codeschoolandroidlessons.login_registration.fragments.HomeFragment
import com.example.codeschoolandroidlessons.login_registration.fragments.LogInFragment

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

