package com.example.dallyproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.dallyproject.db.DbHelper


open class MainActivity : AppCompatActivity() {
    private lateinit var btnLoggin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLoggin = findViewById(R.id.btnLoggin)

        btnLoggin.setOnClickListener {//al clicar se comprobara si la base de datos esta creada en caso contrario la crea. tiene otro metodo DbHelper que elimina todo

            val  intent = Intent(this@MainActivity,Loggin::class.java)
            startActivity(intent)
            val dbHelper = DbHelper(this) //clase base de datos
            dbHelper.test()
            val db = dbHelper.writableDatabase
            if (db != null) {
                Log.d("Mi etiqueta numero uno", "La base de datos no es null") //estos mensaje se miran en LogCAt el tag es el id del mensaje segunda columna y el resto es el mensaje
            } else {
                Log.d("Mi etiqueta numero dos", "La base de datos se nulll")
            }


        }
    }








}