package com.hellofresh.task2.domain.repository

import com.hellofresh.task2.domain.entity.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    suspend fun getRecipes(): Flow<List<Recipe>>
}