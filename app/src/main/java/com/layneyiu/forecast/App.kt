package com.layneyiu.forecast

import android.app.Application
import com.layneyiu.forecast.ui.utils.DelegateExt

/**
 * ---------------------------------------------------------
 *
 * Created by Frank on 2020/4/27.
 * <a href="mailto:frankyao10110@gmail.com">Contact me</a>
 * ---------------------------------------------------------
 */
class App : Application() {
    companion object {
        var instance: App by DelegateExt.notNullSingleValue()
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}