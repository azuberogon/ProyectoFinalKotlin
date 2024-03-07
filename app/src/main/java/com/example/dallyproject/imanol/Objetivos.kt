package com.example.dallyproject.imanol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dallyproject.R
import com.example.dallyproject.databinding.ActivityObjetivosBinding

class Objetivos : Fragment(R.layout.activity_objetivos) {
    //private lateinit var tematicasAdapter: TematicasObjetivosAdapter
    //private lateinit var recyclerViewTematicas: RecyclerView
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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val listaTematicas = mutableListOf<TematicaObjetivos>()
            listaTematicas.add(TematicaObjetivos("Tema 1", 50))
            listaTematicas.add(TematicaObjetivos("Tema 2", 75))
            // Puedes agregar más instancias de TematicaObjetivos aquí según sea necesario

            val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewObjetivos)
            val adapter = TematicasObjetivosAdapter(listaTematicas)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}
