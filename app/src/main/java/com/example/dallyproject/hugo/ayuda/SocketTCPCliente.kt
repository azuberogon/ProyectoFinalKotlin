package com.example.dallyproject.hugo.ayuda

import java.io.IOException
import java.net.Socket

class SocketTCPCliente(private val serverIP: String, private val serverPort: Int) {
    private lateinit var socket: Socket

    @Throws(IOException::class)
    fun start() {
        println("Cliente: Estableciendo conexión...")
        socket = Socket(serverIP, serverPort).apply {
            soTimeout = 5000 // Tiempo de espera para lectura
        }
        println("Cliente: Conexión establecida...")
    }

    @Throws(IOException::class)
    fun sendMessage(message: String) {
        println("Cliente: enviando mensaje al servidor...")
        socket.getOutputStream().use { outputStream ->
            outputStream.write(message.toByteArray())
        }
        println("Cliente: mensaje enviado")
    }

    @Throws(IOException::class)
    fun stop() {
        println("Cliente: cerrando conexiones...")
        socket.close()
        println("Cliente: conexiones cerradas")
    }
}

