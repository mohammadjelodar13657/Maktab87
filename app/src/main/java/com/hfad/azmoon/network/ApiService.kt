package com.hfad.azmoon.network

import retrofit2.http.GET
import retrofit2.http.QueryMap


interface ApiService {

    @GET(".")
    suspend fun getMovieItems(
        @QueryMap options: Map<String, String>
    ): MovieResponse

}
