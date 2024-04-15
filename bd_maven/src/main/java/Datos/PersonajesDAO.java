package Datos;

import Modelo.Personajes;
import Modelo.Razas;

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
            JOptionPane.showMessageDialog(null, "Exito al insertar Personas");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
    }

}
