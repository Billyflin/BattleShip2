package com.spm.battleship.ui.menu

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import androidx.appcompat.app.AppCompatActivity
import com.spm.battleship.R
import com.spm.battleship.conections.Client2
import com.spm.battleship.conections.ClientClass
import com.spm.battleship.conf.Init_data.Companion.prefs
import com.spm.battleship.ui.login.LoginActivity
import com.spm.battleship.ui.rooms.RoomsActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var conection :Client2
        const val ME_PLAYER = "ME_PLAYER"
        const val ROOM_NAME = "ROOM_NAME"
        const val ROLE_NAME = "ROLE_NAME"
        const val VS_PLAYER = "VS_PLAYER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO){
                conection=Client2()
                conection.run()
            }
        }
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