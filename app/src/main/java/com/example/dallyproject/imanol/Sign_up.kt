package com.example.dallyproject.imanol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.dallyproject.MainActivity
import com.example.dallyproject.MainActivityInterna
import com.example.dallyproject.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Actividad que permite a un usuario registrarse en la aplicación.
 * El usuario puede ingresar un nombre de usuario, correo electrónico y contraseña para registrarse.
 */
class Sign_up : AppCompatActivity() {

    private lateinit var nombreUsuario: EditText
    private lateinit var email: EditText
    private lateinit var contrasenia: EditText
    private lateinit var contraseniaRepetida: EditText

    /**
     * Método de inicialización de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Inicialización de los campos de texto
        nombreUsuario = findViewById(R.id.inputTxtNombre)
        email = findViewById(R.id.inputTxtEmail)
        contrasenia = findViewById(R.id.inputTxtContraseina)
        contraseniaRepetida = findViewById(R.id.inputTxtRepetirContrasenia)

        // Botón para el registro de usuario
        val btnRegistro = findViewById<Button>(R.id.btnRegistrarse)
        // Botón para la navegación hacia la actividad de inicio de sesión
        val btnNavegacion = findViewById<Button>(R.id.btnLogIn)

        btnRegistro.setOnClickListener {
            // Verifica si las contraseñas coinciden
            if (contrasenia.text.toString() != contraseniaRepetida.text.toString()) {
                // Muestra un mensaje de error si las contraseñas no coinciden
                Toast.makeText(this@Sign_up, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // Crea un nuevo objeto SignUpEntity con los datos ingresados por el usuario
            val nuevoUsuario = SignUpEntity(
                nombreUsuario.text.toString(),
                email.text.toString(),
                contrasenia.text.toString(),
                contraseniaRepetida.text.toString()
            )

            // Accede a la base de datos local en un hilo de fondo
            GlobalScope.launch(Dispatchers.IO) {
                val localDB = LocalDatabase.getInstance(this@Sign_up)
                // Busca si ya existe un usuario con el mismo nombre de usuario
                val existingUser = localDB.signUpDao().findByUsername(nuevoUsuario.usuario)
                if (existingUser != null) {
                    // Muestra un mensaje si el usuario ya existe
                    Toast.makeText(this@Sign_up, "El usuario ya existe", Toast.LENGTH_SHORT).show()
                } else {
                    // Inserta el nuevo usuario en la base de datos
                    localDB.signUpDao().insert(nuevoUsuario)
                    // Navega a la actividad principal interna después del registro exitoso
                    val intent = Intent(this@Sign_up, MainActivityInterna::class.java)
                    startActivity(intent)
                }
            }
        }

        // Listener para el botón de navegación hacia la actividad de inicio de sesión
        btnNavegacion.setOnClickListener {
            val intent = Intent(this@Sign_up, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
