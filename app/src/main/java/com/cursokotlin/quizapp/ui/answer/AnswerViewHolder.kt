package com.cursokotlin.quizapp.ui.answer

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.cursokotlin.quizapp.AnswerData
import com.cursokotlin.quizapp.R

class AnswerViewHolder(view:View) : RecyclerView.ViewHolder(view) {

    val btnAnswer: Button = view.findViewById(R.id.btnAnswer)

    fun render(
        answerData: AnswerData,
        onAnswerSelected: (AnswerData, Int) -> Unit
    ){
        btnAnswer.text = answerData.title
        btnAnswer.setOnClickListener {
            onAnswerSelected(answerData, adapterPosition)
        }

    }
}