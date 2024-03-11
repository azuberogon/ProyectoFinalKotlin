package com.example.dallyproject.hugo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
@Dao
interface ActividadDAO {
    @Query("SELECT * FROM actividadentity")
    fun getAll(): List<ActividadEntity>
    @Query("SELECT * FROM actividadentity WHERE nombre = :nombreEntrada LIMIT 1")
    fun findByName(nombreEntrada: String): ActividadEntity?
    @Insert
    fun insert(entity: ActividadEntity):Long
    @Delete
    fun delete(entity: ActividadEntity)
    @Query("DELETE FROM actividadentity")
    fun deleteAll()
}