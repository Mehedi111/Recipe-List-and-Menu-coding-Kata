package com.hellofresh.task1.model

data class Recipe(
    val id: String,
    val title: String,
    val tags: List<String>
){
    //Recipes are equal if their ids are equal
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Recipe){
            return false
        }

        return other.id == this.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
