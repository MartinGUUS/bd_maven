package Modelo;

import java.io.Serializable;

public class Razas implements Serializable {

    private int idRaza;
    private String nombre;
    private String descripcion;

    public Razas() {
    }

    public Razas(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Razas(int idRaza, String nombre) {
        this.idRaza = idRaza;
        this.nombre = nombre;
    }


    public Razas(int idRaza, String nombre, String descripcion) {
        this.idRaza = idRaza;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(int idRaza) {
        this.idRaza = idRaza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
