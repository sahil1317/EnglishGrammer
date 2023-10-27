package com.sahil.demoapp.model

 data class TopicModel(
    val topics: List<Topic>
)

data class Topic(
    val questions: List<Question>,
    val topic_name: String
)

data class Question(  
    val answer: String,
    val description: String,
    val question: String,
    val option: List<String>,
    val title: String
)
data class Options(val option:String,var isSelected: Boolean)