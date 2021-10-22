package com.hellofresh.task2.data.mapper

import com.hellofresh.task2.data.model.RecipesResponse
import com.hellofresh.task2.domain.entity.Recipe

fun RecipesResponse.toDomain(): Recipe {
    return Recipe(
        this.title, this.image, this.headline
    )
}