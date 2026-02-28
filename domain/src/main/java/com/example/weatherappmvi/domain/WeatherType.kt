package com.example.weatherappmvi.domain

sealed class WeatherType {
    object ClearSky : WeatherType()
    object MainlyClear : WeatherType()
    object PartlyCloudy : WeatherType()
    object Overcast : WeatherType()
    object Foggy : WeatherType()
    object DepositingRimeFog : WeatherType()
    object LightDrizzle : WeatherType()
    object ModerateDrizzle : WeatherType()
    object DenseDrizzle : WeatherType()
    object LightFreezingDrizzle : WeatherType()
    object DenseFreezingDrizzle : WeatherType()
    object SlightRain : WeatherType()
    object ModerateRain : WeatherType()
    object HeavyRain : WeatherType()
    object HeavyFreezingRain: WeatherType()
    object SlightSnowFall: WeatherType()
    object ModerateSnowFall: WeatherType()
    object HeavySnowFall: WeatherType()
    object SnowGrains: WeatherType()
    object SlightRainShowers: WeatherType()
    object ModerateRainShowers: WeatherType()
    object ViolentRainShowers: WeatherType()
    object SlightSnowShowers: WeatherType()
    object HeavySnowShowers: WeatherType()
    object ModerateThunderstorm: WeatherType()
    object SlightHailThunderstorm: WeatherType()
    object HeavyHailThunderstorm: WeatherType()

    companion object {
        fun fromWMO(code: Int): WeatherType {
            return when(code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> ClearSky
            }
        }
    }
}