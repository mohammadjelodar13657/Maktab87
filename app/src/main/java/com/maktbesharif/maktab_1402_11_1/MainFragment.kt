package com.maktbesharif.maktab_1402_11_1

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.maktbesharif.maktab_1402_11_1.databinding.FragmentMainBinding
import com.maktbesharif.maktab_1402_11_1.weather.Weather
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class MainFragment: Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private val weatherViewModel: WeatherViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        weatherViewModel.getWeather("Tehran")

        weatherViewModel.weatherLiveData.observe(viewLifecycleOwner
        ) { t ->
            t!!.enqueue(object : Callback<Weather> {
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
}