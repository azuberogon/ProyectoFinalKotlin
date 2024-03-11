package com.example.dallyproject.imanol

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TematicaEntity(
    @PrimaryKey @ColumnInfo(name = "nombre") val nombre: String,
    @ColumnInfo(name = "lugar") val lugar: String
)