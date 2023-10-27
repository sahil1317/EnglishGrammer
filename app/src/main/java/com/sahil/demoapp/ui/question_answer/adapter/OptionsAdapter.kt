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
        if(list[position].isSelected!=true){
            holder.mBinding.optionTv.setTextColor(holder.itemView.context.getColor(R.color.white))
            holder.mBinding.optionLayout.setCardBackgroundColor(holder.itemView.context.getColor(R.color.black))

        }else{
            holder.mBinding.optionTv.setTextColor(holder.itemView.context.getColor(R.color.white))
            holder.mBinding.optionLayout.setCardBackgroundColor(holder.itemView.context.getColor(R.color.green))
        }

        holder.mBinding.optionTv.text=list[position].option
        holder.itemView.setOnClickListener{
         callback.onclick(list[position],position)
            Timber.e("Check_Click---> ${Gson().toJson(list)}")
        }
    }

    interface TopicClickListener{
        fun onclick(item: Options,position: Int)
    }
}