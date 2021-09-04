package com.changers.breeds

import android.app.Application
import android.content.Context
import com.changers.breeds.dependencies.AppComponent
import com.changers.breeds.dependencies.DaggerAppComponent
import com.changers.breeds.dependencies.modules.ContextModule

class BreedsApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        mApplicationContext = this
        mAppComponent = DaggerAppComponent.builder().contextModule(ContextModule(this)).build()
    }

    companion object {
        lateinit var mAppComponent: AppComponent
        lateinit var mApplicationContext: Context
    }
}