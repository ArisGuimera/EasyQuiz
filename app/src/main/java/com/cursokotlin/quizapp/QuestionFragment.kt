package com.cursokotlin.quizapp

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.cursokotlin.quizapp.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {

    private var _binding:FragmentQuestionBinding? = null
    private val binding get() = _binding!!

    private var listener: OnQuestionActionListener? = null


    lateinit var question:QuestionData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            question = it.getSerializable(INTENT_QUESTION) as QuestionData
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initQuestion(question)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestionBinding.inflate(inflater, container, false)
        return binding.root
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

    private fun checkIsCorrect(answer:AnswerData, button: Button){
        if(answer.isCorrect){
            button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.green))
        }else{
            button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.red))
        }
        disableAnswer()
        listener?.onAnswerClicked(answer)
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


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnQuestionActionListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    companion object {

        const val INTENT_QUESTION = "intent_question"

        @JvmStatic
        fun newInstance(question: QuestionData) =
            QuestionFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(INTENT_QUESTION, question)
                }
            }
    }
}