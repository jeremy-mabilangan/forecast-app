package com.jeremymabilangan.forecast.ui.weather.current

import androidx.lifecycle.ViewModel
import com.jeremymabilangan.forecast.data.repository.ForecastRepository

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {

}