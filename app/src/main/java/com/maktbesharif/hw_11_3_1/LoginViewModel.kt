package com.maktbesharif.hw_11_3_1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    val username = MutableLiveData<String>("")
    val password = MutableLiveData<String>("")


}