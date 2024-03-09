package com.example.dallyproject.imanol;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
interface SignUpDAO {
    @Query("SELECT * FROM SignUpEntity")
    fun getAll(): List<SignUpEntity>
    @Query("SELECT * FROM signupentity WHERE usuario = :username LIMIT 1")
    fun findByUsername(username: String): SignUpEntity?
    @Insert
    fun insert(entity: SignUpEntity)
    @Delete
    fun delete(entity: SignUpEntity)
    @Query("DELETE FROM SignUpEntity")
    fun deleteAll()
}
