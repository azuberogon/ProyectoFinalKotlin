package com.example.dallyproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

open class MainActivity : AppCompatActivity() {
    private lateinit var btnLoggin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLoggin = findViewById(R.id.btnLoggin)

        btnLoggin.setOnClickListener {
            val  intent = Intent(this@MainActivity,Loggin::class.java)
            val  intent2 = Intent(this@MainActivity,Sqlite::class.java)
            startActivity(intent)
            startActivity(intent2)

        }
    }








}