package com.example.dallyproject

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.dallyproject.databinding.ActivityCalendarioBinding

/**
 * Fragmento que muestra un calendario básico con los días de la semana y los números del 1 al 31.
 */
class Calendario : Fragment() {

    private var _binding: ActivityCalendarioBinding? = null
    private val binding get() = _binding!!

    /**
     * Infla y devuelve el diseño asociado con este fragmento.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = ActivityCalendarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Se llama después de que onCreateView(LayoutInflater, ViewGroup, Bundle) haya terminado.
     * Aquí es donde se configuran las vistas y se realiza cualquier otra inicialización necesaria.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gridLayout = binding.gridLayout

        val daysOfWeek = arrayOf("L", "M", "X", "J", "V", "S", "D")
        var buttonNumber = 1

        for (row in 0 until 6) {
            for (col in 0 until 7) {
                if (row == 0) {
                    // Primera fila, agrega TextViews con los días de la semana
                    val textView = TextView(context).apply {
                        text = daysOfWeek[col]
                        textSize = 16f
                        gravity = Gravity.CENTER
                        setTextColor(ContextCompat.getColor(requireContext(), android.R.color.black))
                    }

                    textView.layoutParams = GridLayout.LayoutParams(
                        GridLayout.spec(row, 1f),
                        GridLayout.spec(col, 1f)
                    ).apply {
                        width = 0
                        height = 0
                        setMargins(8, 8, 8, 8)
                    }

                    gridLayout.addView(textView)
                } else {
                    // Resto de las filas, agrega Buttons numerados del 1 al 31
                    val buttonText = if (buttonNumber <= 31) buttonNumber++.toString() else ""
                    val button = Button(context).apply {
                        text = buttonText
                        textSize = 16f
                    }

                    button.layoutParams = GridLayout.LayoutParams(
                        GridLayout.spec(row, 1f),
                        GridLayout.spec(col, 1f)
                    ).apply {
                        width = 0
                        height = 0
                        setMargins(8, 8, 8, 8)
                    }

                    gridLayout.addView(button)
                }
            }
        }
    }

    /**
     * Se llama cuando el fragmento ya no está siendo usado o se está eliminando.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Limpia la referencia a binding para evitar memory leaks
    }
}
