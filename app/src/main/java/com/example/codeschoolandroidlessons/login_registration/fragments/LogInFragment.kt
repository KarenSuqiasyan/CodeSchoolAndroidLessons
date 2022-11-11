package com.example.codeschoolandroidlessons.login_registration.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.codeschoolandroidlessons.databinding.FragmentLogInBinding
import com.example.codeschoolandroidlessons.login_registration.fragments.HomeFragment.Companion.PASSWORD
import com.example.codeschoolandroidlessons.login_registration.fragments.HomeFragment.Companion.USER_NAME


class LogInFragment : Fragment() {
    private lateinit var binding: FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogInBinding.inflate(inflater, container, false);
        binding.logInButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(USER_NAME, binding.emailOrPhoneEditText.text.toString())
            bundle.putString(PASSWORD, binding.passwordEditText.text.toString())
            val homeFragment = HomeFragment.newInstance()
            homeFragment.arguments = bundle
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(com.example.codeschoolandroidlessons.R.id.container, homeFragment)
                addToBackStack(null)
                commit()
            }
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = LogInFragment()
    }
}