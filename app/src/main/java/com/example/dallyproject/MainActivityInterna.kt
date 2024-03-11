package com.example.dallyproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.dallyproject.databinding.ActivityMainInternaBinding
import com.example.dallyproject.imanol.Objetivos

class MainActivityInterna : AppCompatActivity() {

    private lateinit var binding: ActivityMainInternaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainInternaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Configura el BottomNavigationView para usar el NavController
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_inicio, R.id.page_calendario, R.id.page_configuraciones -> {
                    // Utiliza NavController para navegar entre fragmentos.
                    NavigationUI.onNavDestinationSelected(item, navController)
                    true
                }
                R.id.page_objetivos -> {
                    // Lanza la Activity Objetivos directamente sin usar NavController
                    val intent = Intent(this, Objetivos::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}
