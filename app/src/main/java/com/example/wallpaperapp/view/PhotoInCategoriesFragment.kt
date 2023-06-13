package com.example.wallpaperapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpaperapp.MainViewModel
import com.example.wallpaperapp.MainViewModelFactory
import com.example.wallpaperapp.data.PhotosInCategoriesItem
import com.example.wallpaperapp.databinding.FragmentPhotoInCategoriesBinding
import com.example.wallpaperapp.view.adapters.PhotoInCategoriesAdapter

class PhotoInCategoriesFragment : Fragment() {
    private lateinit var binding: FragmentPhotoInCategoriesBinding
    private lateinit var mainVm: MainViewModel
    lateinit var adapter: PhotoInCategoriesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPhotoInCategoriesBinding.inflate(inflater)

        mainVm = ViewModelProvider(
            requireActivity(),
            MainViewModelFactory())
            .get(MainViewModel::class.java)

initAdapter()
getPhotos()
        return binding.root
    }

    private fun initAdapter(){
        adapter = PhotoInCategoriesAdapter(object : PhotoInCategoriesAdapter.AdapterClickListener{
            override fun onClick(currentItem: PhotosInCategoriesItem) {

            }

        })
        val recyclerView = binding.picRecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(),1)
    }

    private fun getPhotos(){
        mainVm.photoInCategoriesList.observe(requireActivity()){photos->
            adapter.submitList(photos)
        }
    }



}