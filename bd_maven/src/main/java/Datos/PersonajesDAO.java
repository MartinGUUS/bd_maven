package Datos;

import Modelo.Personajes;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonajesDAO {


    private static final String selectPrincipal = "SELECT * FROM personajes";
    private static final String insertPrincipal = "INSERT INTO personajes(fk_raza,descripcion,nombre,fk_lugar) VALUES(?,?,?,?)";
    private static final String updatePrincipal = "UPDATE personajes SET nombre=?,fk_raza=?,fk_lugar=?,descripcion=? WHERE idpersonaje=?";
    private static final String deletePrincipal = "DELETE FROM personajes WHERE idpersonaje=?";
    private static final String updatenombre = "UPDATE personajes SET nombre=? WHERE idpersonaje=?";
    private static final String updateraza = "UPDATE personajes SET fk_raza=? WHERE idpersonaje=?";
    private static final String updatelugar = "UPDATE personajes SET fk_lugar=? WHERE idpersonaje=?";
    private static final String updatedescripcion = "UPDATE personajes SET descripcion=? WHERE idpersonaje=?";


    public static List<Personajes> listarPersonajes() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Personajes per = null;
        List<Personajes> personajes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(selectPrincipal);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idPersonaje = rs.getInt("idpersonaje");
                int fkRaza = rs.getInt("fk_raza");
                int fkLugar = rs.getInt("fk_lugar");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                per = new Personajes(idPersonaje, nombre, fkRaza, fkLugar, descripcion);
                personajes.add(per);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return personajes;
    }


    public void insert(Personajes pe) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(insertPrincipal);
            ps.setInt(1, pe.getFk_raza());
            ps.setString(2, pe.getDescripcion());
            ps.setString(3, pe.getNombre());
            ps.setInt(4, pe.getFk_lugar());
            ps.execute();
            System.out.println("Agregado exitosamente");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }

    public void updateprin(Personajes pe) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(updatePrincipal);
            ps.setInt(2, pe.getFk_raza());
            ps.setString(4, pe.getDescripcion());
            ps.setString(1, pe.getNombre());
            ps.setInt(3, pe.getFk_lugar());
            ps.setInt(5, pe.getIdPersonaje());
            ps.execute();
            System.out.println("Exito al modificar");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }

    public void updatenombre(Personajes pe) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(updatenombre);
            ps.setString(1, pe.getNombre());
            ps.setInt(2, pe.getIdPersonaje());
            ps.execute();
            System.out.println("Exito al modificar el nombre");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }

    public void updateraza(Personajes pe) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(updateraza);
            ps.setInt(1, pe.getFk_raza());
            ps.setInt(2, pe.getIdPersonaje());
            ps.execute();
            System.out.println("Exito al modificar la raza");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }

    public void updatelugar(Personajes pe) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(updatelugar);
            ps.setInt(1, pe.getFk_lugar());
            ps.setInt(2, pe.getIdPersonaje());
            ps.execute();
            System.out.println("Exito al modificar el lugar");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }

    public void updatedescrip(Personajes pe) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(updatedescripcion);
            ps.setString(1, pe.getDescripcion());
            ps.setInt(2, pe.getIdPersonaje());
            ps.execute();
            System.out.println("Exito al modificar la descripcion");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }




    public void delete(Personajes pe) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(deletePrincipal);
            ps.setInt(1, pe.getIdPersonaje());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Exito al eliminar Personas");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }

}
