package com.maktbesharif.hw_11_3_1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignupViewModel: ViewModel() {

    var username = MutableLiveData<String>("")
    var user = ""
    var password = MutableLiveData<String>("")
    var pass = ""
    var status = true

    fun checkSignupStatus(): String {
        if(username.value?.isEmpty()!!) {
            status = false
            return "Enter username"
        } else if(password.value?.isEmpty()!!) {
            status = false
            return "Enter password"
        } else {
            status = true
            return "Account created"
        }
    }
}