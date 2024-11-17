package com.johann.repositories.network

import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.adapters.EnumJsonAdapter
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.joda.time.DateTime
import org.joda.time.Period
import timber.log.Timber
import java.util.Date


interface ApiServiceFactory {

    companion object {

        val moshi: Moshi = Moshi.Builder()
            .add(Date::class.java, Rfc3339DateJsonAdapter())
            .add(DateTimeAdapter())
            .add(DurationAdapter())
            .addLast(KotlinJsonAdapterFactory()) // Most generic adapter last
            .build()
    }

    class DurationAdapter {
        @ToJson
        fun toJson(period: Period): String = period.toString()

        @FromJson
        fun fromJson(period: String): Period {
            return try {
                Period.parse(period)
            } catch (ex: Exception) {
                Period.ZERO
            }
        }
    }


    class DateTimeAdapter {

        @FromJson
        fun fromJson(timeString: String) =
            DateTime(timeString.filter { s -> s.isDigit() || s == '+' }.dropLast(5).toLong())

        @ToJson
        fun toJson(dateTime: DateTime): String =
            throw NotImplementedError("Conversion from DataTime is not implemented")
    }

}


internal data class MoshiEnumConfig<T>(val fallback: T) where T : Enum<T> {
    internal fun addTo(builder: Moshi.Builder): Moshi.Builder {
        val enumJavaClass = fallback.declaringJavaClass
        return builder
            .add(enumJavaClass, EnumJsonAdapter.create(enumJavaClass)
            .withUnknownFallback(fallback))
    }
}

internal inline fun <reified T> Moshi.convertToJson(instance: T): String? = try {
    adapter(T::class.java).toJson(instance)
} catch (ex: Exception) {
    Timber.e(ex, "Failed converting ${T::class.simpleName} to json")
    null
}

internal inline fun <reified T> Moshi.convertFromJson(blob: String?): T? = blob?.let {
    try {
        adapter(T::class.java).fromJson(it)
    } catch (ex: Exception) {
        Timber.e(ex, "Failed converting ${T::class.simpleName} from json")
        null
    }
}
