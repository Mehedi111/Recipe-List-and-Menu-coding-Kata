package com.hellofresh.task1.service

import com.hellofresh.task1.model.Menu
import com.hellofresh.task1.model.Result

interface IUnSelectionService {
    fun unSelectRecipes(vararg ids: String): Result
}

class UnSelectionService(
    private val menu: Menu
) : IUnSelectionService {

    override fun unSelectRecipes(vararg ids: String): Result {
        ids.iterator().forEach { id ->
            unselectRecipesFromSelection(id)
        }
        return Result.Success(menu.selectionRecipes)
    }

    private fun unselectRecipesFromSelection(id: String) {
        menu.selectionRecipes.removeIf { recipe ->
            recipe.id == id
        }
    }
}