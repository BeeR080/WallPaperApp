package com.example.wallpaperapp.utills

import androidx.recyclerview.widget.DiffUtil
import com.example.wallpaperapp.data.CoverPhoto
import com.example.wallpaperapp.data.PhotoCategoriesListItem
import com.example.wallpaperapp.data.PhotosInCategoriesItem

class DiffUtillsPhotoInCategories: DiffUtil.ItemCallback<PhotosInCategoriesItem>() {
    override fun areItemsTheSame(
        oldItem: PhotosInCategoriesItem,
        newItem: PhotosInCategoriesItem
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: PhotosInCategoriesItem,
        newItem: PhotosInCategoriesItem
    ): Boolean {
        return oldItem.id == newItem.id
    }
}