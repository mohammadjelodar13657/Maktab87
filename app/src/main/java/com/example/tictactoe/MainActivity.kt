package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var name: String = ""
    private lateinit var playerName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        supportActionBar?.hide()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playerName = findViewById(R.id.playerName)

        name = DefinePlayer().definePlayer()

        val definePlayer = findViewById<Button>(R.id.definePlayer).setOnClickListener {
            playerName.text = name
        }

        val startGame = findViewById<Button>(R.id.start).setOnClickListener {
            val openActivitySecond = Intent(this, SecondActivity::class.java)
//            if(name == "Player1") openActivitySecond.putExtra("EXTRA_NUMBER", 0)
//            else openActivitySecond.putExtra("EXTRA_NUMBER", 1)
            openActivitySecond.putExtra("EXTRA_TEXT", name)
            startActivity(openActivitySecond)
        }

//        playerName.text = savedInstanceState?.getString("PLAYER")
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        val playerName = playerName.text.toString()
        savedInstanceState.putString("PLAYER", playerName)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        playerName.text = savedInstanceState.getString("PLAYER")
    }
}