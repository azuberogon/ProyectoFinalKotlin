package com.example.dallyproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dallyproject.db.DbHelper


open class MainActivity : AppCompatActivity() {
    private lateinit var btnLoggin: Button
    private lateinit var btnSiguiente: Button
    private lateinit var inpTxtUsuario: EditText
    private lateinit var inpTextContrasenia: EditText
    private lateinit var dbHelper: DbHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val dbHelper = DbHelper(this) //clase base de datos
        dbHelper = DbHelper(this); // aqui inicializamos la variable



        inpTxtUsuario = findViewById(R.id.inpTxtUsuario) // esto saca el texto del campo Usuario
        val textoUsuario = inpTxtUsuario.text.toString()// esto convierte en texto el campo Usuario de la variable editTextUsuario

        inpTextContrasenia = findViewById(R.id.inpTextContrasenia)
        val editTextContrasenia = inpTextContrasenia.text.toString()

        btnSiguiente = findViewById(R.id.btnSiguiente)// desde aqui se inicia el boton
        btnSiguiente.setOnClickListener {

            if (textoUsuario.isEmpty()) {
                // Mostrar un mensaje de error utilizando Toast
                Toast.makeText(applicationContext, "Por favor ingrese un usuario", Toast.LENGTH_SHORT).show()


            }else{
                if (dbHelper.autenticar(textoUsuario,editTextContrasenia)){
                    val  intentMenu_inicio = Intent(this@MainActivity,Menu_inicio::class.java)
                    startActivity(intentMenu_inicio)
                }else{
                    Toast.makeText(applicationContext, "Por favor ingrese un usuario que este en la BBDD", Toast.LENGTH_SHORT).show()

                }
            }
        }


        btnLoggin = findViewById(R.id.btnLoggin)
        btnLoggin.setOnClickListener {//al clicar se comprobara si la base de datos esta creada en caso contrario la crea. tiene otro metodo DbHelper que elimina todo

            val  intentLoggin = Intent(this@MainActivity,Loggin::class.java)
            startActivity(intentLoggin)

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