package com.layneyiu.forecast.domain.model

/**
 * ---------------------------------------------------------
 *
 * Created by Frank on 2020/4/20.
 * <a href="mailto:frankyao10110@gmail.com">Contact me</a>
 * ---------------------------------------------------------
 */
data class ForecastList(
    val id: Long, val city: String, val country: String,
    val dailyForecastList: List<Forecast>
) {

    val size: Int get() = dailyForecastList.size

    operator fun get(position: Int) = dailyForecastList[position]
}

data class Forecast(
    val date: Long, val description: String,
    val high: Int, val low: Int,
    val iconUrl: String
)