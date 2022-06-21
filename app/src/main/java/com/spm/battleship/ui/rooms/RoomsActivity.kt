package com.spm.battleship.ui.rooms

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.spm.battleship.R
import com.spm.battleship.models.Resources
import com.spm.battleship.ui.rooms.adapter.RoomsAdapter

class RoomsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rooms)
        initRecyclerView()
    }
    private fun initRecyclerView(){
        val recyclerView= findViewById<RecyclerView>(R.id.recyclerRooms)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter= RoomsAdapter(Resources.ListSalas)
    }
}