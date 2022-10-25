package com.example.codeschoolandroidlessons.login_registration

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.codeschoolandroidlessons.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logInButton.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra(USER_NAME, binding.emailOrPhoneEditText.text.toString())
            returnIntent.putExtra(PASSWORD, binding.passwordEditText.text.toString())
            setResult(RESULT_OK, returnIntent)
            finish()
        }
    }

    companion object {
        const val USER_NAME = "user name"
        const val PASSWORD = "password"
    }
}