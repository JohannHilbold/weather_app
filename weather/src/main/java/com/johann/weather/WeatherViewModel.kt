package com.johann.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johann.repositories.WeatherDto
import com.johann.repositories.WeatherRepository
import com.johann.repositories.network.DataResult
import com.johann.weather.mappers.WeatherMapper
import com.johann.weather.ui.WeatherUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepository, private val mapper: WeatherMapper) : ViewModel() {
    private val _weatherUi: MutableStateFlow<WeatherUiState> = MutableStateFlow(WeatherUiState.LAUNCH)
    val weatherUi : StateFlow<WeatherUiState> = _weatherUi

    fun publishWeather(addressLine: String?, latitude: Double?, longitude: Double?) {
        _weatherUi.value = WeatherUiState.LAUNCH
        viewModelScope.launch {
            if(latitude == null || longitude == null) {
                _weatherUi.value = WeatherUiState.Error("Invalid latitude or longitude")
                return@launch
            }
            when(val weather = getWeatherAtPoint(latitude, longitude)) {
                is DataResult.Success -> publishSuccess(addressLine, latitude, longitude, weather.data)
                is DataResult.Error -> handleError(weather.err)
            }
        }
    }

    private fun handleError(exception: Throwable?) {
        _weatherUi.value = WeatherUiState.Error("Sorry ! An error has occurred. ${exception?.message}")
    }

    private fun publishSuccess(addressLine: String?, latitude: Double?, longitude: Double?, data: WeatherDto) {
        _weatherUi.value = WeatherUiState.Success(mapper.map(addressLine, latitude, longitude, data))
    }

    private suspend fun getWeatherAtPoint(latitude: Double, longitude: Double) = repository.getWeatherAtPoint(latitude, longitude)
}