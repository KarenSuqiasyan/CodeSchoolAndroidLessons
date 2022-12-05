package com.cshomework.codeschoolandroidlessons.playmarket.ui.home.fragments.top_charts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.common.codeschoolandroidlessons.databinding.FragmentPlaymarketBottomSheetDialogBinding
import com.cshomework.codeschoolandroidlessons.playmarket.data.base.BaseItemType
import com.cshomework.codeschoolandroidlessons.playmarket.ui.adapters.BaseAdapter
import com.cshomework.codeschoolandroidlessons.playmarket.ui.base.bottomsheetdialog.BaseBottomSheetFragmentDialog

class BottomSheetFragmentDialog(dataList: MutableList<BaseItemType>) : BaseBottomSheetFragmentDialog() {

    private lateinit var binding: FragmentPlaymarketBottomSheetDialogBinding
    private var mDataList = dataList

    private val baseAdapter: BaseAdapter by lazy {
        BaseAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlaymarketBottomSheetDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bottomSheetDialogRecyclerView.apply {
            adapter = baseAdapter
            baseAdapter.updateData(mDataList)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(dataList: MutableList<BaseItemType>) = BottomSheetFragmentDialog(dataList)
    }
}