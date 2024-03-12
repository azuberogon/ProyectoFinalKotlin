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

/**
 * Actividad que muestra la lista de objetivos o temáticas.
 * Permite al usuario agregar nuevas temáticas, eliminar todas las temáticas y visualizar las temáticas existentes.
 */
class Objetivos : AppCompatActivity() {

    private lateinit var btnAgregar: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerViewAdapterObjetivos
    private lateinit var btnEliminarTodo: FloatingActionButton

    private var listaNombres: ArrayList<Any> = ArrayList()
    private var listaLugares: ArrayList<Any> = ArrayList()

    /**
     * Método de inicialización de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objetivos)

        btnAgregar = findViewById(R.id.btnAgregarTematica)
        recyclerView = findViewById(R.id.recyclerViewObjetivos)
        btnEliminarTodo = findViewById(R.id.btnVaciarRecyclerView)

        // Configuración del adaptador y del RecyclerView
        adapter = RecyclerViewAdapterObjetivos(this, listaNombres, listaLugares)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Listener para el botón de agregar temática
        btnAgregar.setOnClickListener {
            val intent = Intent(this, Nuevos_objetivos::class.java)
            startActivity(intent)
        }

        // Listener para el botón de eliminar todas las temáticas
        btnEliminarTodo.setOnClickListener {
            // Elimina todos los elementos de las listas
            listaNombres.clear()
            listaLugares.clear()
            // Notifica al adaptador que los datos han cambiado
            adapter.notifyDataSetChanged()

            // Elimina todas las temáticas de la base de datos local
            GlobalScope.launch(Dispatchers.IO) {
                val localDB = LocalDatabase.getInstance(this@Objetivos)
                localDB.tematicasDao().deleteAll()
            }
        }
    }

    /**
     * Método que se ejecuta cada vez que la actividad se reanuda.
     * Actualiza la lista de temáticas.
     */
    override fun onResume() {
        super.onResume()
        displayData()
    }

    /**
     * Método para mostrar los datos de las temáticas en la lista.
     * Utiliza un hilo de fondo para acceder a la base de datos local y luego actualiza la interfaz de usuario en el hilo principal.
     */
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

                    // Agregar los datos de las temáticas a las listas
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
