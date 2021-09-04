package com.changers.breeds.data.local

import android.content.Context
import android.content.SharedPreferences

class AppSharedPreferences(context: Context) {

        val sharedPref: SharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

        companion object {
                private const val SHARED_PREF_NAME = "breed_shared"
        }
}

