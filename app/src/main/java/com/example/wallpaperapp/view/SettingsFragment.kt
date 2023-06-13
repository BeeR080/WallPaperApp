package com.example.wallpaperapp.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatDelegate
import com.example.wallpaperapp.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
private val activity = MainActivity()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentSettingsBinding.inflate(inflater)


setNightMode()

        return binding.root
    }




private fun setNightMode(){
    val sharedPref =requireActivity().getSharedPreferences(
        "night_mode",
        Context.MODE_PRIVATE)
    val editor = sharedPref.edit()
    val getShared = sharedPref.getBoolean("night_mode",false)
    binding.settingsSwitch.isChecked = getShared

    binding.settingsSwitch.setOnCheckedChangeListener(object :CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(cB: CompoundButton?, isCheked: Boolean) {
            if(isCheked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.settingsSwitch.isChecked = true
                editor.putBoolean("night_mode",true).apply()
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.settingsSwitch.isChecked = false
                editor.putBoolean("night_mode",false).apply()
            }
        }

    })

    }

}



