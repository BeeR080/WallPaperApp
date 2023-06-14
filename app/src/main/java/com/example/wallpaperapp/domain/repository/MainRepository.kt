package com.example.wallpaperapp.domain.repository

import com.example.wallpaperapp.data.PhotoCategoriesListItem
import com.example.wallpaperapp.data.PhotosInCategoriesItem
import retrofit2.Response

interface MainRepository {

    suspend fun getPhotoCategories(): Response<ArrayList<PhotoCategoriesListItem>>
    suspend fun getPhotoInCategories(id:String):  Response<ArrayList<PhotosInCategoriesItem>>
}