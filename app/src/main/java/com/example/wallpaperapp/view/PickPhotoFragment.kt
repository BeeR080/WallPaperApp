package com.example.wallpaperapp.view

import android.app.WallpaperManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModelProvider
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.wallpaperapp.MainViewModel
import com.example.wallpaperapp.MainViewModelFactory
import com.example.wallpaperapp.databinding.FragmentPickPhotoBinding


class PickPhotoFragment : Fragment() {
private lateinit var binding:FragmentPickPhotoBinding
    private lateinit var mainVm: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPickPhotoBinding.inflate(inflater)

        mainVm = ViewModelProvider(
            requireActivity(),
            MainViewModelFactory()
        )
            .get(MainViewModel::class.java)


        getPickPhoto()
        setImagetoWallpaper()

        return binding.root

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


}