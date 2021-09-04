package com.changers.breeds.data.model

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose

data class GeneralResponse(
    @Expose
    var code: Int = 201,
    @Expose
    var rawResponse: JsonObject? = null
)

