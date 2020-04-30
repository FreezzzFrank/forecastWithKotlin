package com.layneyiu.forecast.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.layneyiu.forecast.R
import com.layneyiu.forecast.domain.model.Forecast
import com.layneyiu.forecast.domain.model.ForecastList
import com.layneyiu.forecast.ui.utils.ctx
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.forecast_list_item.view.*

/**
 * ---------------------------------------------------------
 * Forecast List
 * Created by Frank on 2020/4/16.
 * <a href="mailto:frankyao10110@gmail.com">Contact me</a>
 * ---------------------------------------------------------
 */
class ForecastListAdapter(
    private val weekForecast: ForecastList,
    private val itemClick: (Forecast) -> Unit
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.ctx).inflate(R.layout.forecast_list_item, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int = weekForecast.size()
}

class ViewHolder(override val containerView: View, val itemClick: (Forecast) -> Unit) :
    RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bindForecast(forecast: Forecast) {
        with(forecast) {
            itemView.dateText.text = date
            itemView.descriptionText.text = description
            itemView.maxTemperature.text = "${high}º"
            itemView.minTemperature.text = "${low}º"
            itemView.setOnClickListener { itemClick(forecast) }
        }
    }

}