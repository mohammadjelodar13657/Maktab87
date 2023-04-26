package com.hfad.photogallery

import com.hfad.photogallery.FlickrApiService.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FlickrApiClient {

    private const val BASE_URL = "https://www.flickr.com"

    fun getInterceptor(): HttpLoggingInterceptor {
        val okInterceptor =  HttpLoggingInterceptor()
        okInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return okInterceptor
    }

    private val okHttp = OkHttpClient.Builder()
        .addInterceptor(getInterceptor()).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttp)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: FlickrApiService = retrofit.create(FlickrApiService::class.java)
}