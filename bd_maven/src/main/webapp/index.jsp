<!DOCTYPE html>
<html>
<head>
    <title>Menu</title>

    <style>
        .opciones {
                display: flex;
                justify-content: space-around;
                background-color: cadetblue;
                padding: 0;
        }

        .Title {
            display: flex;
            justify-content: space-around;
            background-color: cadetblue;
            padding: 0;
        }

        .opcion {
            text-decoration: none;
            color: gold;
            font-weight: bold;
            padding: 10px;
            border-radius: 5px; /* Agregar bordes redondeados */
            display: flex; /* Hacer que el enlace sea un contenedor flex */
            flex-direction: column; /* Colocar la imagen encima del texto */
            align-items: center; /* Centrar la imagen y el texto */
            background-size: cover; /* Ajustar el tama�o de la imagen al contenedor */
            background-position: center; /* Centrar la imagen */
        }

        .opcion:hover {
            background-color: #ddd;
        }

        .opciones a {
            margin-bottom: 5px;
            font-size: 18px;

        }

        body {
            font-family: Arial, Helvetica, sans-serif;
        }
    </style>
</head>
<body>

<div class="Title">
    <h1>Bienvenidos</h1>
</div>

<div class="opciones">
    <a href="Menu.jsp" class="opcion" style="background-image: url('imagen/OIG2.png');">
        Menu
    </a>
    <a href="Etiquetas.jsp" class="opcion" style="background-image: url('imagen/OIG3.png');">
        Etiquetas
    </a>
    <a href="test.jsp" class="opcion" style="background-image: url('imagen/OIG4.png');">
        TEST
    </a>
    <a href="test2.jsp" class="opcion" style="background-image: url('imagen/OIG5.png');">
        TEST 2
    </a>
</div>

<img src="Images/font.jpg" alt="" width="1350" height="545" />
</body>
</html>
