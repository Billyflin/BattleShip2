package com.spm.battleship.conections

import android.os.Handler
import android.os.Looper
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.Socket
import java.nio.charset.Charset
import java.util.*
import java.util.concurrent.Executors
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext

class ClientClass : Thread() {

    var hostAddress: String = "35.170.245.217"
    lateinit var inputStream: InputStream
    lateinit var outputStream: OutputStream
    lateinit var socket: Socket

    fun write(byteArray: ByteArray){
        try {
            outputStream.write(byteArray)
        }catch (ex: IOException){
            ex.printStackTrace()
        }
    }

    override fun run() {
        try {
            socket = Socket()
            socket.connect(InetSocketAddress(hostAddress,9999),500)
            inputStream = socket.getInputStream()
            outputStream = socket.getOutputStream()
        }catch (ex: IOException){
            ex.printStackTrace()
        }
        val executor = Executors.newSingleThreadExecutor()
        var handler = Handler(Looper.getMainLooper())

        executor.execute(kotlinx.coroutines.Runnable {
            kotlin.run {
                val buffer =ByteArray(1024)
                var byte:Int
                while (true){
                    try{
                        byte = inputStream.read(buffer)
                        if(byte>0){
                            val finalBytes = byte
                            handler.post(Runnable{
                                kotlin.run {
                                    val tmpMeassage = String(buffer,0,finalBytes)

                                    Log.i("client class", tmpMeassage)
                                }
                            })
                        }
                    }catch (ex: IOException){
                        ex.printStackTrace()
                    }
                }
            }
        })
    }

}
class Client2{
    private val connection: Socket = Socket("192.168.1.89", 9999)
    private var connected: Boolean = true

    init {
        println("Connected to server on port 9999")
    }

    private val reader: Scanner = Scanner(connection.getInputStream())
    private val writer: OutputStream = connection.getOutputStream()

    fun sendData(output:String){
        write(output)
    }

    fun run() {
        thread { read() }
        while (connected) {
            val input = readLine() ?: ""
            if ("exit" in input) {
                connected = false
                reader.close()
                connection.close()
            } else {
                write(input)
            }
        }

    }

    private fun write(message: String) {
        writer.write((message + '\n').toByteArray(Charset.defaultCharset()))
    }

    private fun read(): String ? {
        while (connected)
           return reader.nextLine()
        return ""
    }
    suspend fun getData():String?{
        return withContext(Dispatchers.IO){
            read()
        }
    }
}
