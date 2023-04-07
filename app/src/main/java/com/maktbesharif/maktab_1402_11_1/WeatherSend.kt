package com.maktbesharif.maktab_1402_11_1

import com.maktbesharif.maktab_1402_11_1.weather.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherSend {
    @GET("data/2.5/weather")
    fun getWeather(
        @Query("q") city: String,
        @Query("appid") appid: String,
        @Query("units") units: String,
        @Query("lang") language: String
    ): Call<Weather>
}