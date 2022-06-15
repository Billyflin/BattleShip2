package com.spm.battleship.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.spm.battleship.R
import com.spm.battleship.ui.menu.MainActivity.Companion.conection
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.nio.charset.Charset

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        button2.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO){

            }
        }
    }
}