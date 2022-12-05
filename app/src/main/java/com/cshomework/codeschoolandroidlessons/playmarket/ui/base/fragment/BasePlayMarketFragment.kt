package com.cshomework.codeschoolandroidlessons.playmarket.ui.base.fragment

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cshomework.codeschoolandroidlessons.playmarket.data.base.BaseItemType
import com.cshomework.codeschoolandroidlessons.playmarket.ui.base.OnItemClickListener
import com.cshomework.codeschoolandroidlessons.playmarket.ui.base.activity.BasePlayMarketActivity

open class BasePlayMarketFragment : Fragment(), OnItemClickListener {

    fun replaceFragment(activity: BasePlayMarketActivity, resId: Int, fragment: Fragment) {
        activity.replaceFragment(fragment, resId)
    }

    override fun onItemClicked(item: BaseItemType) {
//        when (item) {
//            is GamesCategoryDto -> {
//                Toast.makeText(requireContext(), "${item.title} item clicked", Toast.LENGTH_SHORT).show()
//            }
//            is AppsCategoriesDto -> {
//                Toast.makeText(requireContext(), "${item.title} item clicked", Toast.LENGTH_SHORT).show()
//            }
//            is GameTopChartsDto -> {
//                Toast.makeText(requireContext(), "${item.title} item clicked", Toast.LENGTH_SHORT).show()
//            }
//            is AppsTopChartsDto -> {
//                Toast.makeText(requireContext(), "${item.title} item clicked", Toast.LENGTH_SHORT).show()
//            }
//            is GamesKidsDto -> {
//                Toast.makeText(requireContext(), "${item.title} item clicked", Toast.LENGTH_SHORT).show()
//            }
//            is AppsKidsDto -> {
//                Toast.makeText(requireContext(), "${item.title} item clicked", Toast.LENGTH_SHORT).show()
//            }
//            is GameForYouDto -> {
//                Toast.makeText(requireContext(), "${item.title} item clicked", Toast.LENGTH_SHORT).show()
//            }
//            is AppsForYouDto -> {
//                Toast.makeText(requireContext(), "${item.title} item clicked", Toast.LENGTH_SHORT).show()
//            }
//            else -> Unit
//        }
        Toast.makeText(requireContext(), "${item.title} item clicked", Toast.LENGTH_SHORT).show()
    }
}