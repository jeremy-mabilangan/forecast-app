package com.jeremymabilangan.forecast.data.repository

import androidx.lifecycle.LiveData
import com.jeremymabilangan.forecast.data.db.unitlocalized.current.ImpMetCurrentWeatherEnter
import com.jeremymabilangan.forecast.data.db.unitlocalized.current.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {

    suspend fun getCurrentWeather(metric: Boolean) : LiveData<ImpMetCurrentWeatherEnter>
}