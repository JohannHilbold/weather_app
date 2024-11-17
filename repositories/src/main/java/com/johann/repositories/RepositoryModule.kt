package com.johann.repositories

import android.app.Application
import com.johann.repositories.network.ApiServiceFactoryImpl
import com.johann.repositories.network.ConnectionService
import com.johann.repositories.network.RequestHelper
import com.johann.repositories.network.ConnectionServiceImpl
import org.koin.dsl.module

object RepositoryModule {
    fun createModules(context: Application) = listOf(

        module {
            single { ApiServiceFactoryImpl(context) }
            factory<ConnectionService> { ConnectionServiceImpl(context) }
            single { RequestHelper(get()) }
            factory { WeatherRepository(get(), (get() as ApiServiceFactoryImpl).createService(),) }
        },
        )
}