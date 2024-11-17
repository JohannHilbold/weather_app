package com.johann.repositories.network

import android.content.Context
import android.os.Build
import com.johann.repositories.R
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.text.DecimalFormatSymbols
import java.util.Locale
import java.util.concurrent.TimeUnit

class ApiServiceFactoryImpl(
    private val context: Context,
) : ApiServiceFactory {

    val okHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(addUserAgentInterceptor())
        .readTimeout(20, TimeUnit.SECONDS)
        .build()

    inline fun <reified T : Any> createService(): T =
        Retrofit.Builder()
            .baseUrl("https://api.met.no/")
            .addConverterFactory(MoshiConverterFactory.create(ApiServiceFactory.moshi))
            .client(okHttpClient)
            .build()
            .create(T::class.java)


    private fun addUserAgentInterceptor(): (Interceptor.Chain) -> Response {
        return { chain ->
            val request = chain.request().newBuilder()
            request.addHeader("User-Agent", createUserAgent(context))
            chain.proceed(request.build())
        }
    }
    fun createUserAgent(context: Context): String {

        val versionName: String = context.packageManager
            .getPackageInfo(context.packageName, 0).versionName.toString()

        val scale = context.resources.displayMetrics.density.toString()

        val manufacturer = Build.MANUFACTURER
        val deviceModel = Build.MODEL
        val deviceType = "mobile"

        val appName: String = "Weather App"
        val apiLevel = Build.VERSION.SDK_INT.toString()
        val symbols = DecimalFormatSymbols(Locale.getDefault())
        symbols.decimalSeparator = '.'
        return String.format(
            Locale.ENGLISH, "%s/%s (Android %s; %s; Scale/%s; %s %s)_app_", appName, versionName,
            apiLevel, deviceType, scale, manufacturer,
            deviceModel)
    }
}