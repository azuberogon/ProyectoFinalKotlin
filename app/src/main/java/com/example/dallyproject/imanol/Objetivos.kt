package com.example.dallyproject.imanol

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dallyproject.databinding.ActivityObjetivosBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Objetivos : AppCompatActivity() {

    private lateinit var binding: ActivityObjetivosBinding
    private lateinit var btnAgregar: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerViewAdapterObjetivos
    private lateinit var btnEliminarTodo: FloatingActionButton

    private var listaNombres: ArrayList<Any> = ArrayList()
    private var listaLugares: ArrayList<Any> = ArrayList()

    // Bandera para controlar si la lista ya se ha actualizado una vez
    private var listaActualizada: Boolean = false

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityObjetivosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnAgregar = binding.btnAgregarTematica
        recyclerView = binding.recyclerViewObjetivos
        btnEliminarTodo = binding.btnVaciarRecyclerView

        adapter = RecyclerViewAdapterObjetivos(this, listaNombres, listaLugares)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Solo actualiza la lista la primera vez que se carga la actividad
        if (!listaActualizada) {
            displayData()
            listaActualizada = true
        }

        btnAgregar.setOnClickListener {
            val intent = Intent(this, Nuevos_objetivos::class.java)
            startActivity(intent)
            // Después de agregar un nuevo elemento, actualiza la lista
            displayData()
        }

        btnEliminarTodo.setOnClickListener {
            // Elimina todos los elementos de las listas
            listaNombres.clear()
            listaLugares.clear()
            // Notifica al adaptador que los datos han cambiado
            adapter.notifyDataSetChanged()

            GlobalScope.launch(Dispatchers.IO) {
                val localDB = LocalDatabase.getInstance(this@Objetivos)
                localDB.tematicasDao().deleteAll()
            }
        }
    }

    private fun displayData() {
        GlobalScope.launch(Dispatchers.IO) {
            val localDB = LocalDatabase.getInstance(this@Objetivos)
            val listaInstancias: List<TematicaEntity> = localDB.tematicasDao().getAll()
            withContext(Dispatchers.Main) {
                if (listaInstancias.isEmpty()) {
                    // Manejar el caso en el que no hay datos, por ejemplo, mostrar un mensaje o una vista alternativa
                    Toast.makeText(this@Objetivos, "No hay datos disponibles", Toast.LENGTH_SHORT).show()
                } else {
                    // Limpiar las listas antes de actualizarlas
                    listaNombres.clear()
                    listaLugares.clear()

                    for (instancia in listaInstancias) {
                        listaNombres.add(instancia.nombre)
                        listaLugares.add(instancia.lugar)
                    }
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}