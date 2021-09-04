package com.changers.breeds.dependencies.modules

import android.content.Context
import com.changers.breeds.data.local.AppSharedPreferences
import com.changers.breeds.dependencies.scopes.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ContextModule::class])
class SharedPreferencesModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): AppSharedPreferences {
        return AppSharedPreferences(context)
    }
}