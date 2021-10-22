package com.hellofresh.task2.domain.usecase

import com.hellofresh.task2.domain.entity.Recipe
import com.hellofresh.task2.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow

class GetRecipesListUseCase(
    private val recipeRepository: RecipeRepository
) {
    suspend operator fun invoke(): Flow<List<Recipe>> =
        recipeRepository.getRecipes()
}