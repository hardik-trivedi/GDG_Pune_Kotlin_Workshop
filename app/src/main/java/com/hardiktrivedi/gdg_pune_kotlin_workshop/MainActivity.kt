package com.hardiktrivedi.gdg_pune_kotlin_workshop

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.hardiktrivedi.gdg_pune_kotlin_workshop.extensions.PreferenceExtension
import com.hardiktrivedi.kotlin_gdg_pune_workshop.data.remote.ForecastResult
import com.hardiktrivedi.kotlin_gdg_pune_workshop.data.remote.WeatherApi
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity(), ToolbarManager, AnkoLogger {
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    val zipCode: Long by PreferenceExtension(this, SettingsActivity.ZIPCODE, SettingsActivity.DEFAULT_ZIPCODE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()
    }

    override fun onResume() {
        super.onResume()
        loadWeatherData()
    }

    fun loadWeatherData() = async(UI) {
        val waiter = bg { WeatherApi(zipCode).execute() }
        showData(waiter.await())
    }

    private fun showData(result: ForecastResult) {
        weatherList.layoutManager = LinearLayoutManager(this)
        weatherList.adapter = WeatherListAdapter(result.list)
        toolbarTitle = "${result.city.name} (${result.city.country})"

    }
}
