package com.example.wallpaperapp.view



import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate

import com.example.wallpaperapp.R
import com.example.wallpaperapp.databinding.ActivityMainBinding




const val BASE_URL ="https://api.unsplash.com/"
const val ACCESS_KEY ="aOq9dfxSKYdtuYsTmJzMznV65SPE9AZF4pJEvijjk_I"

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    lateinit var sharedPref:SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        chekNight()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment, MainFragment())
            .commit()

    }
  private fun chekNight (){
      sharedPref = getSharedPreferences(
          "night_mode",
          Context.MODE_PRIVATE)
      if(sharedPref.getBoolean("night_mode",true)){
          AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
      }
      else{
          AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
      }
  }

}
