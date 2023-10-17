package com.sahil.demoapp.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.sahil.demoapp.BR

abstract class BaseAdapter <T,K:ViewDataBinding>() : RecyclerView.Adapter<BaseAdapter<T,K>.MyHolder>() {

    lateinit var binding: K

    var list: ArrayList<T> = ArrayList()

 abstract  fun layoutId():Int
    inner class MyHolder(private val binding: K) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: T) {
            binding.setVariable(BR.model, item)
            binding.executePendingBindings()
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutId(), parent, false)

        return MyHolder(binding)
    }



    override fun getItemCount(): Int {
        return list.size
    }

    fun submitList(entities: ArrayList<T>) {
        list.clear()
        list.addAll(entities)
        this.notifyDataSetChanged()
    }


}

