package com.example.wallpaperapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.wallpaperapp.MainRepository
import com.example.wallpaperapp.MainViewModel
import com.example.wallpaperapp.MainViewModelFactory
import com.example.wallpaperapp.RetrofitService
import com.example.wallpaperapp.databinding.FragmentMainBinding
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

private lateinit var binding:FragmentMainBinding
private lateinit var mainVm: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)

        mainVm = ViewModelProvider(
            requireActivity(),
            MainViewModelFactory())
            .get(MainViewModel::class.java)

        getPhotoCategories()

        return binding.root
    }


    private fun getPhotoCategories(){
        lifecycleScope.launch {
            mainVm.getPhotoCategories()
        }
        mainVm.photoCategoriesList.observe(requireActivity()) { photoCategories ->
            Log.d("MyLog", "$photoCategories")
        }

    }

}