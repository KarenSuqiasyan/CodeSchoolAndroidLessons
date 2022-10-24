package com.example.codeschoolandroidlessons.login_ragistration

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.codeschoolandroidlessons.databinding.ActivityLoginAndRagistrationBinding
import com.example.codeschoolandroidlessons.login_ragistration.LoginActivity.Companion.REQUEST_CODE
import com.example.codeschoolandroidlessons.login_ragistration.LoginActivity.Companion.USER_NAME


class LoginAndRagistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginAndRagistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginAndRagistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logInButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_CODE ->  {
                val username = data?.getStringExtra(USER_NAME)
            }
        }
    }
}