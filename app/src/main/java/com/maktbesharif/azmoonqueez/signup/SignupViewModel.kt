package com.maktbesharif.azmoonqueez.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignupViewModel: ViewModel() {

    var username = MutableLiveData("")
    var email = MutableLiveData("")
    var password = MutableLiveData("")
    var retypedPassword = MutableLiveData("")
    var status = true

    fun checkSignupStatus(): String {
        if(username.value?.isEmpty()!!) {
            status = false
            return "Enter username"
        } else if (email.value?.isEmpty()!!) {
            status = false
            return "Enter email"
        } else if(password.value?.isEmpty()!!) {
            status = false
            return "Enter password"
        } else if(retypedPassword.value != password.value) {
            status = false
            return "Retyped password is not match"
        }
        else {
            status = true
            return "Account created"
        }
    }
}