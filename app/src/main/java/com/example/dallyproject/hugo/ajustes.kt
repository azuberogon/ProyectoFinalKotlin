package com.example.dallyproject.hugo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.dallyproject.R
import com.example.dallyproject.databinding.ActivityAjustesBinding
import com.google.android.material.switchmaterial.SwitchMaterial

class ajustes : Fragment(R.layout.activity_ajustes) {

    private var _binding: ActivityAjustesBinding? = null
    private val binding get() = _binding!!

    // This lateinit var might not be necessary if you're using ViewBinding to access the switch.
    // private lateinit var swDarkMode: SwitchMaterial

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityAjustesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Using ViewBinding, you don't need to use findViewById
        val swDarkMode = binding.swDarkMode

        swDarkMode.setOnCheckedChangeListener { _, isSelected ->
            if (isSelected) {
                enableDarkMode()
            } else {
                disableDarkMode()
            }
        }
    }

    private fun enableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        (activity as? AppCompatActivity)?.delegate?.applyDayNight()
    }

    private fun disableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        (activity as? AppCompatActivity)?.delegate?.applyDayNight()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Clear the ViewBinding reference
    }
}