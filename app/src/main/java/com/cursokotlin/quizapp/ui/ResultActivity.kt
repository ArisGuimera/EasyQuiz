package com.cursokotlin.quizapp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cursokotlin.quizapp.CircularAnimation
import com.cursokotlin.quizapp.MainActivity
import com.cursokotlin.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    companion object {
        private const val RESULT_DATA = "result_data"
        private const val SIZE_DATA = "size_data"

        fun create(context: Context, result: Int, size: Int): Intent {
            return Intent(context, ResultActivity::class.java).apply {
                putExtra(RESULT_DATA, result)
                putExtra(SIZE_DATA, size)
            }
        }
    }

    private val count by lazy { intent.getIntExtra(RESULT_DATA, 0) }
    private val size by lazy { intent.getIntExtra(SIZE_DATA, 0) }
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        initListeners()
        showResult()
    }

    private fun showResult() {
        binding.tvResult.text = getTextFromResult(count)
        animateProgressResult(count)
    }

    private fun initListeners() {
        binding.btnBack.setOnClickListener { resetTest() }
    }

    private fun animateProgressResult(count:Int){
        val result = (count*100)/size
        val anim = CircularAnimation( progressBar = binding.pbLvl, to = result)
        anim.duration = 1000
        binding.pbLvl.startAnimation(anim)
    }

    private fun getTextFromResult(count: Int): String {
        return when (count) {
            in 0..3 -> "JUNIOR"
            in 4..5 -> "MID"
            in 6..Int.MAX_VALUE -> "SENIOR DE MANUAL"
            else -> ""
        }
    }

    private fun resetTest(){
        startActivity(MainActivity.create(this))
    }

    override fun onBackPressed() {
        resetTest()
    }
}