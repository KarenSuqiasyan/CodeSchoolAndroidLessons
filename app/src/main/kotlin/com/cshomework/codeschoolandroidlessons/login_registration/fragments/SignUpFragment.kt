package com.cshomework.codeschoolandroidlessons.login_registration.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.common.codeschoolandroidlessons.databinding.FragmentSignUpBinding
import com.cshomework.codeschoolandroidlessons.login_registration.fragments.HomeFragment.Companion.CONFIRM_PASSWORD
import com.cshomework.codeschoolandroidlessons.login_registration.fragments.HomeFragment.Companion.NAME_OR_PSEUDO
import com.cshomework.codeschoolandroidlessons.login_registration.fragments.HomeFragment.Companion.PASSWORD
import com.cshomework.codeschoolandroidlessons.login_registration.fragments.HomeFragment.Companion.USER_NAME

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false);
        binding.signUpButton.setOnClickListener {
            val bundle = Bundle().apply {
                putString(USER_NAME, binding.emailOrPhoneSignUpEditText.text.toString())
                putString(PASSWORD, binding.confirmPasswordSignUpEditText.text.toString())
                putString(CONFIRM_PASSWORD, binding.confirmPasswordSignUpEditText.text.toString())
                putString(NAME_OR_PSEUDO, binding.nameOrPseudoSignUpEditText.text.toString())
            }
            val homeFragment = HomeFragment.newInstance()
            homeFragment.arguments = bundle
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(com.common.codeschoolandroidlessons.R.id.container, homeFragment)
                addToBackStack(null)
                commit()
            }
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = SignUpFragment()
    }
}