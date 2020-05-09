package com.layneyiu.forecast.ui.activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.layneyiu.forecast.R
import com.layneyiu.forecast.domain.command.RequestForecastCommand
import com.layneyiu.forecast.ui.adapters.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), ToolbarManager {
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()

        forecastList.layoutManager = LinearLayoutManager(this)

        attachToScroll(forecastList)

        doAsync {
            val result = RequestForecastCommand(94043).execute()
            uiThread {
                forecastList.adapter =
                    ForecastListAdapter(result) {
                        startActivity<DetailActivity>(
                            DetailActivity.ID to it.id,
                            DetailActivity.CITY_NAME to result.city
                        )
                    }
                toolbarTitle = "${result.city} (${result.country})"
            }
        }

    }

}
