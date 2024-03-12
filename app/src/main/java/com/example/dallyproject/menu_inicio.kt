package com.example.dallyproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.dallyproject.databinding.ActivityMenuInicioBinding

/**
 * Fragmento que muestra el menú de inicio con opciones para navegar a diferentes partes de la aplicación.
 */
class menu_inicio : Fragment() {

    private var _binding: ActivityMenuInicioBinding? = null
    private val binding get() = _binding!!

    /**
     * Se llama cuando se crea la vista del fragmento. Infla y devuelve el diseño del menú de inicio.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityMenuInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Se llama después de que la vista del fragmento haya sido creada. Configura los listeners de clic para los botones del menú.
     */
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

    /**
     * Se llama cuando la vista del fragmento está siendo destruida. Limpia la referencia a la vista para evitar memory leaks.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
