package com.example.dallyproject.hugo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class ActividadEntity(
    @PrimaryKey @ColumnInfo(name = "NOMBRE") val nombre: String,
    @ColumnInfo(name = "DESCRIPCION") val descripcion: String,
)