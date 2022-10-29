package com.example.codeschoolandroidlessons.login_registration.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.codeschoolandroidlessons.R
import com.example.codeschoolandroidlessons.databinding.ActivityLoginOrRegistrationBinding
import com.example.codeschoolandroidlessons.login_registration.Communicator
import com.example.codeschoolandroidlessons.login_registration.fragments.LogInFragment.Companion.PASSWORD
import com.example.codeschoolandroidlessons.login_registration.fragments.LogInFragment.Companion.USER_NAME
import com.example.codeschoolandroidlessons.login_registration.fragments.HomeFragment
import com.example.codeschoolandroidlessons.login_registration.fragments.LogInFragment

class LoginOrRegistrationActivity : AppCompatActivity(), Communicator {

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

    override fun setUserName(username: String) {
        bundle.putString(USER_NAME, username)
        val transaction = this.supportFragmentManager.beginTransaction()
        loginFragment.arguments = bundle
        transaction.replace(R.id.container, loginFragment)
        transaction.commit()
    }

    override fun setPassword(password: String) {
        bundle.putString(PASSWORD, password)
        val transaction = this.supportFragmentManager.beginTransaction()
        loginFragment.arguments = bundle
        transaction.replace(R.id.container, loginFragment)
        transaction.commit()
    }
}
//Dialog(this@LoginOrRegistrationActivity, R.style.CustomAlertDialog).apply {
//    setContentView(R.layout.username_password_dialog)
//    findViewById<TextView>(R.id.passwordTextView2).text = "password: $password"
//    findViewById<TextView>(R.id.emailOrPhoneTextView2).text = "username: $username"
//    findViewById<TextView>(R.id.confirmPasswordTextView).text = "confirm password: $confirmPassword"
//    findViewById<TextView>(R.id.nameOrPseudoTextView).text = "name Or Pseudo: $nameOrPseudo"
//}.show()
