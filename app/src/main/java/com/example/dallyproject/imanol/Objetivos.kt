package com.example.dallyproject.imanol

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.dallyproject.R
import com.example.dallyproject.databinding.ActivityObjetivosBinding

class Objetivos : AppCompatActivity() {

    private lateinit var binding: ActivityObjetivosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityObjetivosBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_objetivos, container, false)
    }

}
