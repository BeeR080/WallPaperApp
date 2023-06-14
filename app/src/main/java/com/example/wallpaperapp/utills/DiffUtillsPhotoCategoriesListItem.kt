package com.example.wallpaperapp.utills

import androidx.recyclerview.widget.DiffUtil
import com.example.wallpaperapp.data.PhotoCategoriesListItem

class DiffUtillsPhotoCategoriesListItem: DiffUtil.ItemCallback<PhotoCategoriesListItem>() {
    override fun areItemsTheSame(
        oldItem: PhotoCategoriesListItem,
        newItem: PhotoCategoriesListItem
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: PhotoCategoriesListItem,
        newItem: PhotoCategoriesListItem
    ): Boolean {
       return oldItem.id == newItem.id
    }
}