package com.hardiktrivedi.gdg_pune_kotlin_workshop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.hardiktrivedi.kotlin_gdg_pune_workshop.ToolbarManager
import org.jetbrains.anko.find
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ToolbarManager {

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

    fun loadWeatherData() {

        showData()
    }

    private fun showData() {
        weatherList.adapter
        toolbarTitle = "Empty"

    }
}
