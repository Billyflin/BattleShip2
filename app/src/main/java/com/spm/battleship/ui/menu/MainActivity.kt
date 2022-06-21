package com.spm.battleship.ui.menu

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import androidx.appcompat.app.AppCompatActivity
import com.spm.battleship.R

import com.spm.battleship.conf.Init_data.Companion.prefs
import com.spm.battleship.databinding.ActivityMainBinding
import com.spm.battleship.models.Resources
import com.spm.battleship.ui.login.LoginActivity
import com.spm.battleship.ui.rooms.RoomsActivity
import com.spm.battleship.ui.rooms.Salas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        accessToDetail()
        viewModel.data.observeForever() { data ->
            val values = data.split('/')
            "SALA/1092381902 danko"
            when(values[0]){
                "SALA" -> agregarSala(values[1])
            }
        }
    }

    private fun agregarSala(values: String) {
        val info= values.split(' ')
        Resources.ListSalas.add(Salas(info[0],info[1]))
    }


    private val viewModel by lazy {
        MainViewModel(binding)

    }

    private fun accessToDetail(){
        if(prefs.getUsername().isEmpty()){
            launchLoginActivity()
        }else{
            launchRoomsActivity()
        }
    }
    private fun launchLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        this.startActivity(intent)
        finish()
    }
    private fun launchRoomsActivity() {
        val intent = Intent(this, RoomsActivity::class.java)
        this.startActivity(intent)
        finish()
    }
}