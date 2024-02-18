package com.example.dallyproject.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.dallyproject.Sqlite;

public class DbHelper extends SQLiteOpenHelper {


    private static  final  int DATABASE_VERSION = 1;
    private static  final  String DATABASE_NOMBRE = "agenda.db";
    public static  final  String TABLE_CONTACTOS = "t_contactos";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //crear la base de datos esto es una prueba
        db.execSQL("CREATE TABLE "+ TABLE_CONTACTOS+ "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "telefono TEXT NOT NULL," +
                "correo_electronico TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+ TABLE_CONTACTOS); // borra la table y luego la crea para actualizarla
        onCreate(db);
    }

    public void test(){
        System.out.println("TEST 1: IMPORTS");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", "Juan");
        contentValues.put("telefono", "123456789");
        contentValues.put("correo_electronico", "juan@example.com");
        db.insert(TABLE_CONTACTOS, null, contentValues);
        contentValues.put("nombre", "Maria");
        contentValues.put("telefono", "987654321");
        contentValues.put("correo_electronico", "maria@example.com");
        db.insert(TABLE_CONTACTOS, null, contentValues);
        db.close();

    }
}
