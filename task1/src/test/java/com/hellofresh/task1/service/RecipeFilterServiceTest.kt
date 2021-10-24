package com.hellofresh.task1.service

import com.hellofresh.task1.getMenu
import com.hellofresh.task1.model.Menu
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.TestCase
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class RecipeFilterServiceTest : StringSpec() {
    private lateinit var menu: Menu
    private lateinit var filterService: IFilterService

    override fun beforeTest(testCase: TestCase) {
        super.beforeTest(testCase)
        menu = getMenu()
        filterService = FilterService(menu)
    }

    init {
        "check that getRecipesByTag returns filtered recipes list"{
            val recipesList = filterService.filterRecipeByTag("hot")

            recipesList.size shouldNotBe 0
            recipesList.size shouldBeExactly 3
        }

        "check that getRecipesByTag returns empty list if recipes not found by tag"{
            val recipesList = filterService.filterRecipeByTag("high-calories")

            recipesList.size shouldBe 0
        }


    }
}