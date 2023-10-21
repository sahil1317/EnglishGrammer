package com.sahil.demoapp.vm

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.sahil.demoapp.R
import com.sahil.demoapp.model.Options
import com.sahil.demoapp.model.Topic
import com.sahil.demoapp.ui.question_answer.QuestionAnswerFragment
import com.sahil.demoapp.ui.question_answer.adapter.OptionsAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import java.text.FieldPosition
import javax.inject.Inject

@HiltViewModel
class QuestionAnswerViewModel @Inject constructor() : ViewModel() {

    var topic: Topic? = null
    var fragment: QuestionAnswerFragment? = null
    var questionNumber = 0
    @Inject
    lateinit var adapter: OptionsAdapter
    var correctAns=0

    var optionList = ArrayList<Options>()
    fun getArgumentData(bundle: Bundle?) {
        bundle?.let {
            val value = it.getString("questions")
            topic = Gson().fromJson(value, Topic::class.java)
            Timber.e("questions answers: ${topic}")
            setUiData()
        }
    }

    fun backPress(v: View) {
        fragment?.requireActivity()?.onBackPressed()
    }
    fun nextButtonPress(v: View) {
        if(fragment!!.binding.nextButton.text.equals("Check")) {
            val selectedItem = optionList.filter { it.isSelected }.mapTo(arrayListOf()) { it.option }.joinToString { it }.replace(" ", "")

            val item = topic!!.questions[questionNumber].answer
            if (selectedItem.equals(item)) {
                correctAns++
                Timber.e("dfjhafa True--- $correctAns")
                fragment!!.binding.correctAnswer.visibility=View.VISIBLE
                fragment!!.binding.correctAnswer.text="Your answer is Correct: ${topic!!.questions[questionNumber].description}"
                fragment!!.binding.correctAnswer.setTextColor(fragment!!.requireActivity().getColor(R.color.green))
            } else {
                Timber.e("dfjhafa false--- $correctAns")
                fragment!!.binding.correctAnswer.visibility=View.VISIBLE
                fragment!!.binding.correctAnswer.text=" Correct Answer is: ${topic!!.questions[questionNumber].description}"
                fragment!!.binding.correctAnswer.setTextColor(Color.RED)
            }
            fragment!!.binding.nextButton.text="Next"
        }else{
            if(topic!!.questions.size==questionNumber+1){
                val bundle=Bundle()
                bundle.putString("total","$correctAns")
                fragment!!.goNextFragment(R.id.action_questionAnswerFragment_to_resultFragment,bundle)
            }else{
                fragment!!.binding.correctAnswer.visibility=View.GONE
                questionNumber++
                setUiData()
                fragment!!.binding.nextButton.text="Check"

            }

        }

    }



    private fun setUiData() {

        fragment?.binding?.optionsRecycler?.adapter=adapter
        topic?.let {
            fragment?.binding?.questionTitle?.text = it.questions[questionNumber].title
            fragment?.binding?.questionTv?.text = "Q. ${it.questions[questionNumber].question}"
            optionList.clear()
            it.questions[questionNumber].option.forEach {
                optionList.add(Options(it,false))
            }
            adapter.submitList(optionList)
            adapter.setClick(object :OptionsAdapter.TopicClickListener{
                override fun onclick(item: Options,position: Int) {
                    item.isSelected = !item.isSelected
                    optionList.set(position,item)
                    adapter.notifyDataSetChanged()
                    adapter.notifyItemChanged(position)

                }
            })
        }
    }
}