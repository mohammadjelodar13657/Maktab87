package com.hfad.quizgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.hfad.quizgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        val KEY_QUESTION = "KEY_QUESTION"
    }

    val questions = Questions()
    private var answer = 0
    var isUserCheated = false

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.questionText.text = questions.sendQuestion()

        binding.prevButton.isEnabled = Questions.tag != 0

        binding.trueButton.setOnClickListener {
            binding.answerText.text =
                questions.showScore(binding.trueButton.text.toString())
            disableTrueFalseCheatButtons()
            showAnswerCorrectness()
        }

        binding.falseButton.setOnClickListener {
            binding.answerText.text =
                questions.showScore(binding.falseButton.text.toString())
            disableTrueFalseCheatButtons()
            showAnswerCorrectness()
        }

        binding.prevButton.setOnClickListener {
            binding.nextButton.isEnabled = true
            Questions.tag--
            binding.prevButton.isEnabled = Questions.tag != 0
            disableTrueFalseCheatButtons()
            showQuestions()
        }

        binding.nextButton.setOnClickListener {
            binding.prevButton.isEnabled = true
            Questions.tag++
            binding.nextButton.isEnabled = Questions.tag != 9
            disableTrueFalseCheatButtons()
            showQuestions()
        }

        binding.cheatButton.setOnClickListener {
            val question = binding.questionText.text.toString()
            val cheatPage = Intent(this, Cheat::class.java)
                .putExtra(KEY_QUESTION, question)
            cheatResult.launch(cheatPage)
        }
    }

    fun showQuestions() {
        binding.questionText.text = questions.sendQuestion()
    }

    fun disableTrueFalseCheatButtons() {
        binding.falseButton.isEnabled = questions.userAnswers[Questions.tag].isEmpty()
        binding.trueButton.isEnabled = questions.userAnswers[Questions.tag].isEmpty()
        binding.cheatButton.isEnabled = questions.userAnswers[Questions.tag].isEmpty()
    }

    fun showAnswerCorrectness() {
        if(questions.cheatList[Questions.tag]) {
            Toast.makeText(this, questions.userAnswers[Questions.tag], Toast.LENGTH_SHORT).show()
        }
        else if(!questions.cheatList[Questions.tag] && questions.userAnswers[Questions.tag] == "Wrong") {
            Toast.makeText(this, questions.userAnswers[Questions.tag], Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this, "Cheating is wrong!", Toast.LENGTH_SHORT).show()
        }
    }

    val cheatResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val x = it.data?.extras?.getBoolean(Cheat.KEY_RESULT)!!
            if (it.resultCode == RESULT_OK) {
                questions.cheatList[Questions.tag] = x
            }
        }


}