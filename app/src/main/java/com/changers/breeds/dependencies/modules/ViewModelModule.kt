package com.changers.breeds.dependencies.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.changers.breeds.data.ViewModelFactory
import com.changers.breeds.dependencies.scopes.ViewModelKey
import com.changers.breeds.ui.BreedsFragmentViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(BreedsFragmentViewModel::class)
    internal abstract fun breedsFragmentViewModel(viewModel: BreedsFragmentViewModel): ViewModel


}