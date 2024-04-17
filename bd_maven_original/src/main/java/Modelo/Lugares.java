
package Modelo;

import java.io.Serializable;

public class Lugares implements Serializable{
    
    private int idLugar;
    private String nombre;
    private String descripcion;
    private String region;

    public Lugares() {
    }
    public Lugares(String nombre, String descripcion, String region) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.region = region;
    }

    public Lugares(int idLugar, String nombre, String descripcion, String region) {
        this.idLugar = idLugar;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.region = region;
    }

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    
    
    
}
