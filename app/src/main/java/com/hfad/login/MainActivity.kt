package com.hfad.login

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.ScrollView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import com.hfad.login.databinding.ActivityMainBinding
import kotlin.math.log


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var usernameIntent: String = ""
    var passwordIntent: String = ""
    var usernameUI: String = ""
    var passwordUI: String = ""
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            usernameUI = binding.userNameLogin.text.toString()
            passwordUI = binding.passwordLogin.text.toString()
            if (usernameUI.isEmpty() || passwordUI.isEmpty()) {
                Log.e(TAG, "onCreate: inputEmpty")
                Snackbar.make(
                    binding.scrollLayout,
                    "You must register",
                    Snackbar.LENGTH_LONG
                )
                    .setTextColor(Color.parseColor("#ffffff"))
                    .setBackgroundTint(Color.parseColor("#003459"))
                    .setAction("Undo") {
                        Toast.makeText(this, "Enter username and password", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .show()
            } else if(usernameIntent.isEmpty() || passwordIntent.isEmpty() ) {
                Log.e(TAG, "onCreate: no account", )
                Snackbar.make(
                    binding.scrollLayout,
                    "No account",
                    Snackbar.LENGTH_LONG
                )
                    .setTextColor(Color.parseColor("#ffffff"))
                    .setBackgroundTint(Color.parseColor("#003459"))
                    .setAction("Undo") {}
                    .show()
            } else if(usernameIntent == usernameUI && passwordIntent == passwordUI) {
                Log.e(TAG, "onCreate: log in successful", )
                Snackbar.make(
                    binding.scrollLayout,
                    "log in successful",
                    Snackbar.LENGTH_INDEFINITE
                )
                    .setTextColor(Color.parseColor("#ffffff"))
                    .setBackgroundTint(Color.parseColor("#003459"))
                    .setAction("Undo") {}
                    .show()
            } else {
                Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show()
            }
        }

        binding.signup.setOnClickListener {
            val signUpIntent = Intent(this, SignUp::class.java)
            if (binding.userNameLogin.toString().isNotEmpty()) {
                signUpIntent.putExtra("USERNAME", binding.userNameLogin.text.toString())
                signUpIntent.putExtra("PASSWORD", binding.userNameLogin.text.toString())
            }
            registerForSignup.launch(signUpIntent)
        }


    }

    private val registerForSignup = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            usernameIntent = data?.getStringExtra("USERNAME")!!
            passwordIntent = data.getStringExtra("PASSWORD")!!
            binding.userNameLogin.setText(usernameIntent)
            binding.passwordLogin.setText(passwordIntent)
        }
    }

}