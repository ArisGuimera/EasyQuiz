package com.cursokotlin.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.cursokotlin.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val questions = QuestionProvider.getQuestions()
    private var count:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initQuestion(questions)
        setPoints()
    }

    private fun setPoints() {
        count += 1
        binding.tvPoints.text = "$count puntos."
    }

    private fun initQuestion(questions: QuestionData) {
        initImageQuestion(questions.header)
        initTitleQuestion(questions.title)
        initAnswerQuestion(questions.answers)
    }

    private fun initAnswerQuestion(answers: List<AnswerData>) {
        if (answers.size == 4) {
            binding.btn1.text = answers[0].title
            binding.btn2.text = answers[1].title
            binding.btn3.text = answers[2].title
            binding.btn4.text = answers[3].title


            binding.btn1.setOnClickListener {
                checkIsCorrect(answers[0], binding.btn1)
            }
            binding.btn2.setOnClickListener {
                checkIsCorrect(answers[1], binding.btn2)
            }
            binding.btn3.setOnClickListener {
                checkIsCorrect(answers[2], binding.btn3)
            }
            binding.btn4.setOnClickListener {
                checkIsCorrect(answers[3], binding.btn4)
            }
        }
    }

    private fun checkIsCorrect(answer:AnswerData, button:Button){
        if(answer.isCorrect){
            button.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
            setPoints()
        }else{
            button.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
        }
        disableAnswer()
    }

    private fun disableAnswer(){
        binding.btn4.isEnabled = false
        binding.btn3.isEnabled = false
        binding.btn2.isEnabled = false
        binding.btn1.isEnabled = false
    }

    private fun initTitleQuestion(title: String) {
        binding.tvQuestion.text = title
    }

    private fun initImageQuestion(header: String) {
        if (header.isNotEmpty()) {
            Glide.with(this).load(header).into(binding.ivHeader)
        }
    }
}