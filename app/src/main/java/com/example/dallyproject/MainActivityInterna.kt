package com.example.dallyproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.dallyproject.databinding.ActivityMainInternaBinding

class MainActivityInterna : AppCompatActivity() {

    private lateinit var binding: ActivityMainInternaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainInternaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavegacion()
    }

    private fun setupNavegacion() {
        val bottomNavigationView = binding.bottomNavigationView
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(
            bottomNavigationView,
            navHostFragment.navController
        )
    }
}