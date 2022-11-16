package com.example.codeschoolandroidlessons.playmarket.ui.fragments.top_charts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.codeschoolandroidlessons.databinding.FragmentBottomSheetDialogBinding
import com.example.codeschoolandroidlessons.playmarket.data.base.BaseItemType
import com.example.codeschoolandroidlessons.playmarket.ui.adapters.BaseAdapter
import com.example.codeschoolandroidlessons.playmarket.ui.base.bottomsheetdialog.BaseBottomSheetFragmentDialog

class BottomSheetFragmentDialog(dataList: MutableList<BaseItemType>) : BaseBottomSheetFragmentDialog() {

    private lateinit var binding: FragmentBottomSheetDialogBinding
    private var mDataList = dataList

    private val baseAdapter: BaseAdapter by lazy {
        BaseAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomSheetDialogBinding.inflate(inflater, container, false)
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