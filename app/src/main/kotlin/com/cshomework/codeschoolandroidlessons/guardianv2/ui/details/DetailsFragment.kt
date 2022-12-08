package com.cshomework.codeschoolandroidlessons.guardianv2.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.common.BaseCommonFragment
import com.common.codeschoolandroidlessons.databinding.FragmentDetailsBinding
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class DetailsFragment : BaseCommonFragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val viewModel by lifecycleScope.viewModel<DetailsFragmentViewModel>(this)
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        args.newsResult?.id?.let { viewModel.getDetails(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.detailsLiveData.observe(viewLifecycleOwner) {contentDto ->
            with(binding) {
                    Glide.with(requireActivity())
                        .load(contentDto?.fields?.thumbnail)
                        .into(detailImage)
                detailTitle.text = contentDto?.fields?.headline
                detailBody.text = contentDto?.fields?.body?.let {
                    HtmlCompat.fromHtml(
                        it,
                        HtmlCompat.FROM_HTML_MODE_LEGACY
                    )
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = DetailsFragment()
    }
}