package com.sahil.demoapp.ui.question_answer

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.sahil.demoapp.R
import com.sahil.demoapp.base.BaseFragment
import com.sahil.demoapp.databinding.FragmentQuestionAnswerBinding
import com.sahil.demoapp.vm.QuestionAnswerViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class QuestionAnswerFragment : BaseFragment<FragmentQuestionAnswerBinding>() {

    private val vm: QuestionAnswerViewModel by viewModels()

    override fun layoutId(): Int {
        return R.layout.fragment_question_answer
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.e("Question Answer fragment created")
        vm.fragment=this
        binding.vm=vm
        vm.getArgumentData(arguments)
    }

}