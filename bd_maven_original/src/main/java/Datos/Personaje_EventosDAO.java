package Datos;
import Modelo.Personaje_Eventos;
import Modelo.Razas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Personaje_EventosDAO {


    private static final String selectPrincipal = "SELECT * FROM personajes_eventos";


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


}
