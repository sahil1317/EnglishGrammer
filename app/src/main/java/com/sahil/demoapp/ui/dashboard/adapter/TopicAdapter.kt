package com.sahil.demoapp.ui.dashboard.adapter

import com.sahil.demoapp.R
import com.sahil.demoapp.base.BaseAdapter
import com.sahil.demoapp.databinding.ItemLayoutBinding
import com.sahil.demoapp.model.Topic
import com.sahil.demoapp.model.TopicModel
import javax.inject.Inject


class TopicAdapter @Inject constructor(): BaseAdapter<Topic,ItemLayoutBinding>() {
    lateinit var callback:TopicClickListener

    override fun layoutId(): Int {
        return R.layout.item_layout
    }
    fun setClick(callback:TopicClickListener){
        this.callback=callback
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener{
            callback?.onclick(list[position])
        }
    }

    interface TopicClickListener{
        fun onclick(item:Topic)
    }
}