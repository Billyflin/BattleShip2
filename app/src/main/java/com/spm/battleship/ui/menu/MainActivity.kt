package com.spm.battleship.ui.menu

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.spm.battleship.R
import com.spm.battleship.conf.Init_data.Companion.prefs
import com.spm.battleship.databinding.ActivityMainBinding
import com.spm.battleship.models.Resources
import com.spm.battleship.ui.login.LoginActivity
import com.spm.battleship.ui.rooms.RoomsActivity
import com.spm.battleship.ui.rooms.Salas

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        accessToDetail()

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