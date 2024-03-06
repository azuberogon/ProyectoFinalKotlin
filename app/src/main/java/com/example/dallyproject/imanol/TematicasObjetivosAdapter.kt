package com.example.dallyproject.imanol

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dallyproject.R

class TematicasObjetivosAdapter(private val tematicas: List<TematicaObjetivos>) : RecyclerView.Adapter<TematicasObjetivosAdapter.TematicaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TematicaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tematica_objetivos, parent, false)
        return TematicaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TematicaViewHolder, position: Int) {
        val tematica = tematicas[position]
        holder.bind(tematica)
    }

    override fun getItemCount(): Int = tematicas.size

    inner class TematicaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewNombre = itemView.findViewById<TextView>(R.id.textViewNombre)
        private val progressBar = itemView.findViewById<ProgressBar>(R.id.progressBar)
        fun bind(tematica: TematicaObjetivos) {
            textViewNombre.text = tematica.nombre
            progressBar.progress = tematica.progreso
        }
    }
}