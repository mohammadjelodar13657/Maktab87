package com.hfad.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUp: AppCompatActivity() {

    private lateinit var usernameTextView: TextView
    private lateinit var passwordTextView: TextView
    private lateinit var signUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Set title in actionbar
        title = "SignUp"

        usernameTextView = findViewById(R.id.userNameSignup)
        passwordTextView = findViewById(R.id.passwordSignup)
        signUp = findViewById(R.id.signUp2)

        usernameTextView.text = intent?.getStringExtra("USERNAME")
        passwordTextView.text = intent?.getStringExtra("PASSWORD")


        signUp.setOnClickListener {
            if(usernameTextView.text.toString().isEmpty()) {
                usernameTextView.setHintTextColor(Color.parseColor("#ba181b"))
                usernameTextView.hint = "Enter username"
                Toast.makeText(this, "Enter username", Toast.LENGTH_LONG).show()
            }
            else if(passwordTextView.text.toString().isEmpty()) {
                passwordTextView.setHintTextColor(Color.parseColor("#ba181b"))
                passwordTextView.hint = "Enter password"
                Toast.makeText(this, "Enter password", Toast.LENGTH_LONG).show()
            }
            else {
                val username = usernameTextView.text.toString()
                val password = passwordTextView.text.toString()
                val signupIntent = Intent()
                signupIntent.putExtra("USERNAME", username)
                signupIntent.putExtra("PASSWORD", password)
                setResult(RESULT_OK, signupIntent)
                finish()
            }
        }
    }



}