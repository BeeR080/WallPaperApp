package com.example.wallpaperapp.view

import android.app.WallpaperManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModelProvider
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.wallpaperapp.R
import com.example.wallpaperapp.viewmodel.MainViewModel
import com.example.wallpaperapp.viewmodel.MainViewModelFactory
import com.example.wallpaperapp.databinding.FragmentPickPhotoBinding


class PickPhotoFragment : Fragment(R.layout.fragment_pick_photo) {
private  var _binding:FragmentPickPhotoBinding?=null
    private  val binding:FragmentPickPhotoBinding get() = _binding!!
    private lateinit var mainVm: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPickPhotoBinding.bind(view)

        mainVm = ViewModelProvider(
            requireActivity(),
            MainViewModelFactory()
        )
            .get(MainViewModel::class.java)

        getPickPhoto()
        setImagetoWallpaper()
    }



    private fun getPickPhoto(){

        binding.pickImageView.load(mainVm.picPhoto.value){
            transformations(RoundedCornersTransformation())
        }
    }

    private fun setImagetoWallpaper(){
        val wallpaperManager = WallpaperManager.getInstance(requireContext())
        binding.pickWallButton.setOnClickListener {
            wallpaperManager.setBitmap(binding.pickImageView.drawable.toBitmap())

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}