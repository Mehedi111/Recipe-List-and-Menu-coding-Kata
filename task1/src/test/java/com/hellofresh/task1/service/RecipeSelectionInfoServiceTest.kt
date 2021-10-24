package com.hellofresh.task1.service

import com.hellofresh.task1.Data
import com.hellofresh.task1.getMenu
import com.hellofresh.task1.model.Menu
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.TestCase
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.shouldBe

class RecipeSelectionInfoServiceTest : StringSpec() {

    private lateinit var menu: Menu
    private lateinit var selectionService: ISelectionService
    private lateinit var selectionInfoService: ISelectionInfoService

    override fun beforeEach(testCase: TestCase) {
        super.beforeEach(testCase)
        menu = getMenu()
        selectionService = SelectionService(menu)
        selectionInfoService = SelectionInfoService(menu)
    }

    init {
        "check that showNumOfRecipeSelected returns total number of selected recipes"{
            //Given we add multiple recipes to the selection list
            selectionService.selectRecipes(
                Data.recipeTwo.id,
                Data.recipeThree.id,
                Data.recipeFive.id
            )

            //when we get number of selected recipe
            val totalRecipe = selectionInfoService.getTotalNumOfSelectedRecipes()

            //Then
            totalRecipe shouldBeExactly 3
        }

        "check that getAllSelectedRecipes returns all selected recipes"{
            //Given we add multiple recipes to the selection list
            selectionService.selectRecipes(
                Data.recipeOne.id,
                Data.recipeTwo.id,
                Data.recipeThree.id
            )

            //When we get all selected recipes
            val recipes = selectionInfoService.getAllSelectedRecipes()

            //Then
            recipes.apply {
                this.size shouldBe 3
                this shouldContain Data.recipeOne
                this shouldContain Data.recipeThree
            }
        }
    }
}
