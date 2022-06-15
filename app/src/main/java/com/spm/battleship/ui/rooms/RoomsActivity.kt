package com.spm.battleship.ui.rooms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.spm.battleship.R
import com.spm.battleship.conf.Init_data.Companion.prefs
import com.spm.battleship.ui.rooms.adapter.RoomsAdapter
import kotlinx.android.synthetic.main.activity_rooms.*

class RoomsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rooms)
        initRecyclerView()
    }
    private fun initRecyclerView(){
        val recyclerView= findViewById<RecyclerView>(R.id.recyclerRooms)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter= RoomsAdapter(RoomsProvider.ListSalas)
    }
}