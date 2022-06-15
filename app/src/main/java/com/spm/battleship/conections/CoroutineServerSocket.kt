package com.spm.battleship.conections

import io.ktor.network.selector.*
import io.ktor.network.sockets.*
import io.ktor.util.*
import io.ktor.utils.io.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@InternalAPI
class CoroutineServerSocket() {
   init {
    runBlocking {
        val selectorManager = SelectorManager(Dispatchers.IO)
        val serverSocket = aSocket(selectorManager).tcp().bind("192.168.1.89", 9999)
        println("Server is listening at ${serverSocket.localAddress}")
        while (true) {
            val socket = serverSocket.accept()
            println("Accepted $socket")
            launch {
                val receiveChannel = socket.openReadChannel()
                val sendChannel = socket.openWriteChannel(autoFlush = true)
                sendChannel.writeStringUtf8("Please enter your name\n")
                try {
                    while (true) {
                        val name = receiveChannel.readUTF8Line()
                        sendChannel.writeStringUtf8("Hello, $name!\n")
                        if (name.equals("A"))
                            sendChannel.writeStringUtf8(socket.remoteAddress.toString()+"\n")
                        if(name.equals("getRoom"))
                            sendChannel.writeStringUtf8("$mutableList\n")
                        if(name.equals("addRoom")){
                            mutableList.add(socket.remoteAddress.toString())

                        }
                    }
                } catch (e: Throwable) {
                    socket.close()
                }
            }
        }
    }
   }
}
