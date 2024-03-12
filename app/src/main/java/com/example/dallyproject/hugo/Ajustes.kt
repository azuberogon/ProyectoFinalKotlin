/**
 * Fragmento que muestra la pantalla de ajustes de la aplicación.
 * Permite al usuario cambiar entre los modos claro y oscuro, así como enviar texto al servidor.
 */
package com.example.dallyproject.hugo

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
import java.io.IOException

class Ajustes : Fragment(R.layout.activity_ajustes) {

    private lateinit var botonDiaMes: Button

    // Binding para la vista de la actividad
    private var _binding: ActivityAjustesBinding? = null
    private val binding get() = _binding!!

    /**
     * Infla el diseño de la actividad y lo devuelve como una vista.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityAjustesBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Configura los listeners y la lógica de la vista después de que se ha creado.
     */
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

    /**
     * Habilita el modo oscuro en la aplicación.
     */
    private fun enableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        (activity as? AppCompatActivity)?.delegate?.applyDayNight()
    }

    /**
     * Deshabilita el modo oscuro en la aplicación.
     */
    private fun disableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        (activity as? AppCompatActivity)?.delegate?.applyDayNight()
    }

    /**
     * Envía un texto al servidor utilizando un socket TCP.
     * @param texto El texto a enviar al servidor.
     */
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

    /**
     * Limpia la referencia de ViewBinding cuando se destruye la vista.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
