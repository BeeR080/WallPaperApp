package com.example.wallpaperapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpaperapp.viewmodel.MainViewModel
import com.example.wallpaperapp.viewmodel.MainViewModelFactory
import com.example.wallpaperapp.R
import com.example.wallpaperapp.data.PhotoCategoriesListItem
import com.example.wallpaperapp.databinding.FragmentMainBinding
import com.example.wallpaperapp.view.adapters.MainAdapter
import kotlinx.coroutines.launch

class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding:FragmentMainBinding? =null
    private val binding: FragmentMainBinding get() = _binding!!

    private lateinit var mainVm: MainViewModel
    private lateinit var adapter: MainAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        mainVm = ViewModelProvider(
            requireActivity(),
            MainViewModelFactory()
        )
            .get(MainViewModel::class.java)


        initAdapter()
        getPhotoCategories()
        toolbarMenu()
    }

    private fun initAdapter(){

        adapter = MainAdapter(object : MainAdapter.AdapterClickListener{
            override fun onClick(currentItem: PhotoCategoriesListItem) {
                getPhotoInCategories(currentItem.id)

requireActivity().supportFragmentManager
    .beginTransaction()
    .addToBackStack("mainfrag")
    .replace(R.id.fragment,
    PhotoInCategoriesFragment())
    .commit()
            }

        })
        val recyclerView = binding.rcCategories
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(),2)

    }

    private fun getPhotoInCategories(id:String){
        lifecycleScope.launch {
            mainVm.getPhotoInCategories(id)
        }


    }
    private fun toolbarMenu(){
        binding.mainToolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.settings -> requireActivity().supportFragmentManager
                    .beginTransaction()
                    .addToBackStack("mainfrag")
                    .replace(R.id.fragment,
                        SettingsFragment())
                    .commit()

            }
            true
        }
    }
    private fun getPhotoCategories(){
        lifecycleScope.launch {
            mainVm.getPhotoCategories()
        }
        mainVm.photoCategoriesList.observe(requireActivity()) { photoCategories ->
            adapter.submitList(photoCategories)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}