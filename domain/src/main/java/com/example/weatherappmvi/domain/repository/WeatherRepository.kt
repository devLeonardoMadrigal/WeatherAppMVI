package com.example.weatherappmvi.domain.repository

import com.example.weatherappmvi.domain.WeatherData
import com.example.weatherappmvi.domain.WeatherInfo
import com.example.weatherappmvi.domain.WeatherResponse
import com.example.weatherappmvi.domain.util.Resource

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double) : Resource<WeatherInfo>
}