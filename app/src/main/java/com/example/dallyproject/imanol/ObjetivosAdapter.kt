package com.example.dallyproject.imanol

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ObjetivosAdapter : ListAdapter<Objetivo, ObjetivosAdapter.ObjetivoViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Objetivo>() {
        override fun areItemsTheSame(oldItem: Objetivo, newItem: Objetivo): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Objetivo, newItem: Objetivo): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjetivoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_objetivo, parent, false)
        return ObjetivoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ObjetivoViewHolder, position: Int) {
        val objetivo = getItem(position)
        holder.bind(objetivo)
    }

    class ObjetivoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewObjetivo: TextView = itemView.findViewById(R.id.textViewObjetivo)
        private val progressBar: ProgressBar = itemView.findViewById(R.id.progressBar)

        fun bind(objetivo: Objetivo) {
            textViewObjetivo.text = objetivo.nombre
            progressBar.progress = objetivo.progreso
        }
    }
}