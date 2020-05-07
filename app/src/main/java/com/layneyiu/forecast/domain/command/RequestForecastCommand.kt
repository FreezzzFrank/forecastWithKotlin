package com.layneyiu.forecast.domain.command

import com.layneyiu.forecast.domain.datasource.ForecastProvider
import com.layneyiu.forecast.domain.model.ForecastList

/**
 * ---------------------------------------------------------
 *
 * Created by Frank on 2020/4/20.
 * <a href="mailto:frankyao10110@gmail.com">Contact me</a>
 * ---------------------------------------------------------
 */

class RequestForecastCommand(
    private val zipCode: Long,
    private val forecastProvider: ForecastProvider = ForecastProvider()
) : Command<ForecastList> {

    companion object {
        const val DAYS = 7
    }

    override fun execute(): ForecastList = forecastProvider.requestByZipCode(zipCode, DAYS)

}