package com.spm.battleship.ui.menu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.spm.battleship.R
import com.spm.battleship.conf.Init_data.Companion.prefs
import com.spm.battleship.ui.login.LoginActivity
import com.spm.battleship.ui.rooms.RoomsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        accessToDetail()
    }



    private fun accessToDetail(){
        if(prefs.getUsername().isBlank()){
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