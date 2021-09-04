package com.changers.breeds.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.changers.breeds.data.model.Breeds
import com.changers.breeds.data.model.GeneralResponse
import com.changers.breeds.data.model.SelectedBreeds
import com.changers.breeds.data.remote.BreedApiService
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/*
*  Breeds repository either local or remote support for required data
* */
class MainRepository @Inject constructor(private val apiService: BreedApiService) {

    /*
    *  Get List of breeds from external services
    * */
    fun getBreedsListFromRemote(url : String): LiveData<List<Breeds>> {
        val data: MutableLiveData<List<Breeds>> = MutableLiveData()
        apiService.getBreeds(url).enqueue(object : Callback<List<Breeds>> {
            override fun onResponse(call: Call<List<Breeds>>, response: Response<List<Breeds>>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<List<Breeds>>, t: Throwable) {
                data.value = null
            }

        })

        return data
    }

    /*
   *  Get List of images from external services by breeds id
   * */
    fun getSelectedBreedList(url: String): LiveData<List<SelectedBreeds>> {
        val data: MutableLiveData<List<SelectedBreeds>> = MutableLiveData()
        apiService.getSelectedBreeds(url).enqueue(object : Callback<List<SelectedBreeds>> {
            override fun onResponse(call: Call<List<SelectedBreeds>>, response: Response<List<SelectedBreeds>>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<List<SelectedBreeds>>, t: Throwable) {
                data.value = null
            }

        })

        return data
    }
}