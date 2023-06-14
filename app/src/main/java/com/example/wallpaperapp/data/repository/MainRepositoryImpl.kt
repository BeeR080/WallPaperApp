package com.example.wallpaperapp.data.repository

import com.example.wallpaperapp.domain.repository.MainRepository
import com.example.wallpaperapp.domain.model.RetrofitService

class MainRepositoryImpl(private val retrofitService: RetrofitService): MainRepository {
    override suspend fun getPhotoCategories() = retrofitService.getPhotoCategories()


    override suspend fun getPhotoInCategories(id: String) =
        retrofitService.getPhotoInCategories(id)

}