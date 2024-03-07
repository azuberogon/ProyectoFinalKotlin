package com.example.dallyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dallyproject.databinding.ActivityMenuInicioBinding

class menu_inicio : Fragment(R.layout.activity_menu_inicio) {

    private lateinit var binding: ActivityMenuInicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMenuInicioBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.textView.text = "Fragment Inicio"

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_menu_inicio, container, false)
    }

}