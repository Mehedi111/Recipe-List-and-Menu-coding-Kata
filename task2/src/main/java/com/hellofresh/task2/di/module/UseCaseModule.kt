package com.hellofresh.task2.di.module

import com.hellofresh.task2.domain.repository.RecipeRepository
import com.hellofresh.task2.domain.usecase.GetRecipesListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @[Provides Singleton]
    fun provideGetRecipesListUseCase(recipeRepository: RecipeRepository) =
        GetRecipesListUseCase(recipeRepository)
}