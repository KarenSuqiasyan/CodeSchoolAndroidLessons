package com.example.codeschoolandroidlessons.login_ragistration

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.codeschoolandroidlessons.MainActivity
import com.example.codeschoolandroidlessons.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = "karen@gmail.com"

        binding.logInButton.setOnClickListener {
            val returnIntent = Intent(this, MainActivity::class.java)
            returnIntent.putExtra(USER_NAME, username)
            setResult(REQUEST_CODE, returnIntent)
            finish()
        }
    }

    companion object {
        const val REQUEST_CODE = 1
        const val USER_NAME = "user name"

    }
}