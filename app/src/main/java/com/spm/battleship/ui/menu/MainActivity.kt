package com.spm.battleship.ui.menu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.spm.battleship.R
import com.spm.battleship.conf.Init_data.Companion.prefs
import com.spm.battleship.ui.login.LoginActivity
import com.spm.battleship.ui.rooms.RoomsActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_rooms.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val ME_PLAYER = "ME_PLAYER"
        const val ROOM_NAME = "ROOM_NAME"
        const val ROLE_NAME = "ROLE_NAME"
        const val VS_PLAYER = "VS_PLAYER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prefs.saveUserName("Hola")
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