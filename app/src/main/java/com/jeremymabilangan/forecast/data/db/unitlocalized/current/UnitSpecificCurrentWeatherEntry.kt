package com.jeremymabilangan.forecast.data.db.unitlocalized.current

interface UnitSpecificCurrentWeatherEntry {
    val temperature: Double
    val weatherDescriptions: String
    val weatherIcons: String
    val windSpeed: Double
    val windDirection: String
    val precipitationVolume: Double
    val visibilityDistance: Double
    val isDay: String
}