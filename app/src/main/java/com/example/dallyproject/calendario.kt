package com.example.dallyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dallyproject.databinding.ActivityCalendarioBinding

class calendario : Fragment(R.layout.activity_calendario) {

    private lateinit var binding: ActivityCalendarioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCalendarioBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityCalendarioBinding.inflate(layoutInflater)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_calendario, container, false)
    }


}