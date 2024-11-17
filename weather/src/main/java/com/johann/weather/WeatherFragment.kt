package com.johann.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.AbstractComposeView
import androidx.fragment.app.Fragment
import com.johann.style.WeatherAppTheme
import com.johann.developerutils.WeatherLocationActivity
import com.johann.weather.compose.WeatherScreen
import org.koin.androidx.viewmodel.ext.android.viewModel


private const val ARG_LATITUDE = "latitude"
private const val ARG_LONGITUDE = "longitude"
private const val ARG_ADDRESSLINE = "addressLine"


class WeatherFragment : Fragment() {
    private val viewModel: WeatherViewModel by viewModel()
    private var latitude: Double? = null
    private var longitude: Double? = null
    private var addressLine: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            latitude = it.getDouble(ARG_LATITUDE)
            longitude = it.getDouble(ARG_LONGITUDE)
            addressLine = it.getString(ARG_ADDRESSLINE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = object : AbstractComposeView(inflater.context) {
        @Composable
        override fun Content() {
            WeatherAppTheme {
                val ui by viewModel.weatherUi.collectAsState()
                WeatherScreen(ui,
                    onRefresh = {
                        if (activity is WeatherLocationActivity) {
                            (activity as WeatherLocationActivity).requestLocationRefresh()
                        }
                    },
                    onSearch = { searchedLocation ->
                        if (activity is WeatherLocationActivity) {
                            (activity as WeatherLocationActivity).searchLocation(searchedLocation)
                        }
                    })

                LaunchedEffect(key1 = null) {
                    viewModel.publishWeather(addressLine, latitude, longitude)
                }
            }
        }

    }

    fun updateLocation(addressLine: String, latitude: Double, longitude: Double) {
        this.latitude = latitude
        this.longitude = longitude
        viewModel.publishWeather(addressLine, latitude, longitude)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Double, param2: Double, param3: String) =
            WeatherFragment().apply {
                arguments = Bundle().apply {
                    putDouble(ARG_LATITUDE, param1)
                    putDouble(ARG_LONGITUDE, param2)
                    putString(ARG_ADDRESSLINE, param3)
                }
            }
    }
}