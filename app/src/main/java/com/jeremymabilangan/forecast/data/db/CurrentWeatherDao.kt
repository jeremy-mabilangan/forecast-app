package com.jeremymabilangan.forecast.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jeremymabilangan.forecast.data.db.entity.CURRENT_WEATHER_ID
import com.jeremymabilangan.forecast.data.db.entity.CurrentWeatherEntry
import com.jeremymabilangan.forecast.data.db.unitlocalized.current.ImpMetCurrentWeatherEnter
import com.jeremymabilangan.forecast.data.db.unitlocalized.current.UnitSpecificCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: CurrentWeatherEntry)

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherEntry(): LiveData<ImpMetCurrentWeatherEnter>
}