package com.example.navigationcomponentandroid14

import android.app.Application
import com.example.navigationcomponentandroid14.preferences.PreferencesHelper

class App : Application() {

    companion object {
        var preferencesHelper: PreferencesHelper? = null
    }

    override fun onCreate() {
        super.onCreate()
        preferencesHelper = PreferencesHelper(applicationContext)
    }
}