package com.example.hw_10_q_4

interface IObservable {

    fun add(observer: Observer)

    fun remove()

    fun register()

    fun unRegister()

    fun broadcast(number: Int)

}