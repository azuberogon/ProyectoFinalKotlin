package com.example.dallyproject.hugo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.dallyproject.R
import com.example.dallyproject.imanol.LocalDatabase
import com.example.dallyproject.imanol.Objetivos
import com.example.dallyproject.imanol.TematicaEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class nueva_actividad : AppCompatActivity() {
    private lateinit var editTxtNombre:EditText
    private lateinit var editTxtDescripcion:EditText
    private lateinit var botonGuardar:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_actividad)

        editTxtNombre = findViewById(R.id.editTextNombre)
        editTxtDescripcion = findViewById(R.id.editTextDescription)

        botonGuardar = findViewById(R.id.btnGuardarActividad)

        botonGuardar.setOnClickListener {
            val actividad = ActividadEntity(editTxtNombre.text.toString(), editTxtDescripcion.text.toString())

            val localDB = LocalDatabase.getInstance(this)

            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val insertado = localDB.actividadDao().insert(actividad)
                    if (insertado > 0) {
                        Log.d("Nuevos_objetivos", "Tematica insertada correctamente")
                        startActivity(Intent(this@nueva_actividad, calendario_Dia::class.java))
                        finish()
                    } else {
                        Log.d("Nuevos_objetivos", "No se pudo insertar la tematica")
                    }
                } catch (e: Exception) {
                    Log.e("Nuevos_objetivos", "Error al insertar la tematica: ${e.message}")
                }
            }
        }
    }
}