package com.jeremymabilangan.forecast.data.response

import com.google.gson.annotations.SerializedName
import com.jeremymabilangan.forecast.data.db.entity.CurrentWeatherEntry
import com.jeremymabilangan.forecast.data.db.entity.Location
import com.jeremymabilangan.forecast.data.db.entity.Request


data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location,
    val request: Request
)