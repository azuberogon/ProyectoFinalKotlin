import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dallyproject.R
import com.example.dallyproject.imanol.LocalDatabase
import com.example.dallyproject.imanol.Nuevos_objetivos
import com.example.dallyproject.imanol.RecyclerViewAdapterObjetivos
import com.example.dallyproject.imanol.TematicaEntity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Objetivos : AppCompatActivity() {

    private lateinit var btnAgregar: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerViewAdapterObjetivos
    private lateinit var btnEliminarTodo: FloatingActionButton

    private var listaNombres: ArrayList<Any> = ArrayList()
    private var listaLugares: ArrayList<Any> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objetivos)

        btnAgregar = findViewById(R.id.btnAgregarTematica)
        recyclerView = findViewById(R.id.recyclerViewObjetivos)
        btnEliminarTodo = findViewById(R.id.btnVaciarRecyclerView)

        adapter = RecyclerViewAdapterObjetivos(this, listaNombres, listaLugares)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        btnAgregar.setOnClickListener {
            val intent = Intent(this, Nuevos_objetivos::class.java)
            startActivity(intent)
        }

        btnEliminarTodo.setOnClickListener {
            // Elimina todos los elementos de las listas
            listaNombres.clear()
            listaLugares.clear()
            // Notifica al adaptador que los datos han cambiado
            adapter.notifyDataSetChanged()

            GlobalScope.launch(Dispatchers.IO) {
                val localDB = LocalDatabase.getInstance(this@Objetivos)
                localDB.tematicasDao().deleteAll()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        // Actualiza la lista cada vez que la actividad se reanuda
        displayData()
    }

    private fun displayData() {
        GlobalScope.launch(Dispatchers.IO) {
            val localDB = LocalDatabase.getInstance(this@Objetivos)
            val listaInstancias: List<TematicaEntity> = localDB.tematicasDao().getAll()
            withContext(Dispatchers.Main) {
                if (listaInstancias.isEmpty()) {
                    // Manejar el caso en el que no hay datos, por ejemplo, mostrar un mensaje o una vista alternativa
                    Toast.makeText(this@Objetivos, "No hay datos disponibles", Toast.LENGTH_SHORT).show()
                } else {
                    // Limpiar las listas antes de actualizarlas
                    listaNombres.clear()
                    listaLugares.clear()

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
