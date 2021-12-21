package com.hellofresh.task2.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hellofresh.task2.databinding.LayoutDateViewBinding
import com.hellofresh.task2.databinding.LayoutRecipeItemBinding
import com.hellofresh.task2.model.RecipePresentation
import com.hellofresh.task2.utils.DateUtils
import com.hellofresh.task2.utils.extension.loadImage
import javax.inject.Inject

/**
 * use sealed class to dynamic view
 */
class RecipeAdapter @Inject constructor() :
    ListAdapter<RecipePresentation, RecyclerView.ViewHolder>(diffCallback) {

    companion object {
        private const val VIEW_TYPE_DATE = 0
        private const val VIEW_TYPE_RECIPE = 1

        private val diffCallback = object : DiffUtil.ItemCallback<RecipePresentation>() {
            override fun areItemsTheSame(
                oldItem: RecipePresentation,
                newItem: RecipePresentation
            ): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(
                oldItem: RecipePresentation,
                newItem: RecipePresentation
            ): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    }

    class RecipeViewHolder(val binding: LayoutRecipeItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    class DateViewHolder(val binding: LayoutDateViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val context = parent.context

        val viewHolder: RecyclerView.ViewHolder =
            when (viewType) {
                VIEW_TYPE_DATE -> {
                    val binding =
                        LayoutDateViewBinding.inflate(LayoutInflater.from(context), parent, false)
                    DateViewHolder(binding)
                }
                else -> {
                    val binding =
                        LayoutRecipeItemBinding.inflate(LayoutInflater.from(context), parent, false)
                    RecipeViewHolder(binding)
                }
            }

        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder.itemViewType) {
            VIEW_TYPE_DATE -> {
                val dateViewHolder: DateViewHolder =
                    holder as DateViewHolder

                dateViewHolder.binding.dateTv.text = DateUtils.getCurrentDate()
            }
            else -> {
                val item = getItem(position - 1)

                val recipeViewHolder: RecipeViewHolder =
                    holder as RecipeViewHolder

                with(recipeViewHolder.binding) {
                    recipeImage.loadImage(item.image)
                    recipeTitle.text = item.title
                    recipeHeadline.text = item.headline
                }

            }
        }
    }

    override fun getItemCount(): Int = super.getItemCount() + 1

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) VIEW_TYPE_DATE
        else VIEW_TYPE_RECIPE
    }
}