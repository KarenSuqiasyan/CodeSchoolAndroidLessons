package com.example.codeschoolandroidlessons.guardian.ui

import androidx.fragment.app.Fragment

class BaseFragment : Fragment() {

    fun replaceFragment(activity: BaseActivity, resId: Int, fragment: Fragment) {
        activity.replaceFragment(fragment, resId)
    }

}