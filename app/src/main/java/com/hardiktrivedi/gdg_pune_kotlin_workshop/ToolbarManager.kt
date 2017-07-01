package com.hardiktrivedi.gdg_pune_kotlin_workshop

import android.support.v7.widget.Toolbar

/**
 * Created by hardik.trivedi on 22/06/17.
 */
interface ToolbarManager {
    val toolbar: Toolbar

    var toolbarTitle: String
        get() = toolbar.title.toString()
        set(value) {
            toolbar.title = value
        }

    fun initToolbar() {
        toolbar.inflateMenu(R.menu.main_menu)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {

            }
            true
        }
    }
}