package com.maktbesharif.maktab_1402_11_1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maktbesharif.maktab_1402_11_1.weather.Weather
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: WeatherRepository): ViewModel() {

    private val _weatherLiveData = MutableLiveData<Call<Weather>>()
    val weatherLiveData: LiveData<Call<Weather>> = _weatherLiveData

    fun getWeather(city: String) {
        _weatherLiveData.value = repository.getWeather(city, "f7f6e5f2328755ec0ab93205c769e521", "metric", "fa")
    }
}