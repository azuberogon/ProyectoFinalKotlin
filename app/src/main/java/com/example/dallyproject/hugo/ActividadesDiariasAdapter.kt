package com.example.dallyproject.hugo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dallyproject.R

class ActividadesDiariasAdapter(private val items: List<String>) : RecyclerView.Adapter<ActividadesDiariasAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.txtActDia)
        val checkBox: CheckBox = view.findViewById(R.id.checkActDia)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_dia, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
        // Configura aquí el estado del checkbox si lo necesitas
    }

    override fun getItemCount() = items.size
}