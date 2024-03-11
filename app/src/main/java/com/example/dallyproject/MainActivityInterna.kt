package com.example.dallyproject

import Objetivos
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.dallyproject.databinding.ActivityMainInternaBinding
import com.example.dallyproject.hugo.calendario_Dia

class MainActivityInterna : AppCompatActivity() {

    private lateinit var binding: ActivityMainInternaBinding
    private lateinit var btnDiaMes:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainInternaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnDiaMes = findViewById(R.id.botonDiaMes)
        btnDiaMes.setOnClickListener {
            val intent = Intent(this, calendario_Dia::class.java)
            startActivity(intent)
        }

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
                    // Navega a la actividad Objetivos en lugar de al fragmento
                    startActivity(Intent(this@MainActivityInterna, Objetivos::class.java))
                    true
                }
                else -> false
            }
        }
    }
}

