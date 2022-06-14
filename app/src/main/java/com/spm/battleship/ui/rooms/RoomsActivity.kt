package com.spm.battleship.ui.rooms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.spm.battleship.R
import com.spm.battleship.conf.Init_data.Companion.prefs
import kotlinx.android.synthetic.main.activity_rooms.*

class RoomsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rooms)
    }
}