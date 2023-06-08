package com.example.wallpaperapp


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpaperapp.data.PhotoCategoriesListItem
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: MainRepository

    ):ViewModel() {


    private val _photoCategoriesList = MutableLiveData<List<PhotoCategoriesListItem>>()
    val photoCategoriesList:LiveData<List<PhotoCategoriesListItem>> = _photoCategoriesList

    suspend fun getPhotoCategories(){
viewModelScope.launch {
val response = repository.getPhotoCategories()
        _photoCategoriesList.value = response.body()
}

    }
}