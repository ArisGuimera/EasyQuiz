package com.cursokotlin.quizapp

data class QuestionData(val header:String, val title:String, val answers:List<AnswerData>)
data class AnswerData(val title:String, val isCorrect:Boolean)