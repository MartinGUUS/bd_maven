
package Modelo;

import java.io.Serializable;
import java.sql.Date;

public class Eventos implements Serializable {

    private int idEvento;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private int fk_lugar;

    public Eventos() {
    }

    public Eventos(int idEvento, String nombre, String descripcion, Date fecha, int fk_lugar) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.fk_lugar = fk_lugar;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getFk_lugar() {
        return fk_lugar;
    }

    public void setFk_lugar(int fk_lugar) {
        this.fk_lugar = fk_lugar;
    }
}
