package com.johann.location


import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Build
import android.os.Looper
import android.util.Log
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices

object WeatherLocationRequest {

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback

    fun startLocationUpdates(context: Context, callback: (WeatherLocationUI) -> Unit) {
        val locationRequest = LocationRequest.Builder(10000).build()

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                for (location in locationResult.locations) {
                    val geocoder = Geocoder(context)
                    val listener = Geocoder.GeocodeListener { addresses ->
                        Log.d("Location", "Address: ${addresses[0]?.getAddressLine(0)}")
                        callback(WeatherLocationUI(
                            addresses[0]?.getAddressLine(0)?:"N/A",
                            "",
                            location.latitude,
                            location.longitude)
                        )
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        geocoder.getFromLocation(location.latitude, location.longitude, 1, listener)
                    } else {
                        val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)
                        Log.d("Location", "Address: ${addresses?.get(0)?.getAddressLine(0)}")
                        callback(WeatherLocationUI(addresses?.get(0)?.countryName?:"N/A",addresses?.get(0)?.locality?:"N/A", location.latitude, location.longitude))
                    }
                }
            }
        }
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            fusedLocationClient.requestLocationUpdates(
                locationRequest,
                locationCallback,
                Looper.getMainLooper()
            )
        }
    }

    fun searchLocation(context: Context, searchedLocation: String, callback: (WeatherLocationUI) -> Unit) {
        val geocoder = Geocoder(context)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val listener = Geocoder.GeocodeListener { addresses ->
                Log.d("Location", "Address: ${addresses[0]?.getAddressLine(0)}")
                callback(WeatherLocationUI(
                    addresses[0]?.getAddressLine(0)?:"N/A",
                    "",
                    addresses[0]?.latitude?:0.0,
                    addresses[0]?.longitude?:0.0)
                )
            }
            geocoder.getFromLocationName(searchedLocation, 1, listener)
        } else {
            val addresses = geocoder.getFromLocationName(searchedLocation, 1)
            Log.d("Location", "Address: ${addresses?.get(0)?.getAddressLine(0)}")
            callback(WeatherLocationUI(addressLine = addresses?.get(0)?.countryName?:"N/A",
                city = addresses?.get(0)?.locality?:"N/A",
                latitude = addresses?.get(0)?.latitude?:0.0,
                longitude = addresses?.get(0)?.longitude?:0.0))
        }
    }

    fun stopLocationUpdates() {
        fusedLocationClient.removeLocationUpdates(locationCallback)
        locationCallback = object : LocationCallback() {}
    }
}
