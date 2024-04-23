package Datos;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws Exception, SQLException {

        MetodosDAO meto = new MetodosDAO();
        meto.listarEventosMain();
        

    }

}
