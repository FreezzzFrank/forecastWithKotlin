package com.layneyiu.forecast.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.layneyiu.forecast.App
import org.jetbrains.anko.db.*

/**
 * ---------------------------------------------------------
 *
 * Created by Frank on 2020/4/27.
 * <a href="mailto:frankyao10110@gmail.com">Contact me</a>
 * ---------------------------------------------------------
 */
class ForecastDbHelper(ctx: Context = App.instance) : ManagedSQLiteOpenHelper(ctx ,
    DB_NAME,null, DB_VERSION) {
    companion object {
        const val DB_NAME = "forecast.db"
        const val DB_VERSION = 1
        val instance by lazy { ForecastDbHelper }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(CityForecastTabel.NAME, true,
        CityForecastTabel.ID to INTEGER + PRIMARY_KEY,
        CityForecastTabel.CITY to TEXT,
        CityForecastTabel.COUNTRY to TEXT)

        db.createTable(DayForecastTable.NAME, true,
        DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
        DayForecastTable.DATE to INTEGER,
        DayForecastTable.DESCRIPTION to TEXT,
        DayForecastTable.HIGH to INTEGER,
        DayForecastTable.LOW to INTEGER,
        DayForecastTable.ICON_URL to TEXT,
        DayForecastTable.CITY_ID to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(CityForecastTabel.NAME, true)
        db.dropTable(DayForecastTable.NAME, true)
        onCreate(db)
    }
}