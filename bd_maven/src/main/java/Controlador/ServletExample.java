package Controlador;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletExample extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head><title>ESTO ES HORRIBLE</title></head>\n" +
                "<body>\n" +
                "<h1>HORRIBLE, LES DIJE </h1>\n" +
                "</body></html>\n");

    }


}
