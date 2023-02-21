package com.hfad.quizgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hfad.quizgame.databinding.ActivityCheatBinding

class Cheat : AppCompatActivity() {
    companion object {
        val KEY_RESULT = "KEY_RESULT"
    }
    private lateinit var binding: ActivityCheatBinding
    val question = Questions()
    var cheatResult = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.showQuestionText.text = intent?.getStringExtra(MainActivity.KEY_QUESTION)

        binding.showAnswerButton.setOnClickListener {
            cheatResult = false
            binding.showAnswerText.text = question.questionAnswers[Questions.tag]
        }
    }

    override fun onBackPressed() {
        val back = Intent(this, MainActivity::class.java)
            .putExtra(KEY_RESULT, cheatResult)
        setResult(RESULT_OK, back)
        finish()
    }
}