package com.example.hw_10_q_4

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import kotlin.concurrent.thread

class Observable: IObservable, DefaultLifecycleObserver {

    private val numbersList = (1..100).toMutableList()
    private val observersList = mutableListOf<IObserver>()

    private var stopThread = true

    override fun add(observer: Observer) {
        observersList.add(observer)
    }

    override fun register() {
        thread {
            while (stopThread) {
                broadcast(numbersList[0])
                remove()

            }
        }
    }

    override fun unRegister() {
        stopThread = false
    }

    override fun broadcast(number: Int) {
        for(observer in observersList) {
            observer.sendItem(number)
            Thread.sleep(3000)
        }
    }

    override fun remove() {
        numbersList.removeAt(0)
    }

    override fun onPause(owner: LifecycleOwner) {
        unRegister()
    }

    override fun onResume(owner: LifecycleOwner) {
        stopThread = true
        register()
    }
}