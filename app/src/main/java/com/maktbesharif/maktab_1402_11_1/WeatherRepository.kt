package com.maktbesharif.maktab_1402_11_1

import com.maktbesharif.maktab_1402_11_1.weather.Weather
import retrofit2.Call
import retrofit2.http.Query
import javax.inject.Inject


class WeatherRepository @Inject constructor(private val weatherSend: WeatherSend) {

//    fun getWeather(
//        @Query("q") city: String,
//        @Query("appid") appid: String,
//        @Query("units") units: String,
//        @Query("lang") language: String
//    ): Call<Weather>

    fun getWeather(city: String, appid: String, units: String, language: String): Call<Weather> {
        return weatherSend.getWeather(city, appid, units, language)
    }
}