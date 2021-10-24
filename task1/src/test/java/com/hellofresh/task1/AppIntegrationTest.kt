package com.hellofresh.task1

import com.hellofresh.task1.model.Menu
import com.hellofresh.task1.model.Result
import com.hellofresh.task1.service.*
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.types.shouldBeInstanceOf

class AppIntegrationTest : AnnotationSpec() {

    private val menu: Menu = getMenu()

    private fun testEnv(): Env = object : Env,
        ISelectionService by SelectionService(menu),
        IUnSelectionService by UnSelectionService(menu),
        ISelectionInfoService by SelectionInfoService(menu),
        IFilterService by FilterService(menu) {}


    @Test
    fun menuFeatureIntegrationTest() {
        val app = testEnv()

        val selectionResult =
            app.selectRecipes(Data.recipeOne.id, Data.recipeTwo.id, Data.recipeFour.id)
        selectionResult.shouldBeInstanceOf<Result.Success>()

        val overLimitSelectionResult =
            app.selectRecipes(Data.recipeFive.id)
        overLimitSelectionResult.shouldBeInstanceOf<Result.Error>()

        val unSelectionResult = app.unSelectRecipes(Data.recipeFour.id)
        unSelectionResult.shouldBeInstanceOf<Result.Success>()

        val numberOfSelection = app.getTotalNumOfSelectedRecipes()
        numberOfSelection shouldBeExactly 2

        val allSelectedRecipes = app.getAllSelectedRecipes()
        allSelectedRecipes shouldContain Data.recipeOne

        val recipesByTag = app.filterRecipeByTag("hot")
        recipesByTag.size shouldBeExactly 3
    }

}