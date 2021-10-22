package com.hellofresh.task2.state

import androidx.annotation.StringRes
import com.hellofresh.task2.model.RecipePresentation

sealed class ViewState {
    data class Success(val data: List<RecipePresentation>): ViewState()
    data class Error(@StringRes val message: Int): ViewState()
    object Loading: ViewState()
}