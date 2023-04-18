package com.maktab87programs.taskmanager

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {



    private var status = 0
    val admin = User("Mohammad",
            "Jelodar",
            "mohammad.jelodar",
            "mohammad.jelodar@gmail.com",
            "84646574")

    val userList = arrayListOf<User>()

    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val userName = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val result = MutableLiveData<String>()
    val loginUserName = MutableLiveData<String>()
    val loginPassword = MutableLiveData<String>()
//    val user = User(firstName.value, lastName.value, userName.value, email.value, password.value)

    fun checkFields(): Int {

        return if (firstName.value.isNullOrEmpty()) {
            result.value = "Enter First Name"
            2
        } else if (lastName.value.isNullOrEmpty()) {
            result.value = "Enter Last Name"
            3
        } else if (userName.value.isNullOrEmpty()) {
            result.value = "Enter Username"
            4
        } else if (email.value.isNullOrEmpty()) {
            result.value = "Enter Email"
            5
        } else if (password.value.isNullOrEmpty()) {
            result.value = "Enter Password"
            6
        } else 0

        for (user in userList) {
            if (user.userName == userName.value || user.email == email.value) {
                return 1
            }
        }
    }

    fun findUserInList(): User? {
        for(user in userList) {
            if(user.userName == loginUserName.value) {
                Log.e("TAG", "findUserInList: ${user.userName}, ${user.password}", )
                return user
            }
        }
        return null
    }

    fun checkLogin(): Int {

        return if(loginUserName.value.isNullOrEmpty()) {
            0
        } else if(loginPassword.value.isNullOrEmpty()) {
            1
        } else if(loginUserName.value == admin.userName && loginPassword.value == admin.password) {
            2
        } else if(findUserInList() != null && findUserInList()?.password == loginPassword.value ) {
            3
        } else 4
    }

    fun addUserToList() {
        userList.add(User(firstName.value, lastName.value, userName.value, email.value, password.value))
    }

    init {
        userList.add(admin)
    }
}