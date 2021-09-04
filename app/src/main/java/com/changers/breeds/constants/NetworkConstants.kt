package com.changers.breeds.constants

object NetworkConstants {
    const val BASE_URL = "https://api.thedogapi.com/v1/"

    const val BREEDS_END_POINT = BASE_URL+"breeds"
    const val SELECTED_BREED_END_POINT = BASE_URL + "images/search?breed_id=-1&limit=102"
}