package com.hellofresh.task2.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.hellofresh.task2.databinding.ActivityRecipesListBinding
import com.hellofresh.task2.state.ViewState
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class RecipesListActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "RecipesListActivity_LOG"
    }

    private lateinit var binding: ActivityRecipesListBinding
    private val viewModel: RecipesListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeViewState()
        requestRecipes()
    }

    private fun requestRecipes() {
        viewModel.getRecipesList()
    }

    private fun observeViewState() {
        viewModel.recipesListviewState.observe(this, { state ->
            when (state) {
                is ViewState.Loading -> {
                    Timber.tag(TAG).d("Loading...")
                }

                is ViewState.Success -> {
                    Timber.tag(TAG).d("Success...${state.data.size}")
                }

                is ViewState.Error -> {
                    Timber.tag(TAG).d("Error...${getString(state.message)}")
                }
            }
        })
    }
}