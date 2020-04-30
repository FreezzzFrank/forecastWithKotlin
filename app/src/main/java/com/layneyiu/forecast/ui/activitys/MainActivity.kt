package com.layneyiu.forecast.ui.activitys

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.layneyiu.forecast.R
import com.layneyiu.forecast.domain.command.RequestForecastCommand
import com.layneyiu.forecast.ui.adapters.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecastList.layoutManager = LinearLayoutManager(this)
        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecastList.adapter =
                    ForecastListAdapter(result) {
                        toast(it.date)
                    }
                Log.d(javaClass.simpleName, "Result: $result")
            }
        }

    }

}
