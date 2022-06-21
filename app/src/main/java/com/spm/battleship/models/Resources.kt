package com.spm.battleship.models

import com.spm.battleship.ui.rooms.Salas

class Resources(){
    companion object{
        val ListSalas= mutableListOf<Salas>()
        val HistorialDeMensaje= mutableListOf<Mensaje>()
    }
    fun addSala(ip:String,nombreUsuario:String){
        ListSalas.add(Salas(ip,nombreUsuario))
    }
}
