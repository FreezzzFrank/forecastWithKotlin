package com.layneyiu.forecast.data.server

import com.layneyiu.forecast.data.db.ForecastDb
import com.layneyiu.forecast.domain.datasource.ForecastDataSource
import com.layneyiu.forecast.domain.model.Forecast
import com.layneyiu.forecast.domain.model.ForecastList
import java.lang.UnsupportedOperationException

/**
 * ---------------------------------------------------------
 *
 * Created by Frank on 2020/5/7.
 * <a href="mailto:frankyao10110@gmail.com">Contact me</a>
 * ---------------------------------------------------------
 */
class ForecastServer(
    private val dataMapper: ForecastDataMapper = ForecastDataMapper(),
    private val forecastDb: ForecastDb = ForecastDb()
) : ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }

    override fun requestDayForecast(id: Long): Forecast? = throw UnsupportedOperationException()
}