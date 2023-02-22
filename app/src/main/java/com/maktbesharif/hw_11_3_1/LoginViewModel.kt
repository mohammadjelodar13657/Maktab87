package com.maktbesharif.hw_11_3_1

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    var username = MutableLiveData<String>("")
//    var user = ""
    var password = MutableLiveData<String>("")
//    var pass = ""

//    fun checkLoginStatus(): String {
//        return if (username.value?.isEmpty()!!) {
//            "Enter username"
//        }
//        else if (password.value?.isEmpty()!!) {
//            "Enter password"
//        } else if(signup.username.value?.isEmpty()!! || signup.password.value?.isEmpty()!!) {
//            "No account"
//        } else if (signup.username.value == username.value && signup.password.value == password.value) {
//            "Login successfully"
//        } else {
//            "Wrong username or password"
//        }
//    }


}