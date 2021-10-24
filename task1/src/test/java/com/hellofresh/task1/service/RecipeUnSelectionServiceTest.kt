package com.hellofresh.task1.service

import com.hellofresh.task1.Data
import com.hellofresh.task1.Message
import com.hellofresh.task1.getMenu
import com.hellofresh.task1.model.Menu
import com.hellofresh.task1.model.Result
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.TestCase
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

class RecipeUnSelectionServiceTest : StringSpec() {
    private lateinit var menu: Menu
    private lateinit var selectionService: ISelectionService
    private lateinit var unSelectionService: IUnSelectionService

    override fun beforeEach(testCase: TestCase) {
        super.beforeEach(testCase)
        menu = getMenu()
        selectionService = SelectionService(menu)
        unSelectionService = UnSelectionService(menu)
    }

    init {
        "check that unselectRecipe removes single recipe from the selection list"{
            //Given we add multiple recipes to the selection list
            selectionService.selectRecipes(Data.recipeTwo.id, Data.recipeThree.id)

            //When we unselect a recipe
            val result = unSelectionService.unSelectRecipes(Data.recipeTwo.id)

            result.apply {
                this.shouldBeInstanceOf<Result.Success>()
                this.selectionList.size shouldBe 1
            }
        }



        "check that unSelectRecipe removes multiple recipes from the selection list"{
            //Given we add multiple recipes to the selection list
            selectionService.selectRecipes(Data.recipeTwo.id, Data.recipeThree.id)

            //When we unselect multiple recipes
            val result = unSelectionService.unSelectRecipes(Data.recipeTwo.id, Data.recipeThree.id)

            //Then
            result.apply {
                this.shouldBeInstanceOf<Result.Success>()
                this.selectionList.size shouldBe 0
            }
        }

        "check that unselectRecipe returns error if requested recipe doesn't exist in selected recipe list"{

            //When we unselect a recipe that doesn't exist in selected recipe list
            val result = unSelectionService.unSelectRecipes(Data.recipeTwo.id)

            result.apply {
                this.shouldBeInstanceOf<Result.Error>()
                this.msg shouldBe Message.RECIPE_NOT_IN_SELECTION_LIST
            }
        }

        "check that unselectRecipe returns error if requested recipe id is empty"{

            //When we call unselectRecipes with empty recipe id
            val result = unSelectionService.unSelectRecipes()

            result.apply {
                this.shouldBeInstanceOf<Result.Error>()
                this.msg shouldBe Message.RECIPE_ID_NOT_FOUND
            }
        }
    }
}