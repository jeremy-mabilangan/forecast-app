package com.jeremymabilangan.forecast.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val CURRENT_WEATHER_ID = 0

@Entity(tableName = "current_weather")
data class CurrentWeatherEntry(
    val precip: Double,
    val visibility: Int,
    val temperature: Double,
    @SerializedName("weather_descriptions")
    val weatherDescriptions: List<String>,
    @SerializedName("weather_icons")
    val weatherIcons: List<String>,
    @SerializedName("wind_degree")
    val windDegree: Double,
    @SerializedName("wind_dir")
    val windDir: String,
    @SerializedName("wind_speed")
    val windSpeed: Double,
    @SerializedName("is_day")
    val isDay : String
) {
    @PrimaryKey(autoGenerate = false)
    var id : Int = CURRENT_WEATHER_ID
}