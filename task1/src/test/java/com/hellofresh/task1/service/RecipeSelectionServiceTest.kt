package com.hellofresh.task1.service

import com.hellofresh.task1.FakeData
import com.hellofresh.task1.Message
import com.hellofresh.task1.getFakeMenu
import com.hellofresh.task1.model.Menu
import com.hellofresh.task1.model.Result
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.TestCase
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf


/**
 * Need to install kotest plugin in android studio to run tests
 * */
class RecipeSelectionServiceTest: StringSpec() {

    private lateinit var menu: Menu
    private lateinit var selectionService: ISelectionService

    override fun beforeEach(testCase: TestCase) {
        super.beforeEach(testCase)
        menu = getFakeMenu()
        selectionService = SelectionService(menu)
    }

    init {
        "check that selectRecipes adds a single recipe to the selection list"{
            //Given we select a recipe
            val result = selectionService.selectRecipes(FakeData.recipeOne.id)

            result.apply {
                this.shouldBeInstanceOf<Result.Success>()
                this.selectionList.size shouldBe 1
            }
        }

        "check that selectRecipes adds multiple recipes to the selection list"{
            //Given we select multiple recipes
            val result = selectionService.selectRecipes(FakeData.recipeTwo.id, FakeData.recipeThree.id)

            result.apply {
                this.shouldBeInstanceOf<Result.Success>()
                this.selectionList.size shouldBe 2
            }
        }

        "check that selectRecipes returns error message if add more than 3 recipes" {
            //Given we add multiple recipes to the selection list
            val result = selectionService.selectRecipes(
                FakeData.recipeOne.id,
                FakeData.recipeTwo.id,
                FakeData.recipeThree.id,
                FakeData.recipeFour.id
            )

            //then
            result.apply {
                this.shouldBeInstanceOf<Result.Error>()
                this.msg shouldBe Message.MAX_LIMIT_REACHED
            }
        }

        "check that selectRecipes returns error message if has family subscription and add more than 5 recipes"{
            //Given
            //we make subscription is for family
            menu.subscriptionInfo = FakeData.subscriptionTypeTwo

            // we add multiple recipes to the selection list
            val result = selectionService.selectRecipes(
                FakeData.recipeOne.id, FakeData.recipeTwo.id,
                FakeData.recipeThree.id, FakeData.recipeFour.id, FakeData.recipeFive.id, FakeData.recipeSix.id
            )

            //then
            result.apply {
                this.shouldBeInstanceOf<Result.Error>()
                this.msg shouldBe Message.FAMILY_SUBS_MAX_LIMIT_REACHED
            }
        }

        "check that selectRecipes returns error if recipe already selected"{
            //Given we select same recipe two times
            val resultOne = selectionService.selectRecipes(FakeData.recipeTwo.id)
            val resultTwo = selectionService.selectRecipes(FakeData.recipeTwo.id)

            //then
            resultOne.apply {
                this.shouldBeInstanceOf<Result.Success>()
                this.selectionList.size shouldBe 1
            }

            resultTwo.apply {
                this.shouldBeInstanceOf<Result.Error>()
                this.msg shouldBe Message.RECIPE_ALREADY_SELECTED
            }
        }


        "check that selectRecipes returns error if requested recipe id is empty"{
            //When we call selectRecipes with empty recipe id
            val result = selectionService.selectRecipes()

            result.apply {
                this.shouldBeInstanceOf<Result.Error>()
                this.msg shouldBe Message.RECIPE_ID_NOT_FOUND
            }
        }


    }

}