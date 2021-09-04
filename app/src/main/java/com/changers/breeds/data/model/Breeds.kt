package com.changers.breeds.data.model

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose

data class Breeds(
    @Expose
    var id: Int = 0,
    @Expose
    var name: String = ""
) {
    override fun toString(): String {
        return name
    }
}
