package com.hfad.photogallery

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//class RetrofitInstance {
//
//    companion object {
//
//        const val BASE_URL = "https://www.flickr.com"
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val apiService: FlickrApiService by lazy {
//            retrofit.create(FlickrApiService::class.java)
//        }
//    }
//}

object FlickrApiClient {

    private const val BASE_URL = "https://www.flickr.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: FlickrApiService = retrofit.create(FlickrApiService::class.java)
}