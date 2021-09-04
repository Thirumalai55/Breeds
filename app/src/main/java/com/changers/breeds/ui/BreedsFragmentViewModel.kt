package com.changers.breeds.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.changers.breeds.constants.NetworkConstants
import com.changers.breeds.data.ViewModelFactory
import com.changers.breeds.data.model.Breeds
import com.changers.breeds.data.model.GeneralResponse
import com.changers.breeds.data.model.SelectedBreeds
import com.changers.breeds.data.repository.MainRepository
import javax.inject.Inject

/*
* Fragment view model
* */
class BreedsFragmentViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    /* Get list of breeds from repository
    * */
    fun getBreedList(): LiveData<List<Breeds>> {

        return mainRepository.getBreedsListFromRemote(NetworkConstants.BREEDS_END_POINT)
    }

    /*
    * Get list of images based on the selected breeds from repository
    * */
    fun getSelectedBreedList(id: Int): LiveData<List<SelectedBreeds>> {
        return mainRepository.getSelectedBreedList(NetworkConstants.SELECTED_BREED_END_POINT.replace("-1", id.toString()))
    }
}