
package Modelo;

import java.io.Serializable;

public class Personaje_Eventos implements Serializable{
    
    private int fk_personaje;
    private int fk_evento;

    public Personaje_Eventos() {
    }

    public Personaje_Eventos(int fk_personaje, int fk_evento) {
        this.fk_personaje = fk_personaje;
        this.fk_evento = fk_evento;
    }

    public int getFk_personaje() {
        return fk_personaje;
    }

    public void setFk_personaje(int fk_personaje) {
        this.fk_personaje = fk_personaje;
    }

    public int getFk_evento() {
        return fk_evento;
    }

    public void setFk_evento(int fk_evento) {
        this.fk_evento = fk_evento;
    }
    
    
    
}
