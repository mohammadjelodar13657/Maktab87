package com.maktbesharif.hw_11_3_2

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel: ViewModel() {

    var status = true
    var fullName = ""
    var username = ""
    var email = ""
    var password = ""
    var reTypePassword = ""
    var gender = ""

    fun checkDataStatus(): String {
        return if (fullName.isEmpty()) {
            status = false
            "Enter full name"
//            Toast.makeText(this, "Enter full name", Toast.LENGTH_SHORT).show()
        }
        else if (username.length <= 6) {
            status = false
            "Enter username"
//            binding.username.setText("")
//            Toast.makeText(this, "Enter username", Toast.LENGTH_SHORT).show()
        }
        else if (email.isEmpty() || !email.contains('@')) {
            status = false
            "Incorrect email"
//            binding.email.setText("")
//            Toast.makeText(this, "Incorrect email", Toast.LENGTH_SHORT).show()
        }
        else if (password.length <= 8) {
            status = false
            "Enter password more than 8 char"
//            binding.password.setText("")
//            Toast.makeText(this, "Enter password more than 8 char", Toast.LENGTH_SHORT).show()
        }
        else if (reTypePassword !=password) {
            status = false
            "Re-typed password is not match"
//            binding.reTypePassword.setText("")
//            Toast.makeText(this, "Re-typed password is not match", Toast.LENGTH_SHORT).show()
        }
        else {
            status = true
            "Data stored successfully"
//            val fullName = binding.fullName.text.toString()
//            val username = binding.username.text.toString()
//            val email = binding.email.text.toString()
//            val password = binding.password.text.toString()
//            val radioId = binding.radioGroup.checkedRadioButtonId
//            radioButton = findViewById(radioId)
//            val gender = radioButton.text.toString()
//            Toast.makeText(this, "Data stored successfully", Toast.LENGTH_SHORT).show()
        }
    }

}