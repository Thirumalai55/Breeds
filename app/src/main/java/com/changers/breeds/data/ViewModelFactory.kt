package com.changers.breeds.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(private val viewmodel: MutableMap<Class<out ViewModel>, Provider<ViewModel>>):
ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
         return  viewmodel[modelClass]?.get() as T
    }
}