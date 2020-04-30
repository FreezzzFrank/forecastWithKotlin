package com.layneyiu.forecast.domain.mappers

import com.layneyiu.forecast.domain.model.Forecast
import com.layneyiu.forecast.domain.model.ForecastList

/**
 * ---------------------------------------------------------
 *
 * Created by Frank on 2020/4/29.
 * <a href="mailto:frankyao10110@gmail.com">Contact me</a>
 * ---------------------------------------------------------
 */
class DbDataMapper {
    fun convertFromDomain(forecast: ForecastList) = with(forecast) {
        val daily = dailyForecastList.map {  }
    }

    fun convertDayFromDomain(
        cityId: Long,
        forecast: Forecast
    ) = with(forecast) {

    }
}