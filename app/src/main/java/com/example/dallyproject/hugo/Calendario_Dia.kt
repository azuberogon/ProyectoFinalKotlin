package com.example.dallyproject.hugo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dallyproject.R

class calendario_Dia : AppCompatActivity() {
    private lateinit var RecyclerDia: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario_dia)

        val recyclerView = findViewById<RecyclerView>(R.id.RecyclerDia)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val items = listOf("Item 1", "Item 2", "Item 3")
        recyclerView.adapter = ActividadesDiariasAdapter(items)
    }
}