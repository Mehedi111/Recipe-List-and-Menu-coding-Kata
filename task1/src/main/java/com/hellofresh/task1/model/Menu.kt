package com.hellofresh.task1.model

data class Menu(
    val availableRecipes: List<Recipe>,
    var subscriptionInfo: Subscription //use interface to scalable solution
){
    val selectionRecipes: MutableSet<Recipe> = mutableSetOf()
}
