package com.hellofresh.task2.data.repository

import com.hellofresh.task2.data.api.ApiService
import com.hellofresh.task2.data.mapper.toDomain
import com.hellofresh.task2.domain.entity.Recipe
import com.hellofresh.task2.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RecipeRepositoryImpl(
    private val apiService: ApiService
) : RecipeRepository {

    override suspend fun getRecipes(): Flow<List<Recipe>> = flow {
        val recipesList = apiService.getAllRecipes().map {
            it.toDomain()
        }

        emit(recipesList)
    }
}