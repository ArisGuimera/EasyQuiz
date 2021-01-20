package com.cursokotlin.quizapp.ui.answer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cursokotlin.quizapp.AnswerData
import com.cursokotlin.quizapp.R

class AnswerAdapter(
    val answer: List<AnswerData>,
    val onAnswerSelected: (AnswerData, Int) -> Unit
): RecyclerView.Adapter<AnswerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AnswerViewHolder(layoutInflater.inflate(R.layout.item_answer, parent, false))
    }

    override fun getItemCount(): Int = answer.size

    override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        val item = answer[position]
        holder.render(item, onAnswerSelected)
    }

    fun disableOptions(){

    }
}