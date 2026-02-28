package com.example.weatherappmvi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappmvi.domain.repository.WeatherRepository
import com.example.weatherappmvi.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set

    fun loadWeatherInfo() {
        println("LOADING")
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
                when(val result = repository.getWeatherData(53.0, 13.0)) {
                    is Resource.Error-> {
                        println("ERROR ${result}")
                        state = state.copy(
                            weatherInfo = null,
                            isLoading = false,
                            error = "Error loading data"
                        )
                    }
                    is Resource.Success -> {
                        state = state.copy(
                            weatherInfo = result.data,
                            isLoading = false,
                            error = null
                        )
                    }
                }?: kotlin.run {
                    state = state.copy(
                        isLoading = false,
                        error = "Error loading"
                    )
                }

        }



    }
}