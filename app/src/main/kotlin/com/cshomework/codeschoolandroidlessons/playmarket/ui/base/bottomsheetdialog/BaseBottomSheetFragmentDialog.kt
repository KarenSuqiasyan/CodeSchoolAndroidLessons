package com.cshomework.codeschoolandroidlessons.playmarket.ui.base.bottomsheetdialog

import android.widget.Toast
import com.cshomework.codeschoolandroidlessons.playmarket.data.base.BaseItemType
import com.cshomework.codeschoolandroidlessons.playmarket.ui.base.OnItemClickListener
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

open class BaseBottomSheetFragmentDialog : BottomSheetDialogFragment(), OnItemClickListener {
    override fun onItemClicked(item: BaseItemType) {
        Toast.makeText(requireContext(), "${item.title} item clicked", Toast.LENGTH_SHORT).show()
    }
}