package com.sahil.demoapp.ui.dashboard.adapter

import com.sahil.demoapp.R
import com.sahil.demoapp.base.BaseAdapter
import com.sahil.demoapp.databinding.ItemLayoutBinding
import com.sahil.demoapp.model.TopicModel
import javax.inject.Inject


class TopicAdapter @Inject constructor(): BaseAdapter<String,ItemLayoutBinding>() {
    override fun layoutId(): Int {
        return R.layout.item_layout
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(list[position])
    }
}