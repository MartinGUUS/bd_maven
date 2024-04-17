package Datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modelo.Lugares;

import javax.swing.*;


public class LugaresDAO {

    private static final String selectPrincipal = "SELECT * FROM lugares";
    private static final String insertPrincipal = "INSERT INTO lugares(descripcion,nombre,region) VALUES(?,?,?)";
    private static final String updatePrincipal = "UPDATE lugares SET nombre=?,descripcion=?,region=? WHERE idlugar=?";
    private static final String deletePrincipal = "DELETE FROM lugares WHERE idLugar=?";

    public static List<Lugares> listarLugares() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Lugares lu = null;
        List<Lugares> lugares = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(selectPrincipal);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idLugar = rs.getInt("idlugar");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String region = rs.getString("region");
                lu = new Lugares(idLugar, nombre, descripcion, region);
                lugares.add(lu);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return lugares;
    }

    public void insert(Lugares lu) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(insertPrincipal);
            ps.setString(1, lu.getDescripcion());
            ps.setString(2, lu.getNombre());
            ps.setString(3, lu.getRegion());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Exito al insertar Lugares");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }

    public void update(Lugares lu) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(updatePrincipal);
            ps.setString(2, lu.getDescripcion());
            ps.setString(1, lu.getNombre());
            ps.setString(3, lu.getRegion());
            ps.setInt(4, lu.getIdLugar());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Exito al actualizar Lugares");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }

    public void delete(Lugares lu) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(deletePrincipal);
            ps.setInt(1, lu.getIdLugar());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Exito al eliminar Lugares");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }
}
