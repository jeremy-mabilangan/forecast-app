package com.jeremymabilangan.forecast.data.repository

import androidx.lifecycle.LiveData
import com.jeremymabilangan.forecast.data.db.CurrentWeatherDao
import com.jeremymabilangan.forecast.data.db.unitlocalized.current.ImpMetCurrentWeatherEnter
import com.jeremymabilangan.forecast.data.network.WeatherNetworkDataSource
import com.jeremymabilangan.forecast.data.response.CurrentWeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.threeten.bp.ZonedDateTime

class ForecastRepositoryImpl(
    private val currentWeatherDao: CurrentWeatherDao,
    private val weatherNetworkDataSource: WeatherNetworkDataSource
) : ForecastRepository {

    init {
        weatherNetworkDataSource.apply {
            weatherNetworkDataSource.downloadedCurrentWeather.observeForever { newCurrentWeather ->
                persistFetchedCurrentWeather(newCurrentWeather)
            }

        }
    }
    override suspend fun getCurrentWeather(metric: Boolean): LiveData<ImpMetCurrentWeatherEnter> {
        return withContext(Dispatchers.IO) {
            return@withContext currentWeatherDao.getWeatherEntry()
        }
    }

    private fun persistFetchedCurrentWeather(fetchedWeather: CurrentWeatherResponse) {
        GlobalScope.launch(Dispatchers.IO) {
            currentWeatherDao.upsert(fetchedWeather.currentWeatherEntry)
        }
    }

    private suspend fun fetchCurrentWeather() {
        weatherNetworkDataSource.fetchCurrentWeather(
            "Los Angeles",
            "f"
        )
    }

    private fun isFetchCurrentNeeded(lastFetchTime: ZonedDateTime): Boolean {
        val thirtyMinutesAgo = ZonedDateTime.now().minusMinutes(30)
        return lastFetchTime.isBefore(thirtyMinutesAgo)
    }
}