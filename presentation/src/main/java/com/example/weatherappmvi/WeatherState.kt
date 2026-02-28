package com.example.weatherappmvi

import com.example.weatherappmvi.domain.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null

)
