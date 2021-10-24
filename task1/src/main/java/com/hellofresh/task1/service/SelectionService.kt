package com.hellofresh.task1.service

import com.hellofresh.task1.Message
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
        if (ids.isEmpty()) return Result.Error(Message.RECIPE_ID_MISSING)

        ids.iterator().forEach { id ->
            if (!menu.subscriptionInfo.isForFamily
                && menu.selectionList.size == 3
            ) {
                return Result.Error(Message.MAX_LIMIT_REACHED)
            } else if (
                menu.subscriptionInfo.isForFamily
                && menu.selectionList.size == 5
            ) {
                return Result.Error(Message.FAMILY_SUBS_MAX_LIMIT_REACHED)
            } else {
                if (!isRecipeAdded(id)){
                    return Result.Error(Message.RECIPE_ALREADY_SELECTED)
                }
            }
        }
        return Result.Success(menu.selectionList)
    }

    private fun isRecipeAdded(id: String): Boolean {
        menu.availableRecipes.forEach { availableRecipe ->
            if (availableRecipe.id == id) {
                if (menu.selectionList.contains(availableRecipe)) {
                    return false
                }
                menu.selectionList.add(availableRecipe)
                return true
            }
        }
        return false
    }

}
