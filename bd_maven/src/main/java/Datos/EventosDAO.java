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
    private static final String updateNombre = "UPDATE eventos SET nombre=? WHERE idevento=?";
    private static final String updateDescripcion = "UPDATE eventos SET descripcion=? WHERE idevento=?";
    private static final String updateFecha = "UPDATE eventos SET fecha=? WHERE idevento=?";
    private static final String updateLugar = "UPDATE eventos SET fk_lugar=? WHERE idevento=?";


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
            System.out.println("Agregado exitosamente");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }

    public void updatenombre(Eventos ev) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(updateNombre);
            ps.setInt(2, ev.getIdEvento());
            ps.setString(1, ev.getNombre());
            ps.execute();
            System.out.println("Exito al actualizar el nombre");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }


    public void updatedescripcion(Eventos ev) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(updateDescripcion);
            ps.setInt(2, ev.getIdEvento());
            ps.setString(1, ev.getDescripcion());
            ps.execute();
            System.out.println("Exito al actualizar la descripcion");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }

    public void updatefecha(Eventos ev) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(updateFecha);
            ps.setDate(1, ev.getFecha());
            ps.setInt(2, ev.getIdEvento());
            ps.execute();
            System.out.println("Exito al actualizar la fecha");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }

    public void updatelugar(Eventos ev) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(updateLugar);
            ps.setInt(2, ev.getIdEvento());
            ps.setInt(1, ev.getFk_lugar());
            ps.execute();
            System.out.println("Exito al actualizar el lugar");
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
