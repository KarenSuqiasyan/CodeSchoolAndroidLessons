package com.example.codeschoolandroidlessons.playmarket.ui

import androidx.fragment.app.Fragment

open class BasePlayMarketFragment : Fragment() {

    fun replaceFragment(activity: BasePlayMarketActivity, resId: Int, fragment: Fragment) {
        activity.replaceFragment(fragment, resId)
    }
}