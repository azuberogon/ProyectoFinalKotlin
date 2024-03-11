package com.example.dallyproject.hugo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dallyproject.R
import com.example.dallyproject.imanol.LocalDatabase
import com.example.dallyproject.imanol.Nuevos_objetivos
import com.example.dallyproject.imanol.RecyclerViewAdapterObjetivos
import com.example.dallyproject.imanol.TematicaEntity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class calendario_Dia : AppCompatActivity() {
    private lateinit var btnAgregar: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerViewAdapterActividades
    private lateinit var btnEliminarTodo: FloatingActionButton

    private var listaNombres: ArrayList<Any> = ArrayList()
    private var listaDescripciones: ArrayList<Any> = ArrayList()

    private var listaActualizada: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario_dia)

        btnAgregar = findViewById(R.id.btnAgregarActividad)
        recyclerView = findViewById(R.id.recyclerViewObjetivos)
        btnEliminarTodo = findViewById(R.id.btnVaciarRecyclerView)

        adapter = RecyclerViewAdapterActividades(this, listaNombres, listaDescripciones)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Solo actualiza la lista la primera vez que se carga la actividad
        if (!listaActualizada) {
            displayData()
            listaActualizada = true
        }

        btnAgregar.setOnClickListener {
            val intent = Intent(this, nueva_actividad::class.java)
            startActivity(intent)
            // Después de agregar un nuevo elemento, actualiza la lista
            displayData()
        }

        btnEliminarTodo.setOnClickListener {
            // Elimina todos los elementos de las listas
            listaNombres.clear()
            listaDescripciones.clear()
            // Notifica al adaptador que los datos han cambiado
            adapter.notifyDataSetChanged()

            GlobalScope.launch(Dispatchers.IO) {
                val localDB = LocalDatabase.getInstance(this@calendario_Dia)
                localDB.tematicasDao().deleteAll()
            }
        }
    }
    private fun displayData() {
        GlobalScope.launch(Dispatchers.IO) {
            val localDB = LocalDatabase.getInstance(this@calendario_Dia)
            val listaActividades: List<ActividadEntity> = localDB.actividadDao().getAll()
            withContext(Dispatchers.Main) {
                if (listaActividades.isEmpty()) {
                    Toast.makeText(this@calendario_Dia, "No hay datos disponibles", Toast.LENGTH_SHORT).show()
                } else {
                    listaNombres.clear()
                    listaDescripciones.clear()

                    for (actividad in listaActividades) {
                        listaNombres.add(actividad.nombre)
                        listaDescripciones.add(actividad.descripcion)
                    }
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}