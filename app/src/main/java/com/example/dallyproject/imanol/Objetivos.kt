package com.example.dallyproject.imanol
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.dallyproject.R
import com.example.dallyproject.databinding.ActivityObjetivosBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Objetivos : Fragment() {

    private lateinit var binding: ActivityObjetivosBinding
    private lateinit var btnAgregar : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityObjetivosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAgregar = view.findViewById(R.id.btnAgregarTematica)

        btnAgregar.setOnClickListener {
            val intent = Intent(requireActivity(), Nuevos_objetivos::class.java)

            startActivity(intent)
        }
    }
}