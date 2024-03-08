package com.example.dallyproject.imanol

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.google.firebase.firestore.auth.User

@Database(entities = [User::class], version = 1)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun tematicasDao(): TematicasDAO

    companion object {
        @Volatile
        private var INSTANCE: LocalDatabase? = null

        fun getInstance(context: Context): LocalDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LocalDatabase::class.java,
                    "Proyecto.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}