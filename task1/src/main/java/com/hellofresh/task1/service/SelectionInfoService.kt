package com.hellofresh.task1.service

import com.hellofresh.task1.model.Menu
import com.hellofresh.task1.model.Recipe

interface ISelectionInfoService {
    fun getAllSelectedRecipes(): MutableSet<Recipe>
    fun getTotalNumOfSelectedRecipes(): Int
}

class SelectionInfoService(
    private val menu: Menu
) : ISelectionInfoService {

    override fun getAllSelectedRecipes(): MutableSet<Recipe> = menu.selectionRecipes

    override fun getTotalNumOfSelectedRecipes(): Int = menu.selectionRecipes.size

}

