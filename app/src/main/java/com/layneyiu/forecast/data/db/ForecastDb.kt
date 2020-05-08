package com.layneyiu.forecast.data.db

import com.layneyiu.forecast.domain.datasource.ForecastDataSource
import com.layneyiu.forecast.domain.model.Forecast
import com.layneyiu.forecast.domain.model.ForecastList
import com.layneyiu.forecast.extensions.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * ---------------------------------------------------------
 *
 * Created by Frank on 2020/4/29.
 * <a href="mailto:frankyao10110@gmail.com">Contact me</a>
 * ---------------------------------------------------------
 */
class ForecastDb(
    private val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
    private val dataMapper: DbDataMapper = DbDataMapper()
) : ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use {

        val dailyRequest = "${DayForecastTable.CITY_ID} = ? AND ${DayForecastTable.DATE} >= ?"
        val dailyForecast = select(DayForecastTable.NAME)
            .whereSimple(dailyRequest, zipCode.toString(), date.toString())
            .parseList { DayForecast(HashMap(it)) }

        val city = select(CityForecastTable.NAME)
            .whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
            .parseOpt { CityForecast(HashMap(it), dailyForecast) }
        if (city != null) dataMapper.convertToDomain(city) else null
    }

    override fun requestDayForecast(id: Long): Forecast? = forecastDbHelper.use {

        val forecast = select(DayForecastTable.NAME).byId(id).parseOpt{ DayForecast(HashMap(it)) }
        if (forecast != null) dataMapper.convertDayToDomain(forecast) else null
    }

    fun saveForecast(forecast: ForecastList) = forecastDbHelper.use {

        clear(CityForecastTable.NAME)
        clear(DayForecastTable.NAME)

        with(dataMapper.convertFromDomain(forecast)) {
            insert(CityForecastTable.NAME, *map.toVarargArray())
            dailyForecast.forEach { insert(DayForecastTable.NAME, *it.map.toVarargArray()) }
        }
    }
}