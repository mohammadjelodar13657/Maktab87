package com.hfad.quizgame

class Questions {

    var tag = 0
    var wrongScore = 0
    var score = 0

    var questionsList = listOf(
       "Alexander Fleming discovered penicillin?",
        "The black box in a plane is black?",
        "There are 219 episodes of Friends?",
        "'A' is the most common letter used in the English language?",
        "A lion's roar can be heard up to eight kilometres away?",
        "Monaco is the smallest country in the world?",
        "There are five different blood groups?",
        "Coffee is made from berries?",
        "An octopus has three hearts?",
        "Thomas Edison discovered gravity?",
    )

    val questionAnswers = listOf("True", "False", "False", "False", "True", "False", "False", "True", "True", "False")
    val userAnswers = mutableListOf("","","","","","","","","","")

    fun sendQuestion(): String {
        return questionsList[tag]
    }

    fun sendScore(answer: String): Int {
        if(questionAnswers[tag] == answer) {
            score++
            userAnswers[tag] = "Correct"
        }
        else {
            wrongScore++
            if(wrongScore % 3 == 0 && score > 0) score--
            userAnswers[tag] = "Wrong"
        }
        return score
    }

}