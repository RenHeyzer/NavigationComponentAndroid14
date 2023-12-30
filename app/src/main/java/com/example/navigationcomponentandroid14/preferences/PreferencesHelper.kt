package com.example.navigationcomponentandroid14.preferences

import android.content.Context

class PreferencesHelper(context: Context) {

    private val preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    var text: String
        set(value) {
            preferences.edit().putString(TEXT_KEY, value).apply()
        }
        get() = preferences.getString(TEXT_KEY, "") ?: ""

    var count: Int
        get() = preferences.getInt(COUNT_KEY, 0)
        set(value) {
            preferences.edit().putInt(COUNT_KEY, value).apply()
        }

    companion object {
        const val PREFERENCES_NAME = "preferences-helper"
        const val TEXT_KEY = "text"
        const val COUNT_KEY = "count"
    }
}