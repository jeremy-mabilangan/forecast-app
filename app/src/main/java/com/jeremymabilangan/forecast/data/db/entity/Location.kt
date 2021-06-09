package com.jeremymabilangan.forecast.data.db.entity

data class Location(
    val country: String,
    val lat: String,
    val localtime: String,
    val lon: String,
    val name: String,
    val region: String
)