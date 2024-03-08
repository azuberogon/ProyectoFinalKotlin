package com.example.dallyproject.richi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.dallyproject.Calendario.Calendario
import com.example.dallyproject.R
import com.example.dallyproject.hugo.ajustes


class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnOption1 = findViewById<Button>(R.id.btnOption1)
        val btnOption2 = findViewById<Button>(R.id.btnOption2)
        val btnOption3 = findViewById<Button>(R.id.btnOption3)

        btnOption1.setOnClickListener {
            // Para ir a la actividad calendario
            startActivity(Intent(this, Calendario::class.java))
        }

        btnOption2.setOnClickListener {
            // Para ir a la actividad objetivos
            //startActivity(Intent(this, Objetivos::class.java))
        }

        btnOption3.setOnClickListener {
            // Para ir a la actividad ajustes
            startActivity(Intent(this, ajustes::class.java))
        }
    }
}