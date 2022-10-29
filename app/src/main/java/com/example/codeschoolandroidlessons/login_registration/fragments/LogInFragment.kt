package com.example.codeschoolandroidlessons.login_registration.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.example.codeschoolandroidlessons.databinding.FragmentLogInBinding
import com.example.codeschoolandroidlessons.login_registration.Communicator


class LogInFragment : Fragment() {
    private lateinit var binding: FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogInBinding.inflate(inflater, container, false);
        val view = binding.root
        binding.logInButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(USER_NAME,binding.emailOrPhoneEditText.text.toString())
            bundle.putString(PASSWORD, binding.passwordEditText.text.toString())
            val homeFragment = HomeFragment.newInstance()
            homeFragment.arguments = bundle
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(com.example.codeschoolandroidlessons.R.id.container, homeFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = LogInFragment()
        const val USER_NAME = "user name"
        const val PASSWORD = "password"
        const val NAME_OR_PSEUDO = "name or pseudo"
        const val CONFIRM_PASSWORD = "confirm password"
    }


}