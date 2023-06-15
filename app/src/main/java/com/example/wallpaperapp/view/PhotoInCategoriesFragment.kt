package com.example.wallpaperapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpaperapp.data.DownloadManager
import com.example.wallpaperapp.viewmodel.MainViewModel
import com.example.wallpaperapp.viewmodel.MainViewModelFactory
import com.example.wallpaperapp.R
import com.example.wallpaperapp.data.PhotosInCategoriesItem
import com.example.wallpaperapp.databinding.FragmentPhotoInCategoriesBinding
import com.example.wallpaperapp.view.adapters.PhotoInCategoriesAdapter

class PhotoInCategoriesFragment : Fragment(R.layout.fragment_photo_in_categories) {

   private var _binding: FragmentPhotoInCategoriesBinding?=null
    private val binding: FragmentPhotoInCategoriesBinding get()= _binding!!

    private lateinit var mainVm: MainViewModel
    private lateinit var adapter: PhotoInCategoriesAdapter
    private lateinit var downloader: DownloadManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentPhotoInCategoriesBinding.bind(view)
        mainVm = ViewModelProvider(
            requireActivity(),
            MainViewModelFactory()
        )
            .get(MainViewModel::class.java)

        initAdapter()
        getPhotos()
        initDownloadManager()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
       private fun initDownloadManager(){
       downloader = DownloadManager(requireContext())
      }
    private fun downloadPhoto(currentUri:String,fileName:String){
        downloader.downloadFile(currentUri,fileName)
    }

    private fun initAdapter(){
        adapter = PhotoInCategoriesAdapter(object : PhotoInCategoriesAdapter.AdapterClickListener{
            override fun onClick(currentItem: PhotosInCategoriesItem) {
                mainVm.picPhoto.value = currentItem.urls.full
                activity!!.supportFragmentManager
                    .beginTransaction()
                    .addToBackStack("mainfrag")
                    .replace(R.id.fragment, PickPhotoFragment(),"pickf")
                    .commit()
            }

            override fun onClickDownloadPhoto(currentItem: PhotosInCategoriesItem) {

                downloadPhoto(currentItem.links.download,currentItem.id)
            }

        })
        val recyclerView = binding.picRecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(),1)
    }

    private fun getPhotos(){
        mainVm.photoInCategoriesList.observe(viewLifecycleOwner){photos->
            adapter.submitList(photos)

        }
    }



}