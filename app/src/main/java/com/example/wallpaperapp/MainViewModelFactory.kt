package com.example.wallpaperapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(): ViewModelProvider.Factory {

    private val repository by lazy {
        MainRepository(RetrofitService.getRetrofitInstance())
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
   return MainViewModel(
       repository = repository
   ) as T
    }
}