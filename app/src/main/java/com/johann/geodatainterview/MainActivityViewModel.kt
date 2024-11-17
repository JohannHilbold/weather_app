package com.johann.geodatainterview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johann.location.WeatherLocationUI
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private val currentLocation = MutableLiveData<WeatherLocationUI>()
    val currentLocationLiveData = currentLocation

    fun onLocationChanged(weatherLocation: WeatherLocationUI) {
        if(weatherLocation.addressLine != currentLocation.value?.addressLine) {
            viewModelScope.launch {
                currentLocation.value = weatherLocation
            }
        }
    }
}