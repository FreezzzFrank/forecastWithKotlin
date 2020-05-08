package com.layneyiu.forecast.domain.command

import com.layneyiu.forecast.domain.datasource.ForecastProvider
import com.layneyiu.forecast.domain.model.Forecast

class RequestDayForecastCommand(
    val id: Long,
    val forecastProvider: ForecastProvider = ForecastProvider()
) : Command<Forecast> {

    override fun execute(): Forecast {
        return forecastProvider.requestForecast(id)
    }
}