package com.maktbesharif.maktab_1402_11_1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap
import java.time.temporal.TemporalQueries

interface PhotosService {
    @GET("services/rest")
//    fun getPhotos(@Query("api_key") apiKey:String,
//                  @Query("user_id") userId:String,
//                  @Query("extras") extras:String,
//                  @Query("format") format:String,
//                  @Query("nojsoncallback") noJsonCallback:Int,
//                  @Query("per_page") perPage:Int,
//                  @Query("page") page:Int,
//                  @Query("method") method:String): Call<Photos>

    fun getPhotos(@QueryMap queries: Map<String, String>): Call<Photos>
}