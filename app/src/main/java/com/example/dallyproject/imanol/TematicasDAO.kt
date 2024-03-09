package com.example.dallyproject.imanol

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TematicasDAO {
    @Query("SELECT * FROM tematicaentity")
    fun getAll(): List<TematicaEntity>

    @Query("SELECT * FROM tematicaentity WHERE nombre IN (:userNames)")
    fun loadAllByNames(userNames: Array<String>): List<TematicaEntity>

    @Query("SELECT * FROM tematicaentity WHERE nombre LIKE :first AND " +
            "lugar LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): TematicaEntity

    @Insert
    fun insertAll(vararg tematicas: TematicaEntity):LongArray

    @Delete
    fun delete(tematica: TematicaEntity)

    @Query("DELETE FROM tematicaentity")
    fun deleteAll()
}