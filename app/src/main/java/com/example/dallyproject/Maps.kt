package com.example.dallyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions

/**
 * Actividad que muestra un mapa con una ubicación específica marcada con un marcador.
 */
class Maps : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    /**
     * Se llama cuando se crea la actividad. Configura el contenido de la actividad y crea el fragmento de mapa.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createMapFragment()
    }

    /**
     * Crea un marcador en la ubicación deseada y mueve la cámara del mapa a esa ubicación.
     */
    private fun createMarker() {
        val favoritePlace = com.google.android.gms.maps.model.LatLng(28.044195, -16.5363842)
        map.addMarker(MarkerOptions().position(favoritePlace).title("Mi playa favorita!"))
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(favoritePlace, 18f),
            4000,
            null
        )
    }

    /**
     * Crea el fragmento de mapa y lo inicializa para obtener el mapa cuando esté listo.
     */
    private fun createMapFragment() {
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Se llama cuando el mapa está listo para ser utilizado. Asigna el mapa al miembro de clase correspondiente.
     */
    override fun onMapReady(p0: GoogleMap) {
        map = p0
        createMarker()
    }
}
