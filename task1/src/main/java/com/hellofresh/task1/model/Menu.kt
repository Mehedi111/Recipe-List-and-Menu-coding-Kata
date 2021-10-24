package com.hellofresh.task1.model

data class Menu(
    val availableRecipes: List<Recipe>
){
    val selectionList: MutableList<Recipe> = mutableListOf()
}
