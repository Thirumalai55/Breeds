package com.changers.breeds.data.remote
import com.changers.breeds.data.model.Breeds
import com.changers.breeds.data.model.SelectedBreeds
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

//use for api calling
interface BreedApiService {
    @GET
    fun getBreeds(@Url url: String): Call<List<Breeds>>

    @GET
    fun getSelectedBreeds(@Url url: String): Call<List<SelectedBreeds>>
}