package com.example.dallyproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class loggin : AppCompatActivity() {
    private lateinit var inputTxtNombre: EditText
    private lateinit var inputTxtApellidos: EditText
    private lateinit var inputTxtContraseña: EditText
    private lateinit var inputTxtContraseniaRepetir: EditText
    private lateinit var inputTxtTelefono: EditText
    private lateinit var inputFNacimiento: EditText
    private lateinit var btnEnviar: Button
    private lateinit var btnCancelar: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loggin)

        inputTxtNombre = findViewById(R.id.inputTxtNombre)
        inputTxtApellidos = findViewById(R.id.inputTxtApellidos)
        inputTxtContraseña = findViewById(R.id.inputTxtContrasenia)
        inputTxtContraseniaRepetir = findViewById(R.id.inputTxtContraseniaRepetir)
        inputTxtTelefono = findViewById(R.id.inputTxtTelefono)
        inputFNacimiento = findViewById(R.id.inputFNacimiento)


        btnEnviar = findViewById(R.id.btnEnviar)

        btnEnviar.setOnClickListener {

            val intent = Intent(this@loggin, menu_inicio :: class.java )
            startActivity(intent)
            val  numeroTel = convertirEditTextAEntero(inputTxtTelefono)
            if (numeroTel != null) {
                //dbHelper.crearUsuario(inputTxtNombre.toString(),inputTxtContraseña.toString(),numeroTel,inputTxtContraseniaRepetir.toString())
            }else{
                Toast.makeText(applicationContext, "Error en el numero de telefono ponga un numero correcto", Toast.LENGTH_SHORT).show()
            }
        }
        btnCancelar = findViewById(R.id.btnCancelar)
        btnCancelar.setOnClickListener {


        }



    }
    fun convertirEditTextAEntero(editText: EditText): Int? {
        val textoNumero = editText.text.toString()
        return textoNumero.toIntOrNull()
    }

}