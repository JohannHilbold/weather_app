package com.johann.weather.ui

import com.johann.repositories.WeatherDto

sealed class WeatherUiState {
    class Success(val data: WeatherUi) : WeatherUiState()
    class Error(val errorMessage: String) : WeatherUiState()

    data object LAUNCH: WeatherUiState()
}

