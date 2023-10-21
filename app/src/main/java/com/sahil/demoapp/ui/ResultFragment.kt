package com.sahil.demoapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sahil.demoapp.R
import com.sahil.demoapp.base.BaseFragment
import com.sahil.demoapp.databinding.FragmentResultBinding


class ResultFragment : BaseFragment<FragmentResultBinding>() {
    override fun layoutId(): Int {
        return R.layout.fragment_result
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val score=requireArguments().getString("total")
        binding.scoreCard.text="Total Correct Answers are :\n\n ${score}"
    }

}