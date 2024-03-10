package com.example.dallyproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.dallyproject.databinding.ActivityMenuInicioBinding

class menu_inicio : Fragment() {

    private var _binding: ActivityMenuInicioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityMenuInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalendario.setOnClickListener {
            findNavController().navigate(R.id.page_calendario)
        }

        binding.btnObjetivos.setOnClickListener {
            findNavController().navigate(R.id.page_objetivos)
        }

        binding.btnAjustes.setOnClickListener {
            findNavController().navigate(R.id.page_configuraciones)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
