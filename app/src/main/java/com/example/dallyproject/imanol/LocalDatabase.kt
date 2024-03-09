package com.example.dallyproject.imanol

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TematicaEntity::class, SignUpEntity::class], version = 1)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun tematicasDao(): TematicasDAO
    abstract fun signUpDao(): SignUpDAO

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