package com.hfad.quizgame

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.hfad.quizgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val questions = Questions()
    private lateinit var answer: String

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.questionText.text = questions.sendQuestion()

        binding.prevButton.isEnabled = questions.tag != 0

        binding.trueButton.setOnClickListener {
            binding.answerText.text =
                questions.sendScore(binding.trueButton.text.toString()).toString()
            disableTrueFalseButton()
            showCorrectness()
        }

        binding.falseButton.setOnClickListener {
            binding.answerText.text =
                questions.sendScore(binding.falseButton.text.toString()).toString()
            disableTrueFalseButton()
            showCorrectness()
        }

        binding.prevButton.setOnClickListener {
            binding.nextButton.isEnabled = true
            questions.tag--
            binding.prevButton.isEnabled = questions.tag != 0
            disableTrueFalseButton()
            show()
        }

        binding.nextButton.setOnClickListener {
            binding.prevButton.isEnabled = true
            questions.tag++
            binding.nextButton.isEnabled = questions.tag != 9
            disableTrueFalseButton()
            show()
        }

        binding.cheatButton.setOnClickListener {
            val question = binding.questionText.text.toString()
            val cheatPage = Intent(this, Answer::class.java)
                .putExtra("KEY_QUESTION", question)
            startActivity(cheatPage)
        }
    }

    fun show() {
        binding.questionText.text = questions.sendQuestion()
    }

    fun disableTrueFalseButton() {
        binding.falseButton.isEnabled = questions.userAnswers[questions.tag].isEmpty()
        binding.trueButton.isEnabled = questions.userAnswers[questions.tag].isEmpty()
    }

    fun showCorrectness() {
        Toast.makeText(this, questions.userAnswers[questions.tag], Toast.LENGTH_SHORT).show()
    }

    val question =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            when (result.resultCode) {

            }
        }
}