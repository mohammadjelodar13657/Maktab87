package com.maktbesharif.maktab_1402_11_1

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.maktbesharif.maktab_1402_11_1.databinding.FragmentMainBinding
import com.maktbesharif.maktab_1402_11_1.weather.Weather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment: Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        val call = RetrofitClass.weatherSend.getWeather("Tehran", "f7f6e5f2328755ec0ab93205c769e521", "metric", "fa")

        call.enqueue(object: Callback<Weather>{
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                Log.d(TAG, "onResponse: ${response.body()!!.weather[0].description}")
                binding.tvCurrentWeather.text = response.body()!!.weather[0].main
                binding.tvCurrentTemp.text = response.body()!!.main.temp.toString()
                binding.tvWindSpeed.text = response.body()!!.wind.speed.toString()
                binding.tvHumidity.text = response.body()!!.main.humidity.toString()
                binding.tvPressure.text = response.body()!!.main.pressure.toString()
                binding.tvRainChance.text = response.body()!!.clouds.all.toString()
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}