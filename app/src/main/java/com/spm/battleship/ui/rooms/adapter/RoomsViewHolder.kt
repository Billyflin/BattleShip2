package com.spm.battleship.ui.rooms.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.spm.battleship.R
import com.spm.battleship.ui.rooms.Salas

class RoomsViewHolder(view:View):RecyclerView.ViewHolder(view) {

    val ip = view.findViewById<TextView>(R.id.tvRooms)
    val nombreUsuario = view.findViewById<TextView>(R.id.tvNombreUsuario)
    val photo = view.findViewById<ImageView>(R.id.ivRooms)

    fun render(salasModel: Salas){
        ip.text=salasModel.ip
        nombreUsuario.text=salasModel.nombreUsuario
//        Glide.with(photo.context).load(salasModel.photo).into(photo)
    }
}