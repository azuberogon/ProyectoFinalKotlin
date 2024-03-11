package com.example.dallyproject.hugo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.dallyproject.R
import com.example.dallyproject.databinding.ActivityAjustesBinding
import com.example.dallyproject.hugo.ayuda.SocketTCPCliente
import com.example.dallyproject.imanol.Nuevos_objetivos
import java.io.IOException

class Ajustes : Fragment(R.layout.activity_ajustes) {

    private lateinit var botonDiaMes:Button

    private var _binding: ActivityAjustesBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityAjustesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configuración del modo oscuro
        binding.swDarkMode.setOnCheckedChangeListener { _, isSelected ->
            if (isSelected) {
                enableDarkMode()
            } else {
                disableDarkMode()
            }
        }

        // Envío de texto al servidor
        binding.buttonSave.setOnClickListener {
            val textoAyuda = binding.editTextTitle.text.toString()
            enviarTextoAlServidor(textoAyuda)
        }
    }

    private fun enableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        (activity as? AppCompatActivity)?.delegate?.applyDayNight()
    }

    private fun disableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        (activity as? AppCompatActivity)?.delegate?.applyDayNight()
    }

    private fun enviarTextoAlServidor(texto: String) {
        Thread {
            try {
                val cliente = SocketTCPCliente("192.168.0.1", 24000)
                cliente.start()
                cliente.sendMessage(texto)
                cliente.stop()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Clear the ViewBinding reference
    }

}
