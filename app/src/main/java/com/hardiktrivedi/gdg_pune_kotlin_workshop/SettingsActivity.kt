package com.hardiktrivedi.gdg_pune_kotlin_workshop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hardiktrivedi.gdg_pune_kotlin_workshop.extensions.PreferenceExtension
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {
    companion object {
        val ZIPCODE = "zipcode"
        val DEFAULT_ZIPCODE = 411021L
    }

    private var zipCode: Long by PreferenceExtension(this, ZIPCODE, DEFAULT_ZIPCODE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        edtPincode.setText(zipCode.toString())
    }


    override fun onBackPressed() {
        super.onBackPressed()
        zipCode = edtPincode.text.toString().toLong()
    }
}
