package com.example.dallyproject.imanol

import Objetivos
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.dallyproject.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Actividad que permite al usuario agregar nuevos objetivos o temáticas.
 * El usuario puede ingresar un nombre y un lugar para el nuevo objetivo.
 * Al guardar, se inserta en la base de datos local y se redirige a la ventana de Objetivos.
 */
class Nuevos_objetivos : AppCompatActivity() {
    private lateinit var nombre: EditText
    private lateinit var lugar: EditText

    private lateinit var btnCancelar: Button
    private lateinit var btnGuardar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevos_objetivos)

        nombre = findViewById(R.id.editTxtNombre)
        lugar = findViewById(R.id.editTxtLugar)

        btnCancelar = findViewById(R.id.btnCancelar)
        btnGuardar = findViewById(R.id.btnGuardar)

        // Listener para el botón de cancelar
        btnCancelar.setOnClickListener {
            finish() // Finaliza la actividad actual
        }

        // Listener para el botón de guardar
        btnGuardar.setOnClickListener {
            // Crea un objeto TematicaEntity con los datos ingresados por el usuario
            val tematica = TematicaEntity(nombre.text.toString(), lugar.text.toString())

            val localDB = LocalDatabase.getInstance(this)

            // Inserta la temática en la base de datos local en un hilo de fondo
            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val insertado = localDB.tematicasDao().insertAll(tematica)
                    if (insertado.isNotEmpty()) {
                        // Se insertaron filas exitosamente
                        Log.d("Nuevos_objetivos", "Tematica insertada correctamente")
                        // Navegar automáticamente a la ventana Objetivos
                        startActivity(Intent(this@Nuevos_objetivos, Objetivos::class.java))
                        // Finalizar la actividad actual
                        finish()
                    } else {
                        // No se insertaron filas
                        Log.d("Nuevos_objetivos", "No se pudo insertar la tematica")
                    }
                } catch (e: Exception) {
                    // Si ocurre algún error durante la inserción, se captura aquí
                    Log.e("Nuevos_objetivos", "Error al insertar la tematica: ${e.message}")
                }
            }
        }
    }
}
