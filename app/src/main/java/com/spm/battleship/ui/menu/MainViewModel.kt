package com.spm.battleship.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.spm.battleship.conf.Init_data.Companion.prefs
import androidx.lifecycle.ViewModel
import com.spm.battleship.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.io.OutputStream
import java.net.Socket
import java.nio.charset.Charset
import java.util.*


@OptIn(DelicateCoroutinesApi::class)
class MainViewModel() : ViewModel() {
    private val scope: CoroutineScope = CoroutineScope(newSingleThreadContext("Conection"))
    private lateinit var client: Socket
    private lateinit var reader: Scanner
    private lateinit var writer: OutputStream
    private var _data = MutableLiveData<String>()
    val data: LiveData<String> get() = _data

    init {
        try {
            client = Socket("192.168.1.82", 9999)
            reader = Scanner(client.getInputStream())
            writer = client.getOutputStream()
//            button2.setOnClickListener{
//                val text=binding.editTextTextPersonName.text.toString()
//                write(text)
//            }
            firstData()
            getSalas()
            conect()
        } catch (e: Exception) {
            e.printStackTrace()


        }
    }

    private fun getSalas() {
        write("Sala")
    }

    private fun firstData() {
        write("addSala ${prefs.getUsername()}")
    }

    private fun write(message: String) {
        writer.write((message + '\n').toByteArray(Charset.defaultCharset()))
    }

    private fun conect() {
        scope.launch {
            while (true) {
                val i=reader.nextLine()
                println(i)
                if (i != null) {
                    MainScope().launch {
                        _data.value = i
                        conect()
                    }
                }
            }
        }
    }
}