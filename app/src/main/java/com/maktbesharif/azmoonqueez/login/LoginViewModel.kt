package com.maktbesharif.azmoonqueez.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

//    lateinit var signupData: String


    var username = MutableLiveData<String>("")
    var signupUsername = MutableLiveData<String>("")

    var password = MutableLiveData<String>("")
    var signupPassword = MutableLiveData<String>("")

    var showSnackbar = MutableLiveData<String>()

    fun checkLoginStatus() {
        showSnackbar.value = if (username.value?.isEmpty()!!) {
           "Enter username"
        }
        else if (password.value?.isEmpty()!!) {
            "Enter password"
        } else if(signupUsername.value?.isEmpty()!! || signupPassword.value?.isEmpty()!!) {
            "No account"
        } else if (signupUsername.value == username.value && signupPassword.value == password.value) {
            "Login successfully"
        } else {
            "Wrong username or password"
        }
    }


}