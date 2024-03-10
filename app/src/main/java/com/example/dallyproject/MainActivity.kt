package com.example.dallyproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.dallyproject.databinding.ActivityMainBinding
import com.example.dallyproject.imanol.LocalDatabase
import com.example.dallyproject.imanol.SignUpEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var editTxtUsuario:EditText
    private lateinit var editTxtContraseina:EditText
    private lateinit var btnSiguiente : Button
    private lateinit var btnCrearUsuario : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTxtUsuario = findViewById(R.id.inpTxtUsuario)
        editTxtContraseina = findViewById(R.id.inpTextContrasenia)

        btnCrearUsuario = findViewById(R.id.btnSignUp)
        btnSiguiente = findViewById(R.id.btnSiguiente)


        btnSiguiente.setOnClickListener{
            GlobalScope.launch(Dispatchers.IO) {
                val localDB = LocalDatabase.getInstance(this@MainActivity)
                val existingUser = localDB.signUpDao().findByUsernameAndPassword(editTxtUsuario.text.toString(), editTxtContraseina.text.toString())
                if (existingUser == null) {
                    Toast.makeText(this@MainActivity, "El usuario no existe", Toast.LENGTH_SHORT).show()
                }else {
                    val intent = Intent(this@MainActivity, menu_inicio::class.java)
                    startActivity(intent)
                }
            }
        }
        btnCrearUsuario.setOnClickListener {
            val intent = Intent(this@MainActivity, com.example.dallyproject.imanol.Sign_up::class.java)
            startActivity(intent)
        }
    }
}