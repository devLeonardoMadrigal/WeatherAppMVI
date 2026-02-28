package com.example.weatherappmvi.data.remote

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.weatherappmvi.domain.WeatherInfo
import com.example.weatherappmvi.domain.WeatherResponse
import com.example.weatherappmvi.domain.repository.WeatherRepository
import com.example.weatherappmvi.domain.util.Resource
import jakarta.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(
        lat: Double,
        long: Double
    ): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "Unknown Error")
        }
    }

}