package com.spm.battleship.ui.rooms.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.spm.battleship.R
import com.spm.battleship.ui.rooms.Salas

class RoomsAdapter(private val ListSalas: List<Salas>) : RecyclerView.Adapter<RoomsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomsViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return RoomsViewHolder(layoutInflater.inflate(R.layout.item_rooms, parent, false))

    }

    override fun onBindViewHolder(holder: RoomsViewHolder, position: Int) {
        val item= ListSalas[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return ListSalas.size
    }
}