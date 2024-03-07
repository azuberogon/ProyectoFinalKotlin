package com.example.dallyproject.imanol

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tematicas_objetivos")
data class TematicaObjetivo(@PrimaryKey val nombre: String)