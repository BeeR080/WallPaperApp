package com.example.wallpaperapp

class MainRepository(private val retrofitService: RetrofitService) {

    suspend fun getPhotoCategories() = retrofitService.getPhotoCategories()
    suspend fun getPhotoInCategories(id:String) = retrofitService.getPhotoInCategories(id)
}