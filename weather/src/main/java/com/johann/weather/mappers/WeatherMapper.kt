package com.johann.weather.mappers

import android.content.Context
import com.johann.repositories.WeatherDto
import com.johann.style.getWeatherIcon
import com.johann.weather.R
import com.johann.weather.ui.WeatherUi

class WeatherMapper(private val context: Context) {

fun map(addressLine: String?, latitude: Double?, longitude: Double?, data: WeatherDto) = WeatherUi(
    addressLine = addressLine?:"N/A",
    latitude = "" + (latitude ?: "N/A"),
    longitude = "" + (longitude?: "N/A"),
    temperature = "" + data.properties.timeSeries.first().data.instant.details.airTemperature + " " + transformTemperatureUnit(data.properties.meta.units.airTemperature),
    humidity = "" + data.properties.timeSeries.first().data.instant.details.relativeHumidity + " " + data.properties.meta.units.relativeHumidity,
    windSpeed = "" + data.properties.timeSeries.first().data.instant.details.windSpeed + " " + data.properties.meta.units.windSpeed,
    weatherDescription = getWeatherString(
        data.properties.timeSeries.first().data.next12hours?.summary?.symbolCode ?: "N/A"
    ),
    weatherIcon = getWeatherIcon(
        data.properties.timeSeries.first().data.next12hours?.summary?.symbolCode ?: "N/A"
    )
)
private fun transformTemperatureUnit(unit: String) = when (unit) {
    "celsius" -> "°C"
    "fahrenheit" -> "°F"
    else -> "Unknown"
}
private fun getWeatherString(data: String) = when (data) {
    "clearsky_day" -> context.getString(R.string.clearsky_day)
    "Clear sky" -> context.getString(R.string.clearsky_night)
    "clearsky_night" -> context.getString(R.string.clearsky_night)
    "clearsky_polartwilight" -> context.getString(R.string.clearsky_polartwilight)
    "fair_day" -> context.getString(R.string.fair_day)
    "fair_night" ->  context.getString(R.string.fair_night)
    "fair_polartwilight" -> context.getString(R.string.fair_polartwilight)
    "partlycloudy_day" -> context.getString(R.string.partlycloudy_day)
    "partlycloudy_night" -> context.getString(R.string.partlycloudy_night)
    "partlycloudy_polartwilight" -> context.getString(R.string.partlycloudy_polartwilight)
    "cloudy" -> context.getString(R.string.cloudy)
    "lightrainshowers_day" -> context.getString(R.string.lightrainshowers_day)
    "lightrainshowers_night" -> context.getString(R.string.lightrainshowers_night)
    "lightrainshowers_polartwilight" -> context.getString(R.string.lightrainshowers_polartwilight)
    "rainshowers_day" -> context.getString(R.string.rainshowers_day)
    "rainshowers_night" -> context.getString(R.string.rainshowers_night)
    "rainshowers_polartwilight" -> context.getString(R.string.rainshowers_polartwilight)
    "heavyrainshowers_day" -> context.getString(R.string.heavyrainshowers_day)
    "heavyrainshowers_night" -> context.getString(R.string.heavyrainshowers_night)
    "heavyrainshowers_polartwilight" -> context.getString(R.string.heavyrainshowers_polartwilight)
    "lightrainshowersandthunder_day" -> context.getString(R.string.lightrainshowersandthunder_day)
    "lightrainshowersandthunder_night" -> context.getString(R.string.lightrainshowersandthunder_night)
    "lightrainshowersandthunder_polartwilight" -> context.getString(R.string.lightrainshowersandthunder_polartwilight)
    "rainshowersandthunder_day" -> context.getString(R.string.rainshowersandthunder_day)
    "rainshowersandthunder_night" ->    context.getString(R.string.rainshowersandthunder_night)
    "rainshowersandthunder_polartwilight" -> context.getString(R.string.rainshowersandthunder_polartwilight)
    "heavyrainshowersandthunder_day" -> "Heavy rain showers and thunder"
    "heavyrainshowersandthunder_night" -> "Heavy rain showers and thunder"
    "heavyrainshowersandthunder_polartwilight" -> "Heavy rain showers and thunder"
    "lightsleetshowers_day" -> "Light sleet showers"
    "lightsleetshowers_night" -> "Light sleet showers"
    "lightsleetshowers_polartwilight" -> "Light sleet showers"
    "sleetshowers_day" -> "Sleet showers"
    "sleetshowers_night" -> "Sleet showers"
    "sleetshowers_polartwilight" -> "Sleet showers"
    "heavysleetshowers_day" -> "Heavy sleet showers"
    "heavysleetshowers_night" -> "Heavy sleet showers"
    "heavysleetshowers_polartwilight" -> "Heavy sleet showers"
    "lightssleetshowersandthunder_day" -> "Light sleet showers and thunder"
    "lightssleetshowersandthunder_night" -> "Light sleet showers and thunder"
    "lightssleetshowersandthunder_polartwilight" -> "Light sleet showers and thunder"
    "sleetshowersandthunder_day" -> "Sleet showers and thunder"
    "sleetshowersandthunder_night" -> "Sleet showers and thunder"
    "sleetshowersandthunder_polartwilight" -> "Sleet showers and thunder"
    "heavysleetshowersandthunder_day" -> "Heavy sleet showers and thunder"
    "heavysleetshowersandthunder_night" -> "Heavy sleet showers and thunder"
    "heavysleetshowersandthunder_polartwilight" -> "Heavy sleet showers and thunder"
    "lightsnowshowers_day" -> "Light snow showers"
    "lightsnowshowers_night" -> "Light snow showers"
    "lightsnowshowers_polartwilight" -> "Light snow showers"
    "snowshowers_day" -> "Snow showers"
    "snowshowers_night" -> "Snow showers"
    "snowshowers_polartwilight" -> "Snow showers"
    "heavysnowshowers_day" -> "Heavy snow showers"
    "heavysnowshowers_night" -> "Heavy snow showers"
    "heavysnowshowers_polartwilight" -> "Heavy snow showers"
    "lightssnowshowersandthunder_day" -> "Light snow showers and thunder"
    "lightssnowshowersandthunder_night" -> "Light snow showers and thunder"
    "lightssnowshowersandthunder_polartwilight" -> "Light snow showers and thunder"
    "snowshowersandthunder_day" -> "Snow showers and thunder"
    "snowshowersandthunder_night" -> "Snow showers and thunder"
    "snowshowersandthunder_polartwilight" -> "Snow showers and thunder"
    "heavysnowshowersandthunder_day" -> "Heavy snow showers and thunder"
    "heavysnowshowersandthunder_night" -> "Heavy snow showers and thunder"
    "heavysnowshowersandthunder_polartwilight" -> "Heavy snow showers and thunder"
    "lightrain" -> "Light rain"
    "rain" -> "Rain"
    "heavyrain" -> "Heavy rain"
    "lightrainandthunder" -> "Light rain and thunder"
    "rainandthunder" -> "Rain and thunder"
    "heavyrainandthunder" -> "Heavy rain and thunder"
    "lightsleet" -> "Light sleet"
    "sleet" -> "Sleet"
    "heavysleet" -> "Heavy sleet"
    "lightsleetandthunder" -> "Light sleet and thunder"
    "sleetandthunder" -> "Sleet and thunder"
    "heavysleetandthunder" -> "Heavy sleet and thunder"
    "lightsnow" -> "Light snow"
    "snow" -> "Snow"
    "heavysnow" -> "Heavy snow"
    "lightsnowandthunder" -> "Light snow and thunder"
    "snowandthunder" -> "Snow and thunder"
    "heavysnowandthunder" -> "Heavy snow and thunder"
    "fog" -> "Fog"
    else -> "Unknown"
}
}
