package com.johann.weather.koin

import android.app.Application
import org.koin.androidx.viewmodel.dsl.viewModel
import com.johann.repositories.RepositoryModule
import com.johann.weather.WeatherViewModel
import com.johann.weather.mappers.WeatherMapper
import org.koin.dsl.module

object WeatherKoinModules {
    fun getModules(context: Application) =
        RepositoryModule.createModules(context)
            .plus(module {
                single { WeatherMapper(context) }
                viewModel { WeatherViewModel(get(), get()) }
            })

}