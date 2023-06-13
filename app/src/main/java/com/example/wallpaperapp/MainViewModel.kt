package com.example.wallpaperapp



import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpaperapp.data.PhotoCategoriesListItem
import com.example.wallpaperapp.data.PhotosInCategoriesItem
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: MainRepository

    ):ViewModel() {


    private val _photoCategoriesList = MutableLiveData<List<PhotoCategoriesListItem>>()
    val photoCategoriesList = _photoCategoriesList
    private val _photoInCategoriesList = MutableLiveData<List<PhotosInCategoriesItem>>()
    val photoInCategoriesList = _photoInCategoriesList

    suspend fun getPhotoCategories(){
viewModelScope.launch {
val response = repository.getPhotoCategories()
        _photoCategoriesList.value = response.body()
}

    }
    suspend fun getPhotoInCategories(id:String){
        viewModelScope.launch {
            val response = repository.getPhotoInCategories(id = id)
            _photoInCategoriesList.value = response.body()
        }
    }
}