package com.example.dallyproject.imanol

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dallyproject.hugo.ActividadDAO
import com.example.dallyproject.hugo.ActividadEntity


@Database(entities = [TematicaEntity::class, SignUpEntity::class, ActividadEntity::class], version = 3, exportSchema = false)

abstract class LocalDatabase : RoomDatabase() {
    abstract fun tematicasDao(): TematicasDAO
    abstract fun signUpDao(): SignUpDAO
    abstract fun actividadDao(): ActividadDAO


    companion object {
        private const val DATABASE_NAME="Proyecto.db"
        @Volatile
        private var INSTANCE: LocalDatabase? = null

        fun getInstance(context: Context): LocalDatabase {
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(context.applicationContext, LocalDatabase::class.java, DATABASE_NAME).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}