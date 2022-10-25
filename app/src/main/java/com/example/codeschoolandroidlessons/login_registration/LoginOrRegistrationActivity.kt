package com.example.codeschoolandroidlessons.login_registration

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.codeschoolandroidlessons.R
import com.example.codeschoolandroidlessons.databinding.ActivityLoginOrRegistrationBinding
import com.example.codeschoolandroidlessons.login_registration.LoginActivity.Companion.PASSWORD
import com.example.codeschoolandroidlessons.login_registration.LoginActivity.Companion.USER_NAME


class LoginOrRegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginOrRegistrationBinding
    private var loginResult: ActivityResultLauncher<Intent>? = null
    private var signUpResult: ActivityResultLauncher<Intent>? = null


    @SuppressLint("SetTextI18n", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginOrRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                val username = result.data?.getStringExtra(USER_NAME)
                val password = result.data?.getStringExtra(PASSWORD)
                Log.d("My Log", "username: $username password: $password")
                Dialog(this@LoginOrRegistrationActivity, R.style.CustomAlertDialog).apply {
                    setContentView(R.layout.username_password_dialog)
                    findViewById<TextView>(R.id.passwordTextView2).text = "password: $password"
                    findViewById<TextView>(R.id.emailOrPhoneTextView2).text = "username: $username"
                    findViewById<TextView>(R.id.confirmPasswordTextView).isVisible = false
                    findViewById<TextView>(R.id.nameOrPseudoTextView).isVisible = false
                }.show()
            }
        }
        signUpResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                val username = result.data?.getStringExtra(USER_NAME)
                val password = result.data?.getStringExtra(PASSWORD)
                val confirmPassword = result.data?.getStringExtra(SignUpActivity.CONFIRM_PASSWORD)
                val nameOrPseudo = result.data?.getStringExtra(SignUpActivity.NAME_OR_PSEUDO)

                Dialog(this@LoginOrRegistrationActivity, R.style.CustomAlertDialog).apply {
                    setContentView(R.layout.username_password_dialog)
                    findViewById<TextView>(R.id.passwordTextView2).text = "password: $password"
                    findViewById<TextView>(R.id.emailOrPhoneTextView2).text = "username: $username"
                    findViewById<TextView>(R.id.confirmPasswordTextView).text = "confirm password: $confirmPassword"
                    findViewById<TextView>(R.id.nameOrPseudoTextView).text = "name Or Pseudo: $nameOrPseudo"
                }.show()
            }
        }

        binding.logInButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            loginResult?.launch(intent)
        }
        binding.signUpButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            signUpResult?.launch(intent)
        }
    }
}