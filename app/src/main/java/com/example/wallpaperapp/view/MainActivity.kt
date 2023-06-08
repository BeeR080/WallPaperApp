package com.example.wallpaperapp.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wallpaperapp.R
import com.example.wallpaperapp.databinding.ActivityMainBinding




const val BASE_URL ="https://api.unsplash.com/"
const val ACCESS_KEY ="aOq9dfxSKYdtuYsTmJzMznV65SPE9AZF4pJEvijjk_I"

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment, MainFragment())
            .commit()
    }
}