package com.hellofresh.task2.data.model

import com.squareup.moshi.Json

data class RecipesResponse(
    @field:Json(name = "name") val title: String,
    val image: String,
    val headline: String
)