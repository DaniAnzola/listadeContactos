package com.example.listadecontactos;

public class lista_Contactos {


    private String nombre;

    private String numTelf;

    private int foto;

    private String correo;

    public lista_Contactos(String nombre, String numTelf, int foto, String correo) {
        this.nombre = nombre;
        this.numTelf = numTelf;
        this.foto = foto;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumTelf() {
        return numTelf;
    }

    public void setNumTelf(String numTelf) {
        this.numTelf = numTelf;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public lista_Contactos() {

    }

}

