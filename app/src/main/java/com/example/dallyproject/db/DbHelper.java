package com.example.dallyproject.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.dallyproject.Sqlite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DbHelper extends SQLiteOpenHelper {


    private static  final  int DATABASE_VERSION = 1;
    private static  final  String DATABASE_NOMBRE = "TESTINICIO.db";
    public static  final  String TABLE_CONTACTOS = "t_inicioDeSesion";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //crear la base de datos esto es una prueba
        db.execSQL("CREATE TABLE "+ TABLE_CONTACTOS+ "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL, " +
                "contrasenia TEXT NOT NULL," +
                "telefono int NOT NULL," +
                "correo_electronico TEXT)");
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
        contentValues.put("contrasenia", "123");
        contentValues.put("telefono", "123456789");
        contentValues.put("correo_electronico", "juan@example.com");
        db.insert(TABLE_CONTACTOS, null, contentValues);



        System.out.println("SEGUNDO INSERT");
        contentValues.put("nombre", "Maria");
        contentValues.put("contrasenia", "123");
        contentValues.put("telefono", "987654321");
        contentValues.put("correo_electronico", "maria@example.com");
        db.insert(TABLE_CONTACTOS, null, contentValues);
        db.close();

    }


    public Boolean crearUsuario(String nombre,String contrasenia,int numTelefono ,String correoElectronico){

        if (!buscarUsuario(nombre,contrasenia)){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues(); //es como el PreparedStatement
            contentValues.put("nombre", nombre);//se crea el objeto separado esto hay que cambiarlo par que meta objetos en la base de datos
            contentValues.put("contrasenia", contrasenia);
            contentValues.put("telefono", numTelefono);
            contentValues.put("correo_electronico", correoElectronico);
            db.insert(TABLE_CONTACTOS, null, contentValues);
            db.close();
            return true;
        }else {
            System.out.println("usuario "+ nombre +" no fue creado");
            return false;
        }

    }




    public boolean buscarUsuario(String nombre, String contrasenia) {
        SQLiteDatabase db = this.getReadableDatabase();

        // Columnas que deseas recuperar de la tabla
        String[] columns = {"id"};

        // Clausula WHERE para filtrar por nombre y contraseña
        String selection = "nombre = ? AND contrasenia = ?";

        // Valores para sustituir en la cláusula WHERE
        String[] selectionArgs = {nombre, contrasenia};

        // Ejecutar la consulta
        Cursor cursor = db.query(TABLE_CONTACTOS, columns, selection, selectionArgs, null, null, null);// es diferente nombre tabla columns que queremos coger, seleccion de datos (condicion) sino null, el resto ya lo pone el id

        // Verificar si la consulta devolvió algún resultado
        boolean existeUsuario = cursor.getCount() > 0;

        // Cerrar el cursor y la base de datos
        cursor.close();
        db.close();

        // Devolver true si el usuario existe, false en caso contrario
        return existeUsuario;
    }


    /*

    //todo esta funcion no se si funcioan correctamente esta funcion tiene que buscar a un usuario sera como autentificar pero no estoy seguro (comprobar)


    public List<Usuario> buscarUsuario(String nombre, String contrasenia) {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Usuario> contactos = new ArrayList<>();
        Cursor cursor = db.query(TABLE_CONTACTOS, new String[] { "id", "nombre", "contrasenia", "telefono", "correo_electronico" }, "nombre=? AND contrasenia=?", new String[] { nombre, contrasenia }, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Usuario contacto = new Usuario();
                contacto.setId(cursor.getInt(0));
                contacto.setNombre(cursor.getString(1));
                contacto.setContrasenia(cursor.getString(2));
                contacto.setTelefono(cursor.getInt(3));
                contacto.setCorreo(cursor.getString(4));
                contactos.add(contacto);
            } while (cursor.moveToNext());
        }
        return contactos;
    }

*/

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
/* todo : comrprobar que ocurre y como saber quien esta en la sql



    public List<Usuario> getAllUsers() {
        List<Usuario> userList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_CONTACTOS;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Usuario usuario = new Usuario();
                usuario.setId(cursor.getInt(0));
                usuario.setNombre(cursor.getString(1));
                usuario.setContrasenia(cursor.getString(2));
                usuario.setTelefono(cursor.getInt(3));
                usuario.setCorreo(cursor.getString(4));
                userList.add(usuario);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return userList;
    }
    public static void main(String[] args) {
        DbHelper dbHelper = new DbHelper(null);
        List<Usuario> users = dbHelper.getAllUsers();

        for (Usuario user : users) {
            System.out.println("ID: " + user.getId());
            System.out.println("Nombre: " + user.getNombre());
            System.out.println("Contraseña: " + user.getContrasenia());
            System.out.println("Teléfono: " + user.getTelefono());
            System.out.println("Correo electrónico: " + user.getCorreo());
            System.out.println("---------------------------------------");
        }
    }*/
}
