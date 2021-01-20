package com.cursokotlin.quizapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

import com.cursokotlin.quizapp.databinding.ActivityMainBinding
import com.cursokotlin.quizapp.ui.ResultActivity

class MainActivity : AppCompatActivity(), OnQuestionActionListener {

    //Color respuesta correcta/incorrecta
    //boton volver???
    //PUBLICIDAD
    //ICONO
    //TRADUCCIONES
    //NOMBRE APP

    companion object {
        fun create(context: Context): Intent {
            return Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
        }
    }

    private lateinit var binding: ActivityMainBinding
    private val questions = QuestionProvider.getQuestions()
    private var count:Int = 0
    private var questionPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        initToolbar()
        showNewQuestion(questions.first())
        binding.tvPoints.text = "$count puntos"
        updateSteps()
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Kotlin test"
    }

    private fun updateSteps() {
        binding.tvSteps.text = " ${questionPosition+1} de ${questions.size}"
    }

    private fun setPoints() {
        count += 1
        binding.tvPoints.text = "$count puntos"
    }

    private fun nextQuestion() {
        questionPosition += 1
        if(questions.size <= questionPosition){
            goToResult()
        }else{
            showNewQuestion(questions[questionPosition])
        }
    }

    private fun goToResult() {
        startActivity(ResultActivity.create(this, count, questions.size))
    }

    private fun showNewQuestion(questionData: QuestionData) {
        updateSteps()
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