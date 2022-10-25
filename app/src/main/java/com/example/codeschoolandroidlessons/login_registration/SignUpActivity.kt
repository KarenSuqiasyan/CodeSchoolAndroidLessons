package com.example.codeschoolandroidlessons.login_registration

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.codeschoolandroidlessons.databinding.ActivitySignUpBinding
import com.example.codeschoolandroidlessons.login_registration.LoginActivity.Companion.PASSWORD
import com.example.codeschoolandroidlessons.login_registration.LoginActivity.Companion.USER_NAME

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUpButton.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra(USER_NAME, binding.emailOrPhoneSignUpEditText.text.toString())
            returnIntent.putExtra(PASSWORD, binding.passwordSignUpEditText.text.toString())
            returnIntent.putExtra(NAME_OR_PSEUDO, binding.nameOrPseudoSignUpEditText.text.toString())
            returnIntent.putExtra(CONFIRM_PASSWORD, binding.confirmPasswordSignUpEditText.text.toString())

            setResult(RESULT_OK, returnIntent)
            finish()
        }
    }
    companion object {
        const val NAME_OR_PSEUDO = "name or pseudo"
        const val CONFIRM_PASSWORD = "confirm password"
    }
}