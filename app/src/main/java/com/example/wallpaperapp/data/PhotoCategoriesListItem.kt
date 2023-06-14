package com.example.wallpaperapp.data

data class PhotoCategoriesListItem(
    val cover_photo: CoverPhoto,
    val description: String,
    val total_photos: Int,
    val id: String,
    val links: Links,
    val title: String,

)