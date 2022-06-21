package com.spm.battleship.ui.rooms

class RoomsProvider {
    companion object{
        val ListSalas= mutableListOf(
            Salas(
                "PicoPalQueLee",
                "Danko",
                "http://"
            ),
            Salas(
                "EelEuqLapOcip",
                "Billy",
                "http://"
            ),
            Salas(
                "1v1 sin camisa",
                "Calfu",
                "http://"
            )

        )
    }
    fun addSala(ip:String,nombreUsuario:String){
        ListSalas.add(Salas(ip,nombreUsuario))
    }
}