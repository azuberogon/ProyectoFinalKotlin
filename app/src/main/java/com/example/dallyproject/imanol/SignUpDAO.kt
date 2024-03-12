package com.example.dallyproject.imanol

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
 * Data Access Object (DAO) para la entidad SignUpEntity.
 * Proporciona métodos para acceder a la base de datos y realizar operaciones CRUD en la tabla SignUpEntity.
 */
@Dao
interface SignUpDAO {
    /**
     * Obtiene todos los registros de la tabla SignUpEntity.
     * @return Una lista de todos los registros de la tabla SignUpEntity.
     */
    @Query("SELECT * FROM signupentity")
    fun getAll(): List<SignUpEntity>

    /**
     * Busca un usuario por nombre de usuario.
     * @param username El nombre de usuario del usuario a buscar.
     * @return La SignUpEntity correspondiente al nombre de usuario especificado, o null si no se encuentra.
     */
    @Query("SELECT * FROM signupentity WHERE usuario = :username LIMIT 1")
    fun findByUsername(username: String): SignUpEntity?

    /**
     * Busca un usuario por nombre de usuario y contraseña.
     * @param username El nombre de usuario del usuario a buscar.
     * @param password La contraseña del usuario a buscar.
     * @return La SignUpEntity correspondiente al nombre de usuario y contraseña especificados, o null si no se encuentra.
     */
    @Query("SELECT * FROM signupentity WHERE usuario = :username AND contrasena = :password LIMIT 1")
    fun findByUsernameAndPassword(username: String, password: String): SignUpEntity?

    /**
     * Inserta un nuevo registro en la tabla SignUpEntity.
     * @param entity La SignUpEntity a insertar en la tabla.
     */
    @Insert
    fun insert(entity: SignUpEntity)

    /**
     * Elimina un registro de la tabla SignUpEntity.
     * @param entity La SignUpEntity a eliminar de la tabla.
     */
    @Delete
    fun delete(entity: SignUpEntity)

    /**
     * Elimina todos los registros de la tabla SignUpEntity.
     */
    @Query("DELETE FROM signupentity")
    fun deleteAll()
}
