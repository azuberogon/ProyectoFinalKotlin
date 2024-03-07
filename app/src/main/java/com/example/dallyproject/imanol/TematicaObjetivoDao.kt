package com.example.dallyproject.imanol

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TematicaObjetivoDao {
//
//    // The flow always holds/caches latest version of data. Notifies its observers when the
//    // data has changed.
//    @Query("SELECT * FROM tematicasObjetivos ORDER BY word ASC")
//    fun getAlphabetizedWords(): Flow<List<TematicaObjetivo>>
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insert(word: TematicaObjetivo)
//
//    @Query("DELETE FROM tematicasObjetivos")
//    suspend fun deleteAll()
//
//    @Query("DELETE FROM tematicasObjetivos WHERE nombre = :titulo")
//    suspend fun delete(titulo: String)

}