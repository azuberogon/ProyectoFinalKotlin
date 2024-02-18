package com.example.dallyproject.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
                "correo_electronico TEXT," +
                "contrasenia TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+ TABLE_CONTACTOS); // borra la table y luego la crea para actualizarla
        onCreate(db);
    }
    //todo apartir de aqui son las modificaciones de la base de datos

    public void test(){ //aqui hace los inserts (sin comprobar)
        System.out.println("TEST 1: INSERT ");
        System.out.println("PRIMER INSERT");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues(); //es como el PreparedStatement
        contentValues.put("nombre", "Juan");//se crea el objeto separado esto hay que cambiarlo par que meta objetos en la base de datos
        contentValues.put("telefono", "123456789");
        contentValues.put("correo_electronico", "juan@example.com");
        db.insert(TABLE_CONTACTOS, null, contentValues);
        System.out.println("SEGUNDO INSERT");
        contentValues.put("nombre", "Maria");
        contentValues.put("telefono", "987654321");
        contentValues.put("correo_electronico", "maria@example.com");
        db.insert(TABLE_CONTACTOS, null, contentValues);
        db.close();

    }


    //todo: lo que tenemos que hacer es primero un sistema local de loggeo para iniciar la sesion en la base de datos en local luego tiene que ir a una bsae dedatos onlinea

    public boolean autenticar(String nombreUser, String contrasenia) {//aqui hace las busquedas (sin comprobar)
        boolean exito = false;
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"nombre", "contrasenia"};
        String selection = "nombre=? AND contrasenia=?";
        String[] selectionArgs = {nombreUser, contrasenia};
        Cursor cursor = db.query(TABLE_CONTACTOS, columns, selection, selectionArgs, null, null, null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                exito = true;
            }
            cursor.close();
        }
        db.close();
        return exito;
    }
}
