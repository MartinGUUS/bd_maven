package Datos;

import Modelo.Eventos;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventosDAO {
    private static final String selectPrincipal = "SELECT * FROM eventos";
    private static final String insertPrincipal = "INSERT INTO eventos(descripcion,fk_lugar,nombre,fecha) VALUES(?,?,?,?)";
    private static final String updatePrincipal = "UPDATE eventos SET nombre=?,descripcion=?,fecha=?,fk_lugar=? WHERE idevento=?";
    private static final String deletePrincipal = "DELETE FROM eventos WHERE idevento=?";
    


    public static List<Eventos> listarEventos() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Eventos ev = null;
        List<Eventos> eventos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(selectPrincipal);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idevento = rs.getInt("idevento");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                Date fecha = rs.getDate("fecha");
                int lugar = rs.getInt("fk_lugar");

                ev = new Eventos(idevento, nombre, descripcion, fecha, lugar);
                eventos.add(ev);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return eventos;
    }


    public void insert(Eventos ev) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(insertPrincipal);
            ps.setString(1, ev.getDescripcion());
            ps.setInt(2, ev.getFk_lugar());
            ps.setString(3, ev.getNombre());
            ps.setDate(4, ev.getFecha());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Exito al insertar Evento");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }

    public void update(Eventos ev) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(updatePrincipal);
            ps.setString(2, ev.getDescripcion());
            ps.setInt(4, ev.getFk_lugar());
            ps.setInt(5, ev.getIdEvento());
            ps.setString(1, ev.getNombre());
            ps.setDate(3, ev.getFecha());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Exito al actualizar Evento");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }


    public void delete(Eventos ev) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(deletePrincipal);
            ps.setInt(1, ev.getIdEvento());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Exito al eliminar Evento");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }


}
