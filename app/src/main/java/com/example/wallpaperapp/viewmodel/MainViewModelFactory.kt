package com.example.wallpaperapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wallpaperapp.domain.model.RetrofitService
import com.example.wallpaperapp.data.repository.MainRepositoryImpl
import com.example.wallpaperapp.domain.repository.MainRepository

class MainViewModelFactory(): ViewModelProvider.Factory {

    private val repository by lazy {
        MainRepositoryImpl(RetrofitService.getRetrofitInstance())
    }


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
   return MainViewModel(
       repository = repository,

   ) as T
    }
}