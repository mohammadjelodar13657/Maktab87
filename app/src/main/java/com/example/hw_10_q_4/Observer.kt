package com.example.hw_10_q_4

import android.util.Log

class Observer(private val string: String): IObserver {
    private val tag = "$string received: "

    override fun sendItem(number: Int) {
        Log.d(tag, "$tag$number")
//        println("$tag$number")
    }

}