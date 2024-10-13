package com.kacozsoft.dua

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class DuaAdapter(
    private val duaList: List<Dua>,
    private val onItemClick: (Dua) -> Unit
) : RecyclerView.Adapter<DuaAdapter.DuaViewHolder>() {

    inner class DuaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.textViewTitle)
        // Diğer TextView tanımları
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DuaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dua, parent, false)
        return DuaViewHolder(view)
    }

    override fun onBindViewHolder(holder: DuaViewHolder, position: Int) {
        val dua = duaList[position]
        holder.titleTextView.text = dua.title
        // Diğer TextView'leri doldurma
        holder.itemView.setOnClickListener {
            onItemClick(dua)
        }
    }

    override fun getItemCount(): Int {
        return duaList.size
    }
}
