package com.example.codeschoolandroidlessons.playmarket.ui.base.bottomsheetdialog

import android.widget.Toast
import com.example.codeschoolandroidlessons.playmarket.data.base.BaseItemType
import com.example.codeschoolandroidlessons.playmarket.ui.base.OnItemClickListener
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

open class BaseBottomSheetFragmentDialog : BottomSheetDialogFragment(), OnItemClickListener {
    override fun onItemClicked(item: BaseItemType) {
        Toast.makeText(requireContext(), "${item.title} item clicked", Toast.LENGTH_SHORT).show()
    }
}