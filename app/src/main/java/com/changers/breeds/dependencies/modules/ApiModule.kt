package com.changers.breeds.dependencies.modules

import com.changers.breeds.constants.NetworkConstants
import com.changers.breeds.data.remote.BreedApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class ApiModule {
    @Provides
    @Singleton
    fun provideContactsApiService(okHttpClient: OkHttpClient): BreedApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(NetworkConstants.BASE_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(BreedApiService::class.java)
    }

}