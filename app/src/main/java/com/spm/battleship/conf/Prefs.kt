package com.spm.battleship.conf

import android.content.Context

class Prefs(private val context: Context) {
    private val SHARED = "Datos"
    internal val SHARED_USER_NAME = "username"
    private val SHARED_ID = "id"
    private val SHARED_HOST = "host"
    private val storage = context.getSharedPreferences(SHARED,0)

    fun saveUserName(name:String){
        storage.edit().putString(SHARED_USER_NAME,name).apply()
    }

    fun saveID(ID:String){
        storage.edit().putString(SHARED_ID,ID).apply()
    }

    fun saveHost(Host:Int){
        storage.edit().putInt(SHARED_HOST,Host).apply()

    }

    fun getID():String{
        return storage.getString(SHARED_ID,"")!!
    }

    fun getUsername():String{
        return storage.getString(SHARED_USER_NAME,"")!!
    }

    fun wipe(){
        storage.edit().clear().apply()
    }

    fun getHost(): Int {
        return storage.getInt(SHARED_HOST,0)
    }
}