package com.hellofresh.task1.service

import com.hellofresh.task1.model.Menu
import com.hellofresh.task1.model.Recipe

interface IFilterService {
    fun filterRecipeByTag(tag: String): List<Recipe>
}

class FilterService(
    private val menu: Menu
) : IFilterService {

    override fun filterRecipeByTag(tag: String): List<Recipe> {
        return menu.availableRecipes.filter { recipe ->
            recipe.tags.contains(tag)
        }
    }
}