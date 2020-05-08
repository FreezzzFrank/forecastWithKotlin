package com.layneyiu.forecast.data.server

import com.layneyiu.forecast.domain.model.ForecastList
import java.util.*
import java.util.concurrent.TimeUnit
import com.layneyiu.forecast.domain.model.Forecast as ModelForecast

/**
 * ---------------------------------------------------------
 *
 * Created by Frank on 2020/4/20.
 * <a href="mailto:frankyao10110@gmail.com">Contact me</a>
 * ---------------------------------------------------------
 */
class ForecastDataMapper {

    fun convertToDomain(zipCode: Long, forecast: ForecastResult) = with(forecast) {
        ForecastList(zipCode, city.name, city.country, convertForecastListToDomain(forecast.list))
    }


    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast) = with(forecast) {
        ModelForecast(
            -1, dt, weather[0].description,
            temp.max.toInt(), temp.min.toInt(),
            generateIconUrl(weather[0].icon)
        )
    }

//    private fun convertDate(date: Long): Long {
//        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
//        return df.format(date * 1000).toLong()
//    }

    private fun generateIconUrl(iconCode: String): String =
        "http://openweathermap.org/img/w/$iconCode.png"
}