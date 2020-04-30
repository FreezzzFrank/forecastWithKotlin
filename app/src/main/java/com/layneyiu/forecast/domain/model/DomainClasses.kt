package com.layneyiu.forecast.domain.model

/**
 * ---------------------------------------------------------
 *
 * Created by Frank on 2020/4/20.
 * <a href="mailto:frankyao10110@gmail.com">Contact me</a>
 * ---------------------------------------------------------
 */
data class ForecastList(
    val city: String,
    val country: String,
    val dailyForecastList: List<Forecast>
) {
    operator fun get(position: Int): Forecast = dailyForecastList[position]
    fun size(): Int = dailyForecastList.size
}

data class Forecast(
    val date: String,
    val description: String,
    val high: Int,
    val low: Int,
    val iconUrl: String
)