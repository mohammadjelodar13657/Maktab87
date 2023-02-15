package com.example.hw_10_q_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleOwner


class MainActivity : AppCompatActivity(), LifecycleOwner {
    private val observable = Observable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("", "onCreate")
        Log.e("", "onCreate")


        val firstObserver = Observer("firstObserver")
        val secondObserver = Observer("secondObserver")
        val thirdObserver = Observer("thirdObserver")


        observable.add(firstObserver)
        observable.add(secondObserver)
        observable.add(thirdObserver)

        lifecycle.addObserver(observable)
    }
}