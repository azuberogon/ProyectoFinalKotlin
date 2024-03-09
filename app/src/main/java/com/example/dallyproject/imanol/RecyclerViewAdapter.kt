package com.example.dallyproject.imanol

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dallyproject.R

class RecyclerViewAdapter(
    private val context: Context, // Pasar el contexto aquí
    private val nombresID: ArrayList<Any>,
    private val lugaresID: ArrayList<Any>
) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.tematica_entry, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameId.text = nombresID[position].toString()
        holder.lugarId.text = lugaresID[position].toString()
    }

    override fun getItemCount(): Int {
        return nombresID.size // Retorna la cantidad de elementos en tu conjunto de datos
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameId: TextView
        var lugarId: TextView
        init {
            nameId = itemView.findViewById(R.id.textViewNombre)
            lugarId = itemView.findViewById(R.id.textViewLugar)
        }
    }
}
