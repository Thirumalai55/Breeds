package com.changers.breeds.dependencies.modules

import android.app.Application
import android.content.Context
import com.changers.breeds.dependencies.scopes.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class ContextModule(val mApplication: Application) {
    @ApplicationContext
    @Provides
    fun provideContext() : Context {
        return mApplication.applicationContext
    }
}