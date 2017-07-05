package com.hardiktrivedi.gdg_pune_kotlin_workshop

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.hardiktrivedi.gdg_pune_kotlin_workshop.extensions.color
import com.hardiktrivedi.gdg_pune_kotlin_workshop.extensions.textColor
import com.hardiktrivedi.gdg_pune_kotlin_workshop.extensions.toStringDate
import com.hardiktrivedi.kotlin_gdg_pune_workshop.data.remote.WeatherApi
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.find
import java.text.DateFormat

class DetailActivity : AppCompatActivity(), ToolbarManager {
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    companion object {
        val NAME = "city_name"
        val DESC = "desc"
        val MIN_TEMP = "min_temp"
        val MAX_TEMP = "max_temp"
        val ICON = "icon"
        val DATE = "date"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        showDataOnView()
    }

    private fun showDataOnView() {
        val bundle = intent.extras
        toolbarTitle = bundle.getString(NAME)
        Picasso.with(this).load(String.format(WeatherApi.IMAGE_URL, bundle.getString(ICON))).into(imgWeather)
        txtDay.text = (bundle.getLong(DATE)*1000).toStringDate(DateFormat.FULL)
        txtDesc.text = bundle.getString(DESC)

        showTemperature(bundle.getFloat(MIN_TEMP) to txtMinWeather, bundle.getFloat(MAX_TEMP) to txtMaxWeather)
    }

    private fun showTemperature(vararg views: Pair<Float, TextView>) = views.forEach {
        it.second.text = it.first.toString()
        it.second.textColor = color(when (it.first) {
            in -100..0 -> R.color.colorAccent
            in 0..22 -> R.color.orange
            else -> R.color.red
        })
    }
}
