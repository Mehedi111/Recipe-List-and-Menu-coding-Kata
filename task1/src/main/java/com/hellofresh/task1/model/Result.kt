package com.hellofresh.task1.model

sealed class Result {
    data class Success(val selectionList: MutableSet<Recipe>) : Result()
    data class Error(val msg: String) : Result()
}
