package com.layneyiu.forecast.domain.command

import com.layneyiu.forecast.data.ForecastRequest
import com.layneyiu.forecast.domain.mappers.ForecastDataMapper
import com.layneyiu.forecast.domain.model.ForecastList

/**
 * ---------------------------------------------------------
 *
 * Created by Frank on 2020/4/20.
 * <a href="mailto:frankyao10110@gmail.com">Contact me</a>
 * ---------------------------------------------------------
 */

class RequestForecastCommand(private val zipCode: String) :Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}