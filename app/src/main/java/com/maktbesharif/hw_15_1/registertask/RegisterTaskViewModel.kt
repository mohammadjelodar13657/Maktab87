package com.maktbesharif.hw_15_1.registertask

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterTaskViewModel : ViewModel() {

    var status = true
    val name = MutableLiveData<String>()
    val numberOfTasks = MutableLiveData<String>()
    val _checkFields = MutableLiveData<String>()
    val checkFields: LiveData<String>
        get() = _checkFields

    fun check() {
        if (name.value.isNullOrEmpty()) {
            status = false
            _checkFields.value = "Enter a name"
        } else if (numberOfTasks.value.isNullOrEmpty()) {
            status = false
            _checkFields.value = "Enter a number"
        } else {
            status = true
        }
    }
}