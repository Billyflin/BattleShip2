package com.spm.battleship.conf

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Init_data : Application() {
    companion object{
        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs= Prefs(this)
    }
}