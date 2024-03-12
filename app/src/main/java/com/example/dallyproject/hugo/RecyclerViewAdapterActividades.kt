package com.example.dallyproject.hugo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dallyproject.R

/**
 * Adaptador para el RecyclerView que muestra las actividades del día.
 * Este adaptador se encarga de inflar el diseño de cada elemento de la lista y de vincular los datos
 * de las actividades con las vistas correspondientes.
 */
class RecyclerViewAdapterActividades(
    private val context: Context,
    private val nombresID: ArrayList<Any>,
    private val descripcionesID: ArrayList<Any>
) : RecyclerView.Adapter<RecyclerViewAdapterActividades.MyViewHolder>() {

    /**
     * Crea nuevas instancias de ViewHolder cuando se necesita.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_recycler_dia, parent, false)
        return MyViewHolder(v)
    }

    /**
     * Vincula los datos de las actividades con las vistas correspondientes en el ViewHolder.
     */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameId.text = nombresID[position].toString()
        holder.descripcionId.text = descripcionesID[position].toString()
    }

    /**
     * Retorna la cantidad de elementos en el conjunto de datos.
     */
    override fun getItemCount(): Int {
        return nombresID.size
    }

    /**
     * ViewHolder que representa cada elemento en el RecyclerView.
     * Contiene referencias a las vistas dentro del elemento de la lista.
     */
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameId: TextView
        var descripcionId: TextView

        init {
            nameId = itemView.findViewById(R.id.txtNombre)
            descripcionId = itemView.findViewById(R.id.txtDescripcion)
        }
    }
}
