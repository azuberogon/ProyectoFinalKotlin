package com.example.dallyproject.imanol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.dallyproject.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Nuevos_objetivos : AppCompatActivity() {
    private lateinit var nombre : EditText
    private lateinit var lugar : EditText

    private lateinit var btnCancelar : Button
    private lateinit var btnGuardar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevos_objetivos)

        nombre = findViewById(R.id.editTxtNombre)
        lugar = findViewById(R.id.editTxtLugar)

        btnCancelar = findViewById(R.id.btnCancelar)
        btnGuardar = findViewById(R.id.btnGuardar)

        btnCancelar.setOnClickListener {
            finish()
        }
        btnGuardar.setOnClickListener {
            var tematica = TematicaEntity(nombre.text.toString(), lugar.text.toString())

            var localDB = LocalDatabase.getInstance(this)

            GlobalScope.launch(Dispatchers.IO) {
                localDB.tematicasDao().insertAll(tematica)
                Log.d("Nuevos_objetivos", "Tematica insertada correctamente")
            }
        }
    }
}