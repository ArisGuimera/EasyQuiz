package com.cursokotlin.quizapp

class QuestionProvider {
    companion object {
        fun getQuestions(): QuestionData {
            val question = QuestionData(
                header = "https://cursokotlin.com/wp-content/uploads/2020/09/Webp.net-compress-image.jpg",
                title = "El mejor amigo del hombre es...",
                answers = listOf(
                    AnswerData(title = "Perro", isCorrect = true),
                    AnswerData(title = "Gato", isCorrect = false),
                    AnswerData(title = "Elefante", isCorrect = false),
                    AnswerData(title = "Triceratops", isCorrect = false)
                )
            )
            return question
        }
    }
}