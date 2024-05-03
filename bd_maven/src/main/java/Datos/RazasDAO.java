package Datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modelo.Razas;

import javax.swing.*;

public class RazasDAO {

    private static final String selectPrincipal = "SELECT * FROM razas";
    private static final String insertPrincipal = "INSERT INTO razas(nombre,descripcion) VALUES(?,?)";
    private static final String updatePrincipal = "UPDATE razas SET nombre =?, descripcion=? WHERE idraza=?";
    private static final String deletePrincipal = "DELETE FROM razas WHERE idraza=?";
    private static final String updateNombre = "UPDATE razas SET nombre =? WHERE idraza=?";
    private static final String updateDesrcripcion = "UPDATE razas SET descripcion=? WHERE idraza=?";


    public static List<Razas> listarRazas() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Razas ra = null;
        List<Razas> razas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(selectPrincipal);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idraza = rs.getInt("idraza");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                ra = new Razas(idraza, nombre, descripcion);
                razas.add(ra);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return razas;
    }


    public void insert(Razas ra) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(insertPrincipal);
            ps.setString(1, ra.getNombre());
            ps.setString(2, ra.getDescripcion());
            ps.execute();
            System.out.println("Agregado exitosamente");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }

    public void update(Razas ra) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(updatePrincipal);
            ps.setString(1, ra.getNombre());
            ps.setString(2, ra.getDescripcion());
            ps.setInt(3, ra.getIdRaza());
            ps.executeUpdate();
            System.out.println("Exito al actualizar");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }

    public void updateName(Razas ra) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(updateNombre);
            ps.setString(1, ra.getNombre());
            ps.setInt(2, ra.getIdRaza());
            ps.executeUpdate();

            System.out.println("Exito al actualizar nombre");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }

    public void updateDescription(Razas ra) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(updateDesrcripcion);
            ps.setString(1, ra.getDescripcion());
            ps.setInt(2, ra.getIdRaza());
            ps.executeUpdate();

            System.out.println("Exito al actualizar descripcion");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }


    public void delete(Razas ra) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(deletePrincipal);
            ps.setInt(1, ra.getIdRaza());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Exito al eliminar Razas");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }
}
