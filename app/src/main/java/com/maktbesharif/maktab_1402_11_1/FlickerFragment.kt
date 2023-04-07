package com.maktbesharif.maktab_1402_11_1

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.maktbesharif.maktab_1402_11_1.di.Flicker
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class FlickerFragment: Fragment(R.layout.fragment_flicker) {

    @Flicker
    @Inject
    lateinit var flickerRetrofit: PhotosService

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val queriesMap = HashMap<String, String>().apply {
            put("api_key", "1c04e05bce6e626247758d120b372a73")
            put("method", "flickr.photos.getPopular")
            put("user_id", "34427466731@N01")
            put("extras", "url_s")
            put("format", "json")
            put("nojsoncallback", "1")
            put("per_page", "100")
            put("page", "1")
        }

        val call = flickerRetrofit.getPhotos(queriesMap)

        call.enqueue(object: Callback<Photos>{
            override fun onResponse(call: Call<Photos>, response: Response<Photos>) {
                Log.d(TAG, "onResponse: ${response.body()}")
            }

            override fun onFailure(call: Call<Photos>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}