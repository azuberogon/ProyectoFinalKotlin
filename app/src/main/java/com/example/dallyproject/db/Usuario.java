package com.example.dallyproject.db;

/*
 * se aplica un modelo como el de javi pero no esta bien esto es una prueba se le creara una estructura de datos acorde en el proximo commit
 * se crea aqui el objeto DTO de Usuario pero faltan los daos para poder hacer bien la aplicacion
 * se debe tambien establecer un usuario statico para el inicio de sesion que ayudara a que la app siempre sepa que usaurio inicio la sesion
 * clase con setters y getters
 * */
class Usuario{



    private int id;
    private String nombre;
    private String contrasenia;
    private int telefono;
    private String correo;

    public Usuario(int id, String nombre, String contrasenia, int telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.correo = correo;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
