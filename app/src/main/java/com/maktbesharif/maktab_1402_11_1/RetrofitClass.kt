//package com.maktbesharif.maktab_1402_11_1
//
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//object RetrofitClass {
//    val retrofit = Retrofit.Builder()
//        .baseUrl("https://api.openweathermap.org/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    val weatherSend = retrofit.create(WeatherSend::class.java)
//
//
//
//
//}