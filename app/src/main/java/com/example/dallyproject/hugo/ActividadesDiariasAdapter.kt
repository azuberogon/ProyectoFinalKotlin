package com.example.dallyproject.hugo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dallyproject.R

class ActividadesDiariasAdapter(private val items: List<Item>) : RecyclerView.Adapter<ActividadesDiariasAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_dia, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]

        holder.textView.text = currentItem.text
        holder.checkBox.isChecked = currentItem.isChecked

        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            currentItem.isChecked = isChecked
        }
    }

    override fun getItemCount() = items.size

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text_view)
        val checkBox: CheckBox = itemView.findViewById(R.id.check_box)
    }
}

data class Item(val text: String, var isChecked: Boolean)
