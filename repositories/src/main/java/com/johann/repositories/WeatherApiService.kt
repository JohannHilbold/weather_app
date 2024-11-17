package com.johann.repositories

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherApiService {

    //https://api.met.no/weatherapi/locationforecast/2.0/compact?lat=60.10&lon=9.58
    @Headers("Accept: application/json")
    @GET("/weatherapi/locationforecast/2.0/compact")
    suspend fun getWeatherAtPoint(@Query("lat") latitude: Double, @Query("lon") longitude: Double): WeatherDto

}