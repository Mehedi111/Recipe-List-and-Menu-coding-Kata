package com.hellofresh.task2.data.api

import com.hellofresh.task2.data.model.RecipesResponse
import retrofit2.http.GET

interface ApiService {

    @GET("android-test/recipes.json")
    suspend fun getAllRecipes(): List<RecipesResponse>
}