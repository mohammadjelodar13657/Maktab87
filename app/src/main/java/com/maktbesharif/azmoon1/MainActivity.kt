package com.maktbesharif.azmoon1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.maktbesharif.azmoon1.databinding.ActivityMainBinding
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import okhttp3.ResponseBody
import org.json.JSONObject


//import okhttp3.*
//import okio.IOException


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://api.github.com/users/MENasri23")
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val result = response.body?.string()
                runOnUiThread {
                    binding.textView.text = result
                }
            }
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }
        })



        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(GitHubService::class.java)
        service.getUser().enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            // Handle failure
            }
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                val json = response.body()?.string()
                val jsonObject = JSONObject(json)
                val value = jsonObject.getString("avatar_url")
                Glide.with(this@MainActivity)
                    .load(value)
                    .into(binding.imageView)
                runOnUiThread {
                    binding.textView.text = json
                }
            }
        })
    }
}

interface GitHubService {
    @GET("users/MENasri23")
    fun getUser(): Call<ResponseBody>
}