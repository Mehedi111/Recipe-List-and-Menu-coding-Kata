package com.hellofresh.task1.model

data class Menu(
    val availableRecipes: List<Recipe>,
    var subscriptionInfo: Subscription
){
    val selectionRecipes: MutableSet<Recipe> = mutableSetOf()
}
