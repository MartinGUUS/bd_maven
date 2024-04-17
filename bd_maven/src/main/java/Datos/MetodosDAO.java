package Datos;

import Modelo.*;

import javax.swing.*;
import java.util.List;

public class MetodosDAO {


    public void listarRazaMain() {
        List<Razas> razas = RazasDAO.listarRazas();
        System.out.println("\n\n\nRAZAS\nID\tNOMBRE\tDESCRIPCION");
        for (int i = 0; i < razas.size(); i++) {
            System.out.print(razas.get(i).getIdRaza() + "\t");
            System.out.print(razas.get(i).getNombre() + "\t");
            System.out.print(razas.get(i).getDescripcion() + "\t");
            System.out.println( );
        }
    }

    public void listarPersonajes_EventosMain() {
        List<Personaje_Eventos> p_e = Personaje_EventosDAO.listarPersonajes_Eventos();
        System.out.println("\n\n\nPERSONAJES_EVENTOS\nEVENTO\tPERSONAJE");
        for (int i = 0; i < p_e.size(); i++) {
            System.out.print(p_e.get(i).getFk_evento() + "\t");
            System.out.print(p_e.get(i).getFk_personaje() + "\t");
            System.out.println();

        }
    }

    public void listarEventosMain() {
        List<Eventos> eventos = EventosDAO.listarEventos();
        System.out.println("\n\n\nEVENTOS\nID\tNOMBRE\tDESCRIPCION\tFECHA\tLUGAR");
        for (int i = 0; i < eventos.size(); i++) {
            System.out.print(eventos.get(i).getIdEvento() + "\t");
            System.out.print(eventos.get(i).getNombre() + "\t");
            System.out.print(eventos.get(i).getDescripcion() + "\t");
            System.out.print(eventos.get(i).getFecha() + "\t");
            System.out.print(eventos.get(i).getFk_lugar() + "\t");
            System.out.println();
        }
    }

    public void listarPersonajesMain() {
        List<Personajes> personajes = PersonajesDAO.listarPersonajes();
        System.out.println("\n\n\nPERSONAJES\nID\tNOMBRE\tDESCRIPCION\tLUGAR\tRAZA");
        for (int i = 0; i < personajes.size(); i++) {
            System.out.print(personajes.get(i).getIdPersonaje() + "\t");
            System.out.print(personajes.get(i).getNombre() + "\t");
            System.out.print(personajes.get(i).getDescripcion() + "\t");
            System.out.print(personajes.get(i).getFk_lugar() + "\t");
            System.out.print(personajes.get(i).getFk_raza() + "\t");
            System.out.println();
        }
    }

    public void listarLugaresMain() {
        List<Lugares> lugares = LugaresDAO.listarLugares();
        System.out.println("\n\n\nlUGARES\nID\tNOMBRE\tDESCRIPCION\tREGION");
        for (int i = 0; i < lugares.size(); i++) {
            System.out.print(lugares.get(i).getIdLugar() + "\t");
            System.out.print(lugares.get(i).getNombre() + "\t");
            System.out.print(lugares.get(i).getDescripcion() + "\t");
            System.out.print(lugares.get(i).getRegion() + "\t");
            System.out.println();
        }
    }


    public void insertRazas() {
        String name = JOptionPane.showInputDialog("Da el nombre de la raza");
        String description = JOptionPane.showInputDialog("Escribe una descripcion de : " + name);
        Razas razas = new Razas(name, description);
        RazasDAO razasDAO = new RazasDAO();
        razasDAO.insert(razas);
    }

    public void insertLugares() {
        String name = JOptionPane.showInputDialog("Da el nombre del lugar");
        String region = JOptionPane.showInputDialog("Escribe el nombre de la region donde esta");
        String description = JOptionPane.showInputDialog("Escribe una descripcion de : " + name);
        Lugares lugares = new Lugares(name, description, region);
        LugaresDAO lugaresDAO = new LugaresDAO();
        lugaresDAO.insert(lugares);
    }

    public void insertPersonajes() {
        int raza = Integer.parseInt(JOptionPane.showInputDialog("Da me el id de su raza"));
        String description = JOptionPane.showInputDialog("Escribe una descripcion del personaje");
        String nombre = JOptionPane.showInputDialog("Escribe el nombre del personaje");
        int lugar = Integer.parseInt(JOptionPane.showInputDialog("Da me el id de su lugar de origen"));
        Personajes personajes = new Personajes(nombre, raza, lugar, description);
        PersonajesDAO personajesDAO = new PersonajesDAO();
        personajesDAO.insert(personajes);
    }

    public void insertEvento() {
        String nombre = JOptionPane.showInputDialog("Escribe el nombre del evento");
        String description = JOptionPane.showInputDialog("Escribe una descripcion del evento");

    }


}
