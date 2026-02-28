package com.example.weatherappmvi

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherCard(
    state: WeatherState,
    backgroundColor: androidx.compose.ui.graphics.Color,
    modifier: Modifier = Modifier
){
    Card(
        shape = CardDefaults.shape
    ) {
        state.weatherInfo?.currentWeatherData?.let { data ->
            Card() {
                Column() {
                    Text(
                        text = "Today ${
                            data.time.format(
                                DateTimeFormatter.ofPattern("HH:mm")
                            )
                        }",
                        modifier = Modifier.align(Alignment.End)
                    )
                }
            }
        }
    }

}