package com.hfad.photogallery

import com.hfad.photogallery.data.PhotoData
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApiService {
    companion object {
        const val BASE_URL = "https://www.flickr.com/services/rest/"
    }

    // https://www.flickr.com/services/rest?api_key=1c04e05bce6e626247758d120b372a73&method=flickr.photos.getPopular&user_id=34427466731@N01&extras=url_s&format=json&nojsoncallback=1&per_page=100&page=1
    @GET("/services/rest/")
    suspend fun getPopularPhotos(
        @Query("method") method: String = "flickr.photos.getPopular",
        @Query("api_key") apiKey: String,
        @Query("user_id") userId: String,
        @Query("extras") extras: String = "url_s",
        @Query("format") format: String = "json",
        @Query("nojsoncallback") noJsonCallback: Int = 1,
        @Query("per_page") perPage: Int = 100,
        @Query("page") page: Int = 1
    ): PhotoData
}