package com.sahil.demoapp.ui.question_answer.adapter

import com.google.gson.Gson
import com.sahil.demoapp.R
import com.sahil.demoapp.base.BaseAdapter
import com.sahil.demoapp.databinding.ItemLayoutBinding
import com.sahil.demoapp.databinding.OptionItemLayoutBinding
import com.sahil.demoapp.model.Options
import com.sahil.demoapp.model.Topic
import timber.log.Timber
import javax.inject.Inject

class OptionsAdapter @Inject constructor(): BaseAdapter<Options, OptionItemLayoutBinding>() {
    lateinit var callback:TopicClickListener

    override fun layoutId(): Int {
        return R.layout.option_item_layout
    }
    fun setClick(callback:TopicClickListener){
        this.callback=callback
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        holder.bind(list[position])

        holder.itemView.setOnClickListener{
            if(list[position].isSelected!=true){
                holder.mBinding.optionTv.setTextColor(holder.itemView.context.getColor(R.color.white))
                holder.mBinding.optionLayout.setCardBackgroundColor(holder.itemView.context.getColor(R.color.green))
            }else{
                holder.mBinding.optionTv.setTextColor(holder.itemView.context.getColor(R.color.white))
                holder.mBinding.optionLayout.setCardBackgroundColor(holder.itemView.context.getColor(R.color.black))
            }
            callback.onclick(list[position],position)
        }
    }

    interface TopicClickListener{
        fun onclick(item: Options,position: Int)
    }
}