package com.hellofresh.task1.service

import com.hellofresh.task1.Message
import com.hellofresh.task1.model.Menu
import com.hellofresh.task1.model.Result

interface IUnSelectionService {
    fun unSelectRecipes(vararg ids: String): Result
}

class UnSelectionService(
    private val menu: Menu
) : IUnSelectionService {

    override fun unSelectRecipes(vararg ids: String): Result {
        if (ids.isEmpty()) return Result.Error(Message.RECIPE_ID_NOT_FOUND)

        ids.iterator().forEach { id ->
            if (!isRecipeRemoved(id)) {
                return Result.Error(Message.RECIPE_NOT_IN_SELECTION_LIST)
            }
        }
        return Result.Success(menu.selectionRecipes)
    }

    private fun isRecipeRemoved(id: String): Boolean {
        return menu.selectionRecipes.removeIf { recipe ->
            recipe.id == id
        }
    }
}