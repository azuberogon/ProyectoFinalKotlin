package com.example.dallyproject.hugo.ayuda

import java.io.IOException
import java.net.ServerSocket
import kotlin.concurrent.thread

class SocketTCPServer(port: Int) {
    private val serverSocket = ServerSocket(port)

    init {
        thread {
            while (!serverSocket.isClosed) {
                try {
                    val clientSocket = serverSocket.accept()
                    println("Servidor: Conexión establecida")
                    handleClient(clientSocket)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun handleClient(clientSocket: java.net.Socket) {
        thread {
            try {
                clientSocket.getInputStream().use { inputStream ->
                    val message = inputStream.readBytes().toString(Charsets.UTF_8)
                    println("Servidor: Mensaje recibido - $message")
                    // Aquí se manejaría el mensaje
                }
            } finally {
                clientSocket.close()
            }
        }
    }

    fun stop() {
        serverSocket.close()
    }
}




