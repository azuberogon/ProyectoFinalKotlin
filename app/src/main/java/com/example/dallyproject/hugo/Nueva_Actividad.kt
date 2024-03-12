package com.example.dallyproject.hugo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.dallyproject.R
import com.example.dallyproject.imanol.LocalDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Actividad que permite al usuario agregar una nueva actividad.
 * Esta actividad presenta un formulario donde el usuario puede ingresar el nombre y la descripción de la actividad.
 * Al guardar la actividad, se inserta en la base de datos local y se redirige al usuario de vuelta al calendario del día.
 */
class Nueva_Actividad : AppCompatActivity() {
    private lateinit var editTxtNombre: EditText
    private lateinit var editTxtDescripcion: EditText
    private lateinit var botonGuardar: Button

    /**
     * Método de inicialización de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_actividad)

        editTxtNombre = findViewById(R.id.editTextNombre)
        editTxtDescripcion = findViewById(R.id.editTextDescription)

        botonGuardar = findViewById(R.id.btnGuardarActividad)

        // Listener para el botón de guardar actividad
        botonGuardar.setOnClickListener {
            // Crea un objeto ActividadEntity con los datos ingresados por el usuario
            val actividad = ActividadEntity(
                editTxtNombre.text.toString(),
                editTxtDescripcion.text.toString()
            )

            val localDB = LocalDatabase.getInstance(this)

            // Inserta la actividad en la base de datos local en un hilo de fondo
            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val insertado = localDB.actividadDao().insert(actividad)
                    if (insertado > 0) {
                        Log.d("Nuevos_objetivos", "Actividad insertada correctamente")
                        // Redirige al usuario de vuelta al calendario del día después de guardar la actividad
                        startActivity(Intent(this@Nueva_Actividad, Calendario_Dia::class.java))
                        finish()
                    } else {
                        Log.d("Nuevos_objetivos", "No se pudo insertar la actividad")
                    }
                } catch (e: Exception) {
                    Log.e("Nuevos_objetivos", "Error al insertar la actividad: ${e.message}")
                }
            }
        }
    }
}
