package com.cursokotlin.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

import com.cursokotlin.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnQuestionActionListener {

    private lateinit var binding: ActivityMainBinding
    private val questions = QuestionProvider.getQuestions()
    private var count:Int = 0
    private var questionPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showNewQuestion(questions.first())
        binding.tvPoints.text = "$count puntos."

        binding.btnReset.setOnClickListener {
            count = 0
            questionPosition = 0
            showNewQuestion(questions.first())
        }
    }

    private fun setPoints() {
        count += 1
        binding.tvPoints.text = "$count puntos."
    }

    private fun nextQuestion() {
        questionPosition += 1
        if(questions.size <= questionPosition) return
        showNewQuestion(questions[questionPosition])
    }

    private fun showNewQuestion(questionData: QuestionData) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
        fragmentTransaction.replace(R.id.container, QuestionFragment.newInstance(questionData))
        fragmentTransaction.commit()
    }

    override fun onAnswerClicked(answer:AnswerData) {
        Handler().postDelayed(
            {
                updateView(answer)
            },
            400 // value in milliseconds
        )
    }

    private fun updateView(answer: AnswerData) {
        if(answer.isCorrect){
            setPoints()
        }
        nextQuestion()
    }


}