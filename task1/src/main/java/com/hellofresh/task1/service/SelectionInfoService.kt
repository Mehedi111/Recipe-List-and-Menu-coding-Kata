package com.hellofresh.task1.service

import com.hellofresh.task1.model.Menu
import com.hellofresh.task1.model.Recipe

interface ISelectionInfoService {
    fun getAllSelectedRecipes(): List<Recipe>
    fun getTotalNumOfSelectedRecipes(): Int
}

class SelectionInfoService(
    private val menu: Menu
) : ISelectionInfoService {

    override fun getAllSelectedRecipes(): List<Recipe> = menu.selectionList

    override fun getTotalNumOfSelectedRecipes(): Int = menu.selectionList.size

}

