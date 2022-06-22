package com.spm.battleship.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.spm.battleship.R
import com.spm.battleship.conf.Init_data.Companion.prefs
import com.spm.battleship.ui.rooms.RoomsActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        button2.setOnClickListener {
            println(editTextTextPersonName2.text)
        if(!editTextTextPersonName2.text.isNullOrBlank()){
            prefs.saveUserName(editTextTextPersonName2.text.toString())
            val intent=Intent(this,RoomsActivity::class.java)
            this.startActivity(intent)
            finish()
            }
        }
    }
}
