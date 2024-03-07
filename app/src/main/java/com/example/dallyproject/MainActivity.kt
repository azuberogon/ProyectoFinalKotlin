package com.example.dallyproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.dallyproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var btnSiguiente : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSiguiente = findViewById(R.id.btnSiguiente)
        btnSiguiente.setOnClickListener{
            // Crea un Intent que describe la transición a la MainInternaActivity
            val intent = Intent(this, MainActivityInterna::class.java)
            // Inicia la actividad
            startActivity(intent)
        }

    }


}