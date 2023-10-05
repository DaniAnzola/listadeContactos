package com.example.listadecontactos;

import android.net.Uri;

public class lista_Contactos {


    private String nombre;

    private String numTelf;

    private int foto;
    private Uri imagen;
private int flag;
    private String correo;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public lista_Contactos(String nombre, String numTelf, Uri imagen, String correo,int flag) {
        this.nombre = nombre;
        this.numTelf = numTelf;
        this.imagen = imagen;
        this.correo = correo;
        this.flag=flag;
    }

    public Uri getImagen() {
        return imagen;
    }

    public void setImagen(Uri imagen) {
        this.imagen = imagen;
    }

    public lista_Contactos(String nombre, String numTelf, int foto, String correo,int flag) {
        this.nombre = nombre;
        this.numTelf = numTelf;
        this.foto = foto;
        this.correo = correo;
        this.flag=flag;
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

