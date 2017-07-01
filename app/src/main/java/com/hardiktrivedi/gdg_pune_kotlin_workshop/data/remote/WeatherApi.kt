package com.hardiktrivedi.kotlin_gdg_pune_workshop.data.remote

import com.google.gson.Gson
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.verbose
import java.net.URL

/**
 * Created by hardik.trivedi on 24/06/17.
 */
class WeatherApi(val zipCode: Long):AnkoLogger {

    val BASE_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
    val APP_ID = "27345e3e20086824ccb7250e8e118b6c"
    val FULL_URL = "$BASE_URL&appid=$APP_ID&q="

    fun execute(): ForecastResult {
        //verbose { FULL_URL + zipCode }
        val jsonResponse = URL(FULL_URL + zipCode).readText()
        return Gson().fromJson(jsonResponse, ForecastResult::class.java)
    }
}