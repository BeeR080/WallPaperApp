package com.example.wallpaperapp

import com.example.wallpaperapp.data.PhotoCategoriesListItem
import com.example.wallpaperapp.view.ACCESS_KEY
import com.example.wallpaperapp.view.BASE_URL
import retrofit2.Response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("topics/?")
    suspend fun getPhotoCategories(
        @Query("client_id") client_id:String = ACCESS_KEY
    ): Response<ArrayList<PhotoCategoriesListItem>>


    companion object{

        var retrofitService:RetrofitService?=null

        fun getRetrofitInstance():RetrofitService{
            if(retrofitService==null){
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }

}
