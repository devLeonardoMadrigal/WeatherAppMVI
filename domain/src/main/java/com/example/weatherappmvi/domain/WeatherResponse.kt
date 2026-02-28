package com.example.weatherappmvi.domain

sealed class WeatherResponse {
    object Loading : WeatherResponse()
    data class Error(val msg : String) : WeatherResponse()
    data class Success(val todos : List<WeatherData>) : WeatherResponse()
}