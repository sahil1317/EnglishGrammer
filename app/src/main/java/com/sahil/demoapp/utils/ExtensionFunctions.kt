package com.sahil.demoapp.utils

import android.content.Context
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sahil.demoapp.R
import org.w3c.dom.Text
import timber.log.Timber
import java.lang.Exception


@BindingAdapter("rcAdapter")
fun setRecycler(recyclerView:RecyclerView,rcAdapter:RecyclerView.Adapter<*>?){
    Timber.e("RecyclerView Adapter: ${rcAdapter}")
    recyclerView.adapter= rcAdapter
}

fun Context.getJsonData(fileName:Int): String?{
    return try {
        resources.openRawResource(fileName)
            .bufferedReader().use { it.readText() }
    }catch (e:Exception){
        null
    }

}