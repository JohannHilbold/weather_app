package com.johann.weather.ui

data class WeatherUi(val addressLine: String,
                     val latitude: String,
                     val longitude: String,
                     val temperature: String,
                     val humidity: String,
                     val windSpeed: String,
                     val weatherDescription: String,
                     val weatherIcon: Int)
