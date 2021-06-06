package com.jeremymabilangan.forecast.data.db.unitlocalized.current

import androidx.room.ColumnInfo

data class ImpMetCurrentWeatherEnter(
    @ColumnInfo(name = "temperature")
    override val temperature: Double,
    @ColumnInfo(name = "weatherDescriptions")
    override val weatherDescriptions: String,
    @ColumnInfo(name = "weatherIcons")
    override val weatherIcons: String,
    @ColumnInfo(name = "windSpeed")
    override val windSpeed: Double,
    @ColumnInfo(name = "windDir")
    override val windDirection: String,
    @ColumnInfo(name = "precip")
    override val precipitationVolume: Double,
    @ColumnInfo(name = "visibility")
    override val visibilityDistance: Double,
    @ColumnInfo(name = "isDay")
    override val isDay: String
) : UnitSpecificCurrentWeatherEntry