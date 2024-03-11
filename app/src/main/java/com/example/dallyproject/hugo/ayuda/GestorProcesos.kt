package com.example.dallyproject.hugo.ayuda

import java.io.IOException
import java.io.OutputStream
import java.net.Socket
import kotlin.random.Random
import kotlin.concurrent.thread

class GestorProcesos(private val socket: Socket) : Thread() {

    private lateinit var os: OutputStream

    override fun run() {
        try {
            realizarProceso()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Throws(IOException::class)
    private fun realizarProceso() {
        os = socket.getOutputStream()
        val generadorNumerosAleatorios = Random
        val tiempoEspera = generadorNumerosAleatorios.nextInt(60)
        try {
            Thread.sleep(tiempoEspera * 1000L)
            os.write(tiempoEspera)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } finally {
            os.close()
        }
    }
}
