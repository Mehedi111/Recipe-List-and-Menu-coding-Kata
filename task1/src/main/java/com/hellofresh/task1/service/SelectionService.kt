package com.hellofresh.task1.service

import com.hellofresh.task1.model.Menu
import com.hellofresh.task1.model.Result

interface ISelectionService {
    fun selectRecipes(vararg ids: String): Result
}

class SelectionService(
    private val menu: Menu
) : ISelectionService {

    override fun selectRecipes(vararg ids: String): Result {
        return addRecipeToSelectionIfPossible(ids)
    }

    private fun addRecipeToSelectionIfPossible(ids: Array<out String>): Result {
        ids.iterator().forEach { id ->
            menu.availableRecipes.forEach { availableRecipe ->
                if (availableRecipe.id == id) {
                    menu.selectionList.add(availableRecipe)
                }
            }
        }
        return Result.Success(menu.selectionList)
    }

}
