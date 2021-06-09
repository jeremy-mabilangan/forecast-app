package com.jeremymabilangan.forecast.data.network

import androidx.lifecycle.LiveData
import com.jeremymabilangan.forecast.data.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        type: String
    )
}