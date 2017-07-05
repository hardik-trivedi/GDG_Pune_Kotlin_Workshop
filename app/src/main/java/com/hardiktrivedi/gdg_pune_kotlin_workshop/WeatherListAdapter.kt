package com.hardiktrivedi.gdg_pune_kotlin_workshop

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hardiktrivedi.gdg_pune_kotlin_workshop.extensions.toStringDate
import com.hardiktrivedi.kotlin_gdg_pune_workshop.data.remote.Forecast
import com.hardiktrivedi.kotlin_gdg_pune_workshop.data.remote.WeatherApi
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.weather_list_item.view.*

/**
 * Created by hardik.trivedi on 24/06/17.
 */
class WeatherListAdapter(val items: List<Forecast>, val callback: (Forecast) -> Unit) : RecyclerView.Adapter<WeatherListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.weather_list_item, parent, false),
                callback)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.showData(items[position])
    }

    class ViewHolder(val view: View, val callback: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {
        fun showData(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(String.format(WeatherApi.IMAGE_URL, weather[0].icon)).into(itemView.imgWeather)
                itemView.txtDay.text = (dt*1000).toStringDate()
                itemView.txtDesc.text = weather[0].description
                with(temp) {
                    itemView.txtMinWeather.text = min.toString()
                    itemView.txtMaxWeather.text = max.toString()
                }
                itemView.setOnClickListener { callback(this) }
            }
        }
    }
}