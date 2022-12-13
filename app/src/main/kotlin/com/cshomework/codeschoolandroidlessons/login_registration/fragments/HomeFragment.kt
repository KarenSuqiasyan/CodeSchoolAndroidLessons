package com.cshomework.codeschoolandroidlessons.login_registration.fragments

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.common.codeschoolandroidlessons.R
import com.common.codeschoolandroidlessons.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.signUpButton.setOnClickListener(this)
        binding.logInButton.setOnClickListener(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = this.arguments
        if (bundle != null) {
            val username = bundle.getString(USER_NAME)
            val password = bundle.getString(PASSWORD)
            val nameOrPseudo = bundle.getString(NAME_OR_PSEUDO)
            val confirmPassword = bundle.getString(CONFIRM_PASSWORD)
            showDialog(username, password, nameOrPseudo, confirmPassword)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showDialog(username: String?, password: String?, confirmPassword: String? = "", nameOrPseudo: String? = "") {
        Dialog(requireActivity(), R.style.UsernamePasswordDialog).apply {
            setContentView(R.layout.username_password_dialog)
            findViewById<TextView>(R.id.passwordTextView2).text = "password: $username"
            findViewById<TextView>(R.id.emailOrPhoneTextView2).text = "username: $password"
            if (confirmPassword != null || nameOrPseudo != null) {
                findViewById<TextView>(R.id.confirmPasswordTextView).apply {
                    isVisible = true
                    text = "confirmPassword: $confirmPassword"
                }
                findViewById<TextView>(R.id.nameOrPseudoTextView).apply {
                    isVisible = true
                    text = "nameOrPseudo: $nameOrPseudo"
                }
            }
        }.show()
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
        const val USER_NAME = "user name"
        const val PASSWORD = "password"
        const val NAME_OR_PSEUDO = "name or pseudo"
        const val CONFIRM_PASSWORD = "confirm password"
    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.signUpButton -> {
                requireActivity().supportFragmentManager.beginTransaction().apply {
                    replace(R.id.container, SignUpFragment.newInstance())
                    addToBackStack(null)
                    commit()
                }
            }
            binding.logInButton -> {
                requireActivity().supportFragmentManager.beginTransaction().apply {
                    replace(R.id.container, LogInFragment.newInstance())
                    addToBackStack(null)
                    commit()
                }
            }
        }
    }
}


