package com.example.wallpaperapp.viewmodel



import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpaperapp.data.PhotoCategoriesListItem
import com.example.wallpaperapp.data.PhotosInCategoriesItem
import com.example.wallpaperapp.data.repository.MainRepositoryImpl
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: MainRepositoryImpl,
    ):ViewModel() {


    private val _photoCategoriesList by lazy{
        MutableLiveData<List<PhotoCategoriesListItem>>()
    }
    private val _photoInCategoriesList by lazy {
        MutableLiveData<List<PhotosInCategoriesItem>>()
    }

    val photoCategoriesList by lazy{
        _photoCategoriesList
    }

    val photoInCategoriesList by lazy {
        _photoInCategoriesList
    }
    val picPhoto by lazy {
        MutableLiveData<String>()
    }

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