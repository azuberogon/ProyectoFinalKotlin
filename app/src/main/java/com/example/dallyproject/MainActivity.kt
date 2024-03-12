package com.example.dallyproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.dallyproject.imanol.LocalDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Actividad principal que muestra la pantalla de inicio de sesión de la aplicación.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var editTxtUsuario: EditText
    private lateinit var editTxtContrasenia: EditText
    private lateinit var btnSiguiente: Button
    private lateinit var btnCrearUsuario: Button

    /**
     * Se llama cuando se crea la actividad. Aquí es donde se inicializan las vistas y se configuran los listeners.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTxtUsuario = findViewById(R.id.inpTxtUsuario)
        editTxtContrasenia = findViewById(R.id.inpTextContrasenia)

        btnCrearUsuario = findViewById(R.id.btnSignUp)
        btnSiguiente = findViewById(R.id.btnLogin)

        btnSiguiente.setOnClickListener {
            val contexto = this@MainActivity
            GlobalScope.launch(Dispatchers.IO) {
                val localDB = LocalDatabase.getInstance(contexto)
                val existingUser = localDB.signUpDao().findByUsernameAndPassword(
                    editTxtUsuario.text.toString(),
                    editTxtContrasenia.text.toString()
                )
                if (existingUser == null) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(contexto, "El usuario no existe", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    val intent = Intent(contexto, MainActivityInterna::class.java)
                    contexto.startActivity(intent)
                }
            }
        }

        btnCrearUsuario.setOnClickListener {
            val intent = Intent(this@MainActivity, com.example.dallyproject.imanol.Sign_up::class.java)
            startActivity(intent)
        }
    }
}
