//package com.example.dallyproject
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import com.google.android.gms.maps.CameraUpdateFactory
//import com.google.android.gms.maps.GoogleMap
//import com.google.android.gms.maps.OnMapReadyCallback
//import com.google.android.gms.maps.SupportMapFragment
//import com.google.android.gms.maps.model.MarkerOptions
//import com.google.type.LatLng
//
//class Maps : AppCompatActivity(), OnMapReadyCallback {
//
//
//    private lateinit var map: GoogleMap
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        createMapFragment()
//    }
//    private fun createMarker() {
//        val favoritePlace = com.google.android.gms.maps.model.LatLng(28.044195, -16.5363842)
//        map.addMarker(MarkerOptions().position(favoritePlace).title("Mi playa favorita!"))
//        map.animateCamera(
//            CameraUpdateFactory.newLatLngZoom(favoritePlace, 18f),
//            4000,
//            null
//        )
//    }
//
//    private fun createMapFragment() {
//        val mapFragment = supportFragmentManager
//            .findFragmentById(R.id.fragmentMap) as SupportMapFragment
//        mapFragment.getMapAsync(this)
//    }
//
//    override fun onMapReady(p0: GoogleMap) {
//        map = p0
//    }
//
//
//
//}