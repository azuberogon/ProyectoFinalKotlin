package com.example.dallyproject.imanol;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
interface SignUpDAO {
    @Query("SELECT * FROM signupentity")
    fun getAll(): List<SignUpEntity>
    @Query("SELECT * FROM signupentity WHERE usuario = :username LIMIT 1")
    fun findByUsername(username: String): SignUpEntity?

    @Query("SELECT * FROM signupentity WHERE usuario = :username AND contrasena = :password LIMIT 1")
    fun findByUsernameAndPassword(username: String, password: String): SignUpEntity?

    @Insert
    fun insert(entity: SignUpEntity)
    @Delete
    fun delete(entity: SignUpEntity)
    @Query("DELETE FROM signupentity")
    fun deleteAll()
}
