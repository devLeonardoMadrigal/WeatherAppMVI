package com.example.weatherappmvi.data.remote

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.weatherappmvi.domain.WeatherData
import com.example.weatherappmvi.domain.WeatherInfo
import com.example.weatherappmvi.domain.WeatherType
import java.time.LocalDateTime
import java.time.LocalDateTime.parse
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDataDto.toWeatherDataMap() : Map<Int,List<WeatherData>>{
    return time.mapIndexed { index, string ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]

        IndexWeatherData(
        index = index,
        data = WeatherData(
            time = parse(string, DateTimeFormatter.ISO_DATE_TIME),            temperatureCelsius = temperature,
            windSpeed = windSpeed,
            pressure = pressure,
            humidity = humidity,
            weatherType = WeatherType.fromWMO(weatherCode)
        ))
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map { it.data }
    }
}


private data class IndexWeatherData(
    val index: Int,
    val data: WeatherData

)


@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDto.toWeatherInfo() : WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if(now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }

    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}