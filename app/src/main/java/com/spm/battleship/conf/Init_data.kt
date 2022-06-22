package com.spm.battleship.conf

import android.app.Application
import android.os.StrictMode
import android.widget.Toast
import com.spm.battleship.models.Resources
import com.spm.battleship.ui.menu.MainViewModel
import com.spm.battleship.ui.rooms.Salas

class Init_data : Application() {
    companion object {
        lateinit var prefs: Prefs
    }
        private val viewModel by lazy {
            MainViewModel()
        }


    override fun onCreate() {
        super.onCreate()
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        prefs= Prefs(this)
        viewModel.data.observeForever() { data ->
            val values = data.split(';')
            println(values)
//            "SALA/1092381902 danko"
            when(values[0]){
                "Sala" -> agregarSala(values[1])
            }
        }

    }
    private fun agregarSala(values: String) {
        val info= values.split(',')
        info.first().replace("[","")
        info.last().replace("]","")
        println(info)
        info.forEach {
            val cliente= it.split('@')
            var ip=cliente.first().replace("[/","")
            ip=ip.replace("[","")
            ip=ip.replace("/","")
            val usuario=cliente.last().replace("]","")
            Resources.ListSalas.add(Salas(ip,usuario))
        }
    }
}