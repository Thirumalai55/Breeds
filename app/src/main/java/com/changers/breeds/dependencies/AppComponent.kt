package com.changers.breeds.dependencies

import com.changers.breeds.dependencies.modules.*
import com.changers.breeds.ui.BreedsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        SharedPreferencesModule::class,
        ViewModelModule::class,
        ApiModule::class,
        NetworkModule::class]
)
interface AppComponent {
    fun inject(breedsFragment: BreedsFragment)
}