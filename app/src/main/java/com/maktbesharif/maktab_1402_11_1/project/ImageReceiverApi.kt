package com.maktbesharif.maktab_1402_11_1.project

import retrofit2.Call
import retrofit2.http.GET

interface ImageReceiverApi {
    @GET("list?limit=20")
    fun getImages(): Call<List<GetImageList>>
}