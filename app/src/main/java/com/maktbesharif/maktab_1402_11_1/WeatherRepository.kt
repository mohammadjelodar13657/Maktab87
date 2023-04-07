package com.maktbesharif.maktab_1402_11_1

import com.maktbesharif.maktab_1402_11_1.di.Flicker
import com.maktbesharif.maktab_1402_11_1.weather.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap
import javax.inject.Inject


class WeatherRepository @Inject constructor(
    private val weatherSend: WeatherSend,
    private val photosService: PhotosService
) {

    @com.maktbesharif.maktab_1402_11_1.di.Weather
    fun getWeather(city: String, appid: String, units: String, language: String): Call<Weather> {
        return weatherSend.getWeather(city, appid, units, language)
    }

    @Flicker
    fun getPhotos(
        queries: Map<String, String>
    ): Call<Photos> {
        return  photosService.getPhotos(queries)
    }

}