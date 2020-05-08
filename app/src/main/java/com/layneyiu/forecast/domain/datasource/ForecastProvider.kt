package com.layneyiu.forecast.domain.datasource

import com.layneyiu.forecast.data.db.ForecastDb
import com.layneyiu.forecast.data.server.ForecastServer
import com.layneyiu.forecast.domain.model.Forecast
import com.layneyiu.forecast.domain.model.ForecastList
import com.layneyiu.forecast.extensions.firstResult

/**
 * ---------------------------------------------------------
 *
 * Created by Frank on 2020/5/7.
 * <a href="mailto:frankyao10110@gmail.com">Contact me</a>
 * ---------------------------------------------------------
 */

class ForecastProvider(private val sources: List<ForecastDataSource> = SOURCES) {

    companion object {
        const val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES = listOf(ForecastDb(), ForecastServer())
    }

//    fun requestByZipCode(zipCode: Long, days: Int): ForecastList
//            = sources.firstResult { requestSource(it, days, zipCode) }

//    private fun requestSource(source: ForecastDataSource, days: Int, zipCode: Long): ForecastList? {
//        val res = source.requestForecastByZipCode(zipCode, todayTimeSpan())
//        return if (res != null && res.size >= days) res else null
//    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList
            = requestToResources {
        val res = it.requestForecastByZipCode(zipCode,todayTimeSpan())
        if (res != null && res.size >= days) res else null
    }

    fun requestForecast(id: Long) : Forecast = requestToResources { it.requestDayForecast(id) }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS

    private fun <T : Any> requestToResources(f: (ForecastDataSource) -> T?) : T = sources.firstResult { f(it) }
}