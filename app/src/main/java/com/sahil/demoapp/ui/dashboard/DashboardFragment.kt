package com.sahil.demoapp.ui.dashboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.gson.Gson
import com.sahil.demoapp.R
import com.sahil.demoapp.base.BaseFragment
import com.sahil.demoapp.databinding.FragmentDashboardBinding
import com.sahil.demoapp.model.TopicModel
import com.sahil.demoapp.ui.dashboard.adapter.TopicAdapter
import com.sahil.demoapp.utils.getJsonData
import com.sahil.demoapp.vm.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject


@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private val vm: DashboardViewModel by viewModels()


    override fun layoutId(): Int {
        return R.layout.fragment_dashboard
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm=vm
        Log.e("Dashboard","Dashboard fragment")
        vm.getTopicList()
    }
}