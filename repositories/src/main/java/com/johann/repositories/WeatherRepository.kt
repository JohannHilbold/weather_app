package com.johann.repositories

import com.johann.repositories.network.DataResult
import com.johann.repositories.network.GeoDataDispatchers
import com.johann.repositories.network.RequestHelper
import kotlinx.coroutines.withContext

class WeatherRepository(
    private val requestHelper: RequestHelper,
    private val api: WeatherApiService
) {
    suspend fun getWeatherAtPoint(
        latitude: Double,
        longitude: Double,
    ): DataResult<out WeatherDto> = withContext(GeoDataDispatchers.io) {
        requestHelper.tryRequest {
            api.getWeatherAtPoint(latitude, longitude)
        }
    }
}