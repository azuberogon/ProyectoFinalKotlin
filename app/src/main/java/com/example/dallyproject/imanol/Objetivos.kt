package com.example.dallyproject.imanol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dallyproject.R

class Objetivos : AppCompatActivity() {
    private lateinit var tematicasAdapter: TematicasObjetivosAdapter
    private lateinit var recyclerViewTematicas: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objetivos)

        // Supongamos que tienes una lista de temáticas de objetivos
        val listaTematicas = mutableListOf<TematicaObjetivos>()
        listaTematicas.add(TematicaObjetivos("Tema 1", 50))
        listaTematicas.add(TematicaObjetivos("Tema 2", 75))
        // Añade más temáticas si es necesario

        recyclerViewTematicas = findViewById(R.id.recyclerViewObjetivos)
        // Configurar RecyclerView
        tematicasAdapter = TematicasObjetivosAdapter(listaTematicas)
        recyclerViewTematicas.layoutManager = LinearLayoutManager(this)
        recyclerViewTematicas.adapter = tematicasAdapter
    }
}