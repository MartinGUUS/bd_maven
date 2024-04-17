
package Modelo;

import java.io.Serializable;

public class Personajes implements Serializable{
    
    private int idPersonaje;
    private String nombre;
    private int fk_raza;
    private int fk_lugar;
    private String descripcion;

    public Personajes() {
    }

    public Personajes( String nombre, int fk_raza, int fk_lugar, String descripcion) {
        this.nombre = nombre;
        this.fk_raza = fk_raza;
        this.fk_lugar = fk_lugar;
        this.descripcion = descripcion;
    }

    public Personajes(int idPersonaje, String nombre, int fk_raza, int fk_lugar, String descripcion) {
        this.idPersonaje = idPersonaje;
        this.nombre = nombre;
        this.fk_raza = fk_raza;
        this.fk_lugar = fk_lugar;
        this.descripcion = descripcion;
    }

    public int getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFk_raza() {
        return fk_raza;
    }

    public void setFk_raza(int fk_raza) {
        this.fk_raza = fk_raza;
    }

    public int getFk_lugar() {
        return fk_lugar;
    }

    public void setFk_lugar(int fk_lugar) {
        this.fk_lugar = fk_lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    
}
