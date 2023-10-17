package com.sahil.demoapp.vm

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.sahil.demoapp.R
import com.sahil.demoapp.model.TopicModel
import com.sahil.demoapp.ui.dashboard.adapter.TopicAdapter
import com.sahil.demoapp.utils.getJsonData
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(@ApplicationContext val context: Context) : ViewModel() {
    @Inject
    lateinit var adapter: TopicAdapter

    var topicList= ArrayList<String>()

    fun getTopicList()  {
        val text=context.getJsonData(R.raw.topic)
        val model = Gson().fromJson<TopicModel>(text, TopicModel::class.java)
        Timber.e("Dashboard Fragment adapter: ${model}")
       adapter.submitList(model.topics as ArrayList<String>)
    }
}