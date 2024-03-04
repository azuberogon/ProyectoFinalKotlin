package com.example.dallyproject.imanol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.dallyproject.R
import com.example.dallyproject.loggin

class sign_up : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btnNavegacion = findViewById<Button>(R.id.btnNavegacion)
        btnNavegacion.setOnClickListener {
            val intent = Intent(this, loggin::class.java)
            startActivity(intent)
        }
    }
}