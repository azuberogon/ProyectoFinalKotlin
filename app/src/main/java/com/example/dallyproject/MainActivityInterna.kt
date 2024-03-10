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

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Configura el BottomNavigationView para usar el NavController
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)

        // Manejar la selección de los ítems manualmente para asegurar que siempre se navegue al inicio de la pila
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_inicio -> {
                    // Navega al inicio solo si no estamos ya en la página de inicio
                    if(navController.currentDestination?.id != R.id.page_inicio) {
                        navController.popBackStack(R.id.page_inicio, false)
                    }
                    true
                }
                R.id.page_calendario -> {
                    // Navega al calendario solo si no estamos ya en la página del calendario
                    if(navController.currentDestination?.id != R.id.page_calendario) {
                        navController.navigate(R.id.page_calendario)
                    }
                    true
                }
                R.id.page_objetivos -> {
                    // Similar para objetivos
                    if(navController.currentDestination?.id != R.id.page_objetivos) {
                        navController.navigate(R.id.page_objetivos)
                    }
                    true
                }
                R.id.page_configuraciones -> {
                    // Similar para configuraciones
                    if(navController.currentDestination?.id != R.id.page_configuraciones) {
                        navController.navigate(R.id.page_configuraciones)
                    }
                    true
                }
                else -> false
            }
        }
    }
}

