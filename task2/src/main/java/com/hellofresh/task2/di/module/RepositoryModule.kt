package com.hellofresh.task2.di.module

import com.hellofresh.task2.data.api.ApiService
import com.hellofresh.task2.data.repository.RecipeRepositoryImpl
import com.hellofresh.task2.domain.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @[Provides Singleton]
    fun provideRecipeRepositoryImpl(apiService: ApiService): RecipeRepository =
        RecipeRepositoryImpl(apiService)

}