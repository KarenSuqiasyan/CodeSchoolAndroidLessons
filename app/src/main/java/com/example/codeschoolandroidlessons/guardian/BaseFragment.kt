package com.example.codeschoolandroidlessons.guardian

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.codeschoolandroidlessons.guardian.ui.activity.NewsActivity
import com.example.codeschoolandroidlessons.guardian.viewmodel.NewsViewModel

open class BaseFragment : Fragment() {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }

    fun replaceFragment(activity: BaseActivity, resId: Int, fragment: Fragment) {
        activity.replaceFragment(fragment, resId)
    }
}