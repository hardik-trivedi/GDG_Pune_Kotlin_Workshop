package com.hardiktrivedi.gdg_pune_kotlin_workshop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.hardiktrivedi.kotlin_gdg_pune_workshop.data.remote.ForecastResult
import com.hardiktrivedi.kotlin_gdg_pune_workshop.data.remote.WeatherApi
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), ToolbarManager, AnkoLogger {
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

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
        val waiter = bg { WeatherApi(411021).execute() }
        showData(waiter.await())
    }

    private fun showData(result: ForecastResult) {
        toast(result.list.size.toString())
        //weatherList.adapter
        toolbarTitle = "${result.list.size}"

    }
}
