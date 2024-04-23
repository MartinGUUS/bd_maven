package Datos;

import java.sql.SQLException;
import Modelo.Lugares;

public class Main {

    public static void main(String[] args) throws Exception, SQLException {

        MetodosDAO meto = new MetodosDAO();
        meto.listarEventosMain();
        Lugares lu=new Lugares(1,"asd","asda","fd");
        LugaresDAO luDao=new LugaresDAO();

        luDao.update(lu);



    }

}
