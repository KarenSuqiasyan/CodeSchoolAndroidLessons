package com.example.codeschoolandroidlessons.guardianv2.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.base.BaseCommonFragment
import com.example.codeschoolandroidlessons.databinding.FragmentDetailsBinding
import com.example.codeschoolandroidlessons.databinding.FragmentGuardianContentNewsBinding

class DetailsFragment : BaseCommonFragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = DetailsFragment()
    }
}