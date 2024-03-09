package com.example.dallyproject.imanol
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import com.example.dallyproject.R
import com.example.dallyproject.databinding.ActivityObjetivosBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Objetivos : Fragment() {

    private lateinit var binding: ActivityObjetivosBinding
    private lateinit var btnAgregar : Button
    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter: RecyclerViewAdapter

    private var listaNombres: ArrayList<Any> = ArrayList()
    private var listaLugares: ArrayList<Any> = ArrayList()

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
        recyclerView = view.findViewById(R.id.recyclerViewObjetivos)

        adapter = RecyclerViewAdapter(requireContext(), listaNombres, listaLugares)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        displayData()

        btnAgregar.setOnClickListener {
            val intent = Intent(requireActivity(), Nuevos_objetivos::class.java)
            startActivity(intent)
            displayData() // Llama a displayData después de agregar un nuevo elemento
        }
    }

    private fun displayData() {
        GlobalScope.launch(Dispatchers.IO) {
            val localDB = LocalDatabase.getInstance(requireContext())
            val listaInstancias: List<TematicaEntity> = localDB.tematicasDao().getAll()
            withContext(Dispatchers.Main) {
                if (listaInstancias.isEmpty()) {
                    // Manejar el caso en el que no hay datos, por ejemplo, mostrar un mensaje o una vista alternativa
                    Toast.makeText(requireContext(), "No hay datos disponibles", Toast.LENGTH_SHORT).show()
                } else {
                    for (instancia in listaInstancias) {
                        listaNombres.add(instancia.nombre)
                        listaLugares.add(instancia.lugar)
                    }
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}
