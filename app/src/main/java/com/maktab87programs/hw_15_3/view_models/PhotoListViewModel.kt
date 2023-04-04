package com.maktab87programs.hw_15_3.view_models

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.maktab87programs.hw_15_3.data_models.TwentyImageDataModel
import okhttp3.*
import java.io.IOException

class PhotoListViewModel: ViewModel() {
    private val _image = MutableLiveData<TwentyImageDataModel>()
    val image: LiveData<TwentyImageDataModel> = _image

    fun run(url: String) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(ContentValues.TAG, "onFailure: no Image")
                println("Failed to execute request")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                val gson = Gson()
                val data = gson.fromJson(body, TwentyImageDataModel::class.java)
                _image.postValue(data)
                Log.e(ContentValues.TAG, "onResponse: $data")
                println(data)
            }
        })
    }
}