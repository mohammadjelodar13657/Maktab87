package com.hfad.photogallery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hfad.photogallery.FlickrApiClient.apiService
import com.hfad.photogallery.data.Photo
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FlickrViewModel : ViewModel() {
    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>>
    get() = _photos

    fun fetchPopularPhotos() {
        viewModelScope.launch {
            val response = apiService.getPopularPhotos (
                apiKey = "1c04e05bce6e626247758d120b372a73",
                method = "flickr.photos.getPopular",
                userId = "34427466731@N01",
                extras = "url_s",
                format = "json",
                noJsonCallback = 1,
                perPage = 100,
                page = 1
            )

            if (response.stat == "ok") {
                _photos.value = response.photos.photo
            } else {
                Log.i("MYTAG", "No Internet Connection!")
            }
        }
    }
}