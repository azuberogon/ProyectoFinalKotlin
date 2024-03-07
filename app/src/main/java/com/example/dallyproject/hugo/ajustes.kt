package com.example.dallyproject.hugo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dallyproject.R
import com.example.dallyproject.databinding.ActivityAjustesBinding

class ajustes : Fragment(R.layout.activity_ajustes) {

    private lateinit var binding: ActivityAjustesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAjustesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_ajustes, container, false)
    }

}