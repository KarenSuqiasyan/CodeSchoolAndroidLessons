package com.example.codeschoolandroidlessons.login_registration.fragments

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.codeschoolandroidlessons.R
import com.example.codeschoolandroidlessons.databinding.FragmentHomeBinding
import com.example.codeschoolandroidlessons.login_registration.Communicator
import com.example.codeschoolandroidlessons.login_registration.fragments.LogInFragment.Companion.CONFIRM_PASSWORD
import com.example.codeschoolandroidlessons.login_registration.fragments.LogInFragment.Companion.NAME_OR_PSEUDO
import com.example.codeschoolandroidlessons.login_registration.fragments.LogInFragment.Companion.PASSWORD
import com.example.codeschoolandroidlessons.login_registration.fragments.LogInFragment.Companion.USER_NAME

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var communicator: Communicator


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        val view = binding.root
        communicator = activity as Communicator
        binding.logInButton.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, LogInFragment.newInstance())
            transaction.commit()
        }
        binding.signUpButton.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, SignUpFragment.newInstance())
            transaction.commit()
        }
        return view
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = this.arguments
        if (bundle != null) {
            val username = bundle.getString(USER_NAME)
            val password = bundle.getString(PASSWORD)
            var nameOrPseudo = bundle.getString(NAME_OR_PSEUDO)
            var confirmPassword = bundle.getString(CONFIRM_PASSWORD)
            if (bundle.getString(NAME_OR_PSEUDO) == null || bundle.getString(CONFIRM_PASSWORD) == null) {
                nameOrPseudo = ""
                confirmPassword = ""
            }
            showDialog(username, password, nameOrPseudo, confirmPassword)
        }
    }

    @SuppressLint("CutPasteId", "SetTextI18n")
    private fun showDialog(username: String?, password: String?, confirmPassword: String? = "", nameOrPseudo: String? = "") {
        Dialog(requireContext(), R.style.CustomAlertDialog).apply {
            setContentView(R.layout.username_password_dialog)
            findViewById<TextView>(R.id.passwordTextView2).text = "password: $username"
            findViewById<TextView>(R.id.emailOrPhoneTextView2).text = "username: $password"
            findViewById<TextView>(R.id.confirmPasswordTextView).text = "confirmPassword: $confirmPassword"
            findViewById<TextView>(R.id.nameOrPseudoTextView).text = "nameOrPseudo: $nameOrPseudo"

        }.show()

    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

}
