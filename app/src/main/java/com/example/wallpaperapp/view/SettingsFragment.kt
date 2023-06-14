package com.example.wallpaperapp.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatDelegate
import com.example.wallpaperapp.R
import com.example.wallpaperapp.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private  var _binding: FragmentSettingsBinding?=null
    private  val binding: FragmentSettingsBinding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)

        setNightMode()
    }



private fun setNightMode(){
    val sharedPref =requireActivity().getSharedPreferences(
        "night_mode",
        Context.MODE_PRIVATE)
    val editor = sharedPref.edit()
    val getShared = sharedPref.getBoolean("night_mode",false)
    binding.settingsSwitch.isChecked = getShared
    binding.settingsSwitch.setOnCheckedChangeListener { _, isCheked ->
        if (isCheked) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            binding.settingsSwitch.isChecked = true
            editor.putBoolean("night_mode", true).apply()
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            binding.settingsSwitch.isChecked = false
            editor.putBoolean("night_mode", false).apply()
        }
    }

}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}



