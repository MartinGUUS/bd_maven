<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>TEST 2</title>
    </head>

    <body>

        <h1>Suma</h1>
        <% int num1=7; int num2=2; int sum=num1 + num2;  %>

        <%out.println("hola");%>

            <p>La suma de <b>
                    <%= num1 %>
                </b> + <b>
                    <%= num2 %>
                </b> es igual a <b>
                    <%= sum %>
                </b></p>

    </body>

    </html>