package com.example.dallyproject.imanol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.dallyproject.MainActivity
import com.example.dallyproject.R
import com.example.dallyproject.menu_inicio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Sign_up : AppCompatActivity() {

    private lateinit var nombreUsuario : EditText
    private lateinit var email : EditText
    private lateinit var contraseina : EditText
    private lateinit var contraseinaRepetida : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        nombreUsuario = findViewById(R.id.inputTxtNombre)
        email = findViewById(R.id.inputTxtEmail)
        contraseina = findViewById(R.id.inputTxtContraseina)
        contraseinaRepetida = findViewById(R.id.inputTxtRepetirContrasenia)

        val btnRegistro = findViewById<Button>(R.id.btnRegistrarse)
        val btnNavegacion = findViewById<Button>(R.id.btnLogIn)

        btnRegistro.setOnClickListener {
            if (contraseina.text.toString() != contraseinaRepetida.text.toString()) {
                // Mostrar un mensaje de error si las contraseñas no coinciden
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val nuevoUsuario = SignUpEntity(nombreUsuario.text.toString(), email.text.toString(), contraseina.text.toString(), contraseinaRepetida.text.toString())

            GlobalScope.launch(Dispatchers.IO) {
                val localDB = LocalDatabase.getInstance(this@Sign_up)
                val existingUser = localDB.signUpDao().findByUsername(nuevoUsuario.usuario)
                if (existingUser != null) {
                    Toast.makeText(this@Sign_up, "El usuario ya existe", Toast.LENGTH_SHORT).show()

                }else {
                    localDB.signUpDao().insert(nuevoUsuario)
                    val intent = Intent(this@Sign_up, menu_inicio::class.java)
                    startActivity(intent)
                }
            }
        }

        btnNavegacion.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}