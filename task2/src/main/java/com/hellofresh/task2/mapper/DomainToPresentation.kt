package com.hellofresh.task2.mapper

import com.hellofresh.task2.domain.entity.Recipe
import com.hellofresh.task2.model.RecipePresentation

internal fun Recipe.toPresentation(): RecipePresentation{
    return RecipePresentation(
        title,
        image,
        headline
    )
}