package com.example.codeschoolandroidlessons.login_registration.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.codeschoolandroidlessons.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false);
        val view = binding.root
        binding.signUpButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(LogInFragment.USER_NAME, binding.emailOrPhoneSignUpEditText.text.toString())
            bundle.putString(LogInFragment.PASSWORD, binding.confirmPasswordSignUpEditText.text.toString())
            bundle.putString(LogInFragment.CONFIRM_PASSWORD, binding.confirmPasswordSignUpEditText.text.toString())
            bundle.putString(LogInFragment.NAME_OR_PSEUDO, binding.nameOrPseudoSignUpEditText.text.toString())
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
        fun newInstance() = SignUpFragment()
    }
}