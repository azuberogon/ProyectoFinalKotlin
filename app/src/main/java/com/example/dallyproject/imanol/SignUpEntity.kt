package com.example.dallyproject.imanol

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Clase de entidad que representa un usuario registrado en la aplicación.
 * Esta clase se utiliza para definir la estructura de la tabla en la base de datos local.
 */
@Entity
data class SignUpEntity(
    @PrimaryKey @ColumnInfo(name = "USUARIO") val usuario: String,
    @ColumnInfo(name = "EMAIL") val email: String,
    @ColumnInfo(name = "CONTRASENA") val contrasena: String,
    @ColumnInfo(name = "CONTRASENA_REPETIDA") val contrasenaRepetida: String
)
