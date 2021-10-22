package com.hellofresh.task2.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hellofresh.task2.domain.usecase.GetRecipesListUseCase
import com.hellofresh.task2.mapper.toPresentation
import com.hellofresh.task2.state.ViewState
import com.hellofresh.task2.utils.exception.ExceptionHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class RecipesListViewModel @Inject constructor(
    private val getRecipesListUseCase: GetRecipesListUseCase
): ViewModel() {

    private var job: Job? = null

    val recipesListviewState: LiveData<ViewState>
        get() = _recipesListviewState


    private var _recipesListviewState = MutableLiveData<ViewState>()


    /**
     * coroutineExceptionHandler will handle uncaught exceptions.
     */
    private val coroutineExceptionHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, exception ->
            val errorMsg = ExceptionHandler.parse(exception)

            _recipesListviewState.value = ViewState.Error(errorMsg)
        }


    fun getRecipesList(){
        job?.cancel()

        job = viewModelScope.launch(coroutineExceptionHandler) {
            _recipesListviewState.value = ViewState.Loading

            getRecipesListUseCase().collect { results ->
                val recipeList = results.map {
                    recipes -> recipes.toPresentation() }

                _recipesListviewState.value = ViewState.Success(recipeList)
            }
        }

    }

    override fun onCleared() {
        job?.cancel()
        super.onCleared()
    }
}