package com.example.dallyproject.imanol

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SignUpEntity(
    @PrimaryKey @ColumnInfo(name = "USUARIO") val usuario: String,
    @ColumnInfo(name = "EMAIL") val email: String,
    @ColumnInfo(name = "CONTRASENA") val contrasena: String,
    @ColumnInfo(name = "CONTRASENA_REPETIDA") val contrasena_repetida: String
)
