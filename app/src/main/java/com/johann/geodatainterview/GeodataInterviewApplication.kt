package com.johann.geodatainterview

import android.app.Application
import com.johann.weather.koin.WeatherKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class GeodataInterviewApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Start Koin
        startKoin {
            androidContext(this@GeodataInterviewApplication)
            modules(WeatherKoinModules.getModules(this@GeodataInterviewApplication))
        }
    }
}