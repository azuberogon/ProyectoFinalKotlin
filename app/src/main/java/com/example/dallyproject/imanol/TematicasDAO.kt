package com.example.dallyproject.imanol

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
 * Data Access Object (DAO) para la entidad TematicaEntity.
 * Proporciona métodos para acceder a la base de datos y realizar operaciones CRUD en la tabla TematicaEntity.
 */
@Dao
interface TematicasDAO {
    /**
     * Obtiene todos los registros de la tabla TematicaEntity.
     * @return Una lista de todos los registros de la tabla TematicaEntity.
     */
    @Query("SELECT * FROM tematicaentity")
    fun getAll(): List<TematicaEntity>

    /**
     * Carga todas las temáticas por nombres.
     * @param userNames Un arreglo de nombres de las temáticas a cargar.
     * @return Una lista de TematicaEntity correspondientes a los nombres especificados.
     */
    @Query("SELECT * FROM tematicaentity WHERE nombre IN (:userNames)")
    fun loadAllByNames(userNames: Array<String>): List<TematicaEntity>

    /**
     * Busca una temática por nombre y lugar.
     * @param first El nombre de la temática a buscar.
     * @param last El lugar de la temática a buscar.
     * @return La TematicaEntity correspondiente al nombre y lugar especificados, o null si no se encuentra.
     */
    @Query("SELECT * FROM tematicaentity WHERE nombre LIKE :first AND lugar LIKE :last LIMIT 1")
    fun findByNameandLugar(first: String, last: String): TematicaEntity

    /**
     * Inserta una lista de temáticas en la tabla TematicaEntity.
     * @param tematicas Un vararg de TematicaEntity a insertar en la tabla.
     * @return Un arreglo de Long que contiene los ID de las temáticas insertadas.
     */
    @Insert
    fun insertAll(vararg tematicas: TematicaEntity): LongArray

    /**
     * Elimina una temática de la tabla TematicaEntity.
     * @param tematica La TematicaEntity a eliminar de la tabla.
     */
    @Delete
    fun delete(tematica: TematicaEntity)

    /**
     * Elimina todos los registros de la tabla TematicaEntity.
     */
    @Query("DELETE FROM tematicaentity")
    fun deleteAll()
}
