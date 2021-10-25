package com.hellofresh.task1

import com.hellofresh.task1.FakeData.subscriptionTypeOne
import com.hellofresh.task1.model.Menu
import com.hellofresh.task1.model.Recipe
import com.hellofresh.task1.model.Subscription

internal fun getFakeMenu(): Menu {
    return Menu(FakeData.recipeList, subscriptionTypeOne)
}

object FakeData {
    val recipeOne = Recipe(
        id = "1",
        title = "title1",
        tags = listOf("hot", "sugar-free")
    )

    val recipeTwo = Recipe(
        id = "2",
        title = "title2",
        tags = listOf("quick", "low-calories")
    )

    val recipeThree = Recipe(
        id = "3",
        title = "title3",
        tags = listOf("hot", "egg-free")
    )

    val recipeFour = Recipe(
        id = "4",
        title = "title4",
        tags = listOf("nut-free")
    )

    val recipeFive = Recipe(
        id = "5",
        title = "title5",
        tags = listOf("hot", "spicy")
    )

    val recipeSix = Recipe(
        id = "6",
        title = "title6",
        tags = emptyList()
    )

    val recipeList = listOf(
        recipeOne, recipeTwo, recipeThree, recipeFour,
        recipeFive, recipeSix
    )

    val subscriptionTypeOne = Subscription(
        id = 1,
        delivery_day = "Saturday",
        isForFamily = false
    )

    val subscriptionTypeTwo = Subscription(
        id = 2,
        delivery_day = "Sunday",
        isForFamily = true
    )
}