package com.example.wallpaperapp


import com.example.wallpaperapp.data.PhotoCategoriesListItem
import com.example.wallpaperapp.data.PhotosInCategoriesItem
import com.example.wallpaperapp.view.ACCESS_KEY
import com.example.wallpaperapp.view.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {

    @GET("topics/?")
    suspend fun getPhotoCategories(
        @Query("client_id") client_id:String = ACCESS_KEY
    ): Response<ArrayList<PhotoCategoriesListItem>>

   @GET("topics/{id}/photos/?")
   suspend fun getPhotoInCategories(
    @Path("id") id:String,
    @Query("client_id") client_id:String = ACCESS_KEY
):Response<ArrayList<PhotosInCategoriesItem>>

    companion object{

        var retrofitService:RetrofitService?=null

        fun getRetrofitInstance():RetrofitService{
            if(retrofitService==null){
                val logging = HttpLoggingInterceptor()
                    logging.level = HttpLoggingInterceptor.Level.BASIC
                val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build()
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }

}
