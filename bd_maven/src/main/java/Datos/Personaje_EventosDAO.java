package Datos;

import Modelo.Personaje_Eventos;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Personaje_EventosDAO {


    private static final String selectPrincipal = "SELECT * FROM personajes_eventos";
    private static final String insertPrincipal = "INSERT INTO personajes_eventos(fk_personaje,fk_evento) VALUES(?,?);";
    private static final String updatePrincipal = "UPDATE personajes_eventos SET fk_personaje=? WHERE fk_personaje=? AND fk_evento=?";


    public static List<Personaje_Eventos> listarPersonajes_Eventos() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Personaje_Eventos p_e = null;
        List<Personaje_Eventos> personaje_Eventos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(selectPrincipal);
            rs = ps.executeQuery();
            while (rs.next()) {
                int fkpersonaje = rs.getInt("fk_personaje");
                int fkevento = rs.getInt("fk_evento");

                p_e = new Personaje_Eventos(fkpersonaje, fkevento);
                personaje_Eventos.add(p_e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return personaje_Eventos;
    }


    public void insert(Personaje_Eventos ra) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(insertPrincipal);
            ps.setInt(1, ra.getFk_personaje());
            ps.setInt(2, ra.getFk_evento());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Exito al insertar Personajes_Eventos");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }

    public void update(Personaje_Eventos ra) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(updatePrincipal);
            ps.setInt(1, ra.getFk_personaje());
            ps.setInt(2, ra.getFk_personaje());
            ps.setInt(3, ra.getFk_evento());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Exito al actualizar Personajes_Eventos");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }


}
