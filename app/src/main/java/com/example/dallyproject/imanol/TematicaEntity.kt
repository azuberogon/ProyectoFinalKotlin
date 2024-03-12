package com.example.dallyproject.imanol

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Clase de entidad que representa una temática o un objetivo en la aplicación.
 * Esta clase se utiliza para definir la estructura de la tabla en la base de datos local.
 */
@Entity
data class TematicaEntity(
    @PrimaryKey @ColumnInfo(name = "nombre") val nombre: String,
    @ColumnInfo(name = "lugar") val lugar: String
)
