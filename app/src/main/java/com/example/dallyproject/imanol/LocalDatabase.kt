package com.example.dallyproject.imanol


import ActividadDAO
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dallyproject.hugo.ActividadDAO
import com.example.dallyproject.hugo.ActividadEntity

/**
 * Clase que representa la base de datos local de la aplicación.
 * Esta clase utiliza RoomDatabase para definir la base de datos y proporcionar acceso a los DAOs correspondientes.
 */
@Database(entities = [TematicaEntity::class, SignUpEntity::class, ActividadEntity::class], version = 3, exportSchema = false)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun tematicasDao(): TematicasDAO
    abstract fun signUpDao(): SignUpDAO
    abstract fun actividadDao(): ActividadDAO

    companion object {
        private const val DATABASE_NAME = "Proyecto.db"
        @Volatile
        private var INSTANCE: LocalDatabase? = null

        /**
         * Obtiene una instancia de la base de datos local.
         * Si la instancia no existe, crea una nueva utilizando Room.
         */
        fun getInstance(context: Context): LocalDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LocalDatabase::class.java,
                        DATABASE_NAME
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
