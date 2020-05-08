package com.layneyiu.forecast.domain.datasource

import com.layneyiu.forecast.domain.model.Forecast
import com.layneyiu.forecast.domain.model.ForecastList

/**
 * ---------------------------------------------------------
 *

 * Created by Frank on 2020/5/7.
 * <a href="mailto:frankyao10110@gmail.com">Contact me</a>
 * ---------------------------------------------------------
 */
interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long) : ForecastList?

    fun requestDayForecast(id: Long) : Forecast?
}