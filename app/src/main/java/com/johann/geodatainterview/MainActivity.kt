package com.johann.geodatainterview

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentActivity
import com.johann.developerutils.WeatherLocationActivity
import com.johann.location.WeatherLocationRequest
import com.johann.weather.WeatherFragment

class MainActivity : FragmentActivity(), WeatherLocationActivity {
    private val LOCATION_PERMISSION_REQUEST_CODE = 1000
    val viewModel by lazy { MainActivityViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val ft = supportFragmentManager.beginTransaction()
        val weatherFragment = WeatherFragment.newInstance(59.0978744, 9.7050231,"Kloppevegen 5, 3943 Porsgrunn, Norway")
        ft.add(R.id.fragment_container, weatherFragment)
        ft.commit()

        viewModel.currentLocationLiveData.observe(this) {
            weatherFragment.updateLocation(it.addressLine, it.latitude, it.longitude)
        }

        setupLocationUpdate()
    }

    private fun setupLocationUpdate() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        } else {
            WeatherLocationRequest.startLocationUpdates(this, viewModel::onLocationChanged)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                WeatherLocationRequest.startLocationUpdates(this, viewModel::onLocationChanged)
            } else {
                // Permission denied, maybe show some toast about enabling location
            }
        }
    }

    override fun searchLocation(searchedLocation: String) {
        WeatherLocationRequest.searchLocation(this, searchedLocation) { location ->
            WeatherLocationRequest.stopLocationUpdates()
            viewModel.onLocationChanged(location)
        }
    }

    override fun requestLocationRefresh() {
        WeatherLocationRequest.startLocationUpdates(this, viewModel::onLocationChanged)
    }


}
