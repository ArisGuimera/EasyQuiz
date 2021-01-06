package com.cursokotlin.quizapp

class QuestionProvider {
    companion object {
        fun getQuestions(): List<QuestionData> {

            return listOf(
                QuestionData(
                    header = "https://cursokotlin.com/wp-content/uploads/2020/09/Webp.net-compress-image.jpg",
                    title = "Usamos la palabra reservada var para...",
                    answers = listOf(
                        AnswerData(title = "Variable", isCorrect = true),
                        AnswerData(title = "Valor constante", isCorrect = false),
                        AnswerData(title = "Crear una función", isCorrect = false),
                        AnswerData(title = "Compilar la app", isCorrect = false)
                    )
                ),
                QuestionData(
                    header = "https://i.pinimg.com/564x/e1/7e/13/e17e13c695f6c35d4756d7da29b6bf7f.jpg",
                    title = "Esto es una prueba",
                    answers = listOf(
                        AnswerData(title = "Variable", isCorrect = true),
                        AnswerData(title = "Valor constante", isCorrect = false),
                        AnswerData(title = "Crear una función", isCorrect = false),
                        AnswerData(title = "Compilar la app", isCorrect = false)
                    )
                ),
                QuestionData(
                    header = "https://i2.wp.com/thehappening.com/wp-content/uploads/2018/12/sombreros-perritos-7.jpg?fit=1024%2C694&ssl=1",
                    title = "Esto es una prueba",
                    answers = listOf(
                        AnswerData(title = "adw", isCorrect = true),
                        AnswerData(title = "adwd constante", isCorrect = false),
                        AnswerData(title = "dwad una función", isCorrect = false),
                        AnswerData(title = "Compilar dawd app", isCorrect = false)
                    )
                ),
                QuestionData(
                    header = "https://cursokotlin.com/wp-content/uploads/2020/09/Webp.net-compress-image.jpg",
                    title = "adw...",
                    answers = listOf(
                        AnswerData(title = "Variable", isCorrect = true),
                        AnswerData(title = "Valor constante", isCorrect = false),
                        AnswerData(title = "Crear una función", isCorrect = false),
                        AnswerData(title = "Compilar la app", isCorrect = false)
                    )
                ),
                QuestionData(
                    header = "https://i.pinimg.com/564x/e1/7e/13/e17e13c695f6c35d4756d7da29b6bf7f.jpg",
                    title = "Esto es dqwdba",
                    answers = listOf(
                        AnswerData(title = "Variable", isCorrect = true),
                        AnswerData(title = "Valor constante", isCorrect = false),
                        AnswerData(title = "Crear una función", isCorrect = false),
                        AnswerData(title = "Compilar la app", isCorrect = false)
                    )
                ),
                QuestionData(
                    header = "https://i2.wp.com/thehappening.com/wp-content/uploads/2018/12/sombreros-perritos-7.jpg?fit=1024%2C694&ssl=1",
                    title = "Esto es unqwdeueba",
                    answers = listOf(
                        AnswerData(title = "adw", isCorrect = true),
                        AnswerData(title = "adwd constante", isCorrect = false),
                        AnswerData(title = "dwad una función", isCorrect = false),
                        AnswerData(title = "Compilar dawd app", isCorrect = false)
                    )
                )
            )
        }
    }
}