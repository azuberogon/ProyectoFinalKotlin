package com.example.dallyproject.hugo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dallyproject.R

/**
 * Actividad que muestra el diario de la aplicación.
 * Esta actividad se encarga de mostrar la interfaz de usuario relacionada con el diario.
 */
class Diario : AppCompatActivity() {
    /**
     * Método de inicialización de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diario)
    }
}
