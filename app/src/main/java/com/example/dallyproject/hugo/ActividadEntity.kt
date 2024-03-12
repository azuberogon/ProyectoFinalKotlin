package com.example.dallyproject.hugo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Clase que representa una entidad de actividad en la base de datos.
 *
 * Esta clase define la estructura de datos para una actividad dentro de la base de datos Room.
 * Cada instancia de ActividadEntity representa una entrada en la tabla de actividades.
 *
 * @property nombre El nombre de la actividad.
 * @property descripcion La descripción de la actividad.
 */
@Entity
data class ActividadEntity(
    @PrimaryKey @ColumnInfo(name = "NOMBRE") val nombre: String,
    @ColumnInfo(name = "DESCRIPCION") val descripcion: String
)