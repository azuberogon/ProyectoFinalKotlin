package com.example.dallyproject.imanol

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.google.firebase.firestore.auth.User

@Dao
interface TematicasDAO {
    @Query("SELECT * FROM tematicaentity")
    fun getAll(): List<TematicaEntity>

    @Query("SELECT * FROM tematicaentity WHERE nombre IN (:userNames)")
    fun loadAllByNames(userNames: Array<String>): List<TematicaEntity>

    @Query("SELECT * FROM tematicaentity WHERE nombre LIKE :first AND " +
            "lugar LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    @Insert
    fun insertAll(vararg users: TematicaEntity)

    @Delete
    fun delete(user: TematicaEntity)
}