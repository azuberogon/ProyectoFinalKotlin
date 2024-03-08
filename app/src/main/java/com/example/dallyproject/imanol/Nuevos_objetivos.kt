package com.example.dallyproject.imanol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.dallyproject.R

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


    }
}