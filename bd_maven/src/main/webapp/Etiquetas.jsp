<html>

<head>
    <meta charset="UTF-8">
    <title>Conceptos</title>

    <style>
        body {
            font-family: "JetBrains Mono", "JetBrains Mono";
            background: lightblue;
        }

        h2 {
            color: red;
            text-align: center;

        }

        h1 {
            color: red;
            text-align: center;
        }

        li {
            font-size: 16px;
            line-height: 1.5;
            list-style-type: square;
        }

        div {
            display: flex;
            justify-content: space-around;
            background-color: cadetblue;
            padding: 0;
        }

        aside {
            float: left;
            width: 25%;
            height: 1700px;


        }
    </style>
</head>

<body>
<div id="toph1">
    <h1 id="Top"><strong>Diseno de aplicaciones WEB</strong></h1>
</div>
<aside>
    <h2>INDICE</h2>
    <li><a href="#Nuevos">Ir a Elementos Nuevos</a></li>
    <li><a href="#Obsoletos">Ir a Elementos Obsoletos</a></li>
    <li><a href="#Ref">Ir a Referencias</a></li>
</aside>
<hr>
<h2 id="Nuevos">Elementos nuevos en HTML5:</h2>
<ul>
    <hr>
    <li><strong>article:</strong> Define contenido independiente o autonomo dentro de un documento HTML.</li>
    <li><strong>aside:</strong> Indica contenido relacionado pero separado del contenido principal, como notas al margen
        o informacion adicional.
    </li>
    <li><strong>audio:</strong> Permite la incorporacion de sonidos y musica en una pagina web.</li>
    <li><strong>bdi:</strong> Aisla un fragmento de texto que podria formatearse en una direccion diferente al texto
        circundante sin afectar su disposicion.
    </li>
    <li><strong>canvas:</strong> Proporciona un espacio para graficos renderizados por scripts, como dibujos o juegos.
    </li>
    <li><strong>command:</strong> Un elemento obsoleto que se utilizaba para definir un comando que el usuario podria
        invocar.
    </li>
    <li><strong>datalist:</strong> Contiene un conjunto de opciones predefinidas para otros controles, como campos de
        entrada.
    </li>
    <li><strong>details:</strong> Crea un widget interactivo que el usuario puede abrir y cerrar para mostrar u ocultar
        informacion adicional.
    </li>
    <li><strong>embed:</strong> Incorpora recursos externos, como aplicaciones o contenido interactivo multimedia.</li>
    <li><strong>figcaption:</strong> Representa una leyenda asociada con el contenido de su elemento padre figure.</li>
    <li><strong>figure:</strong> Se utiliza para representar contenido autocontenido, frecuentemente con una leyenda
        (figcaption).
    </li>
    <li><strong>footer:</strong> Define el pie de pagina para un documento o seccion.</li>
    <li><strong>header:</strong> Representa el grupo introductorio de ayuda contextual a la navegacion o herramientas
        introductorias.
    </li>
    <li><strong>hgroup:</strong> Solia agrupar varios elementos de encabezado (h1, h2, etc.). Sin embargo, en HTML5, se
        recomienda usar solo los elementos de encabezado individuales.
    </li>
    <li><strong>keygen:</strong> Anteriormente, se usaba para generar pares de claves publicas y privadas para
        formularios. En HTML5, este elemento esta obsoleto y se recomienda usar JavaScript para manejar la generacion de
        claves.
    </li>
    <li><strong>mark:</strong> Se utilizaba para resaltar texto. En HTML5, se prefiere usar CSS para aplicar estilos de
        resaltado.
    </li>
    <li><strong>meter:</strong> Representa una medida escalar dentro de un rango conocido.</li>
    <li><strong>nav:</strong> Define una seccion de navegacion dentro de un documento o una seccion de navegacion
        principal en una pagina.
    </li>
    <li><strong>output:</strong> Solia representar el resultado de un calculo o una operacion.</li>
    <li><strong>progress:</strong> Representa el progreso de una tarea.</li>
    <li><strong>rp:</strong> Se utilizaba para proporcionar una representacion alternativa de texto en ruby (usado en
        anotaciones de texto en idiomas asiaticos).
    </li>
    <li><strong>rt:</strong> Representa la anotacion de texto en ruby (usado en idiomas asiaticos).</li>
    <li><strong>ruby:</strong> Solia agrupar el texto base y las anotaciones de ruby.</li>
    <li><strong>section:</strong> Define una seccion logica o tematica dentro de un documento.</li>
    <li><strong>source:</strong> Se usaba para especificar recursos multimedia, como imagenes, videos o audio.</li>
    <li><strong>summary:</strong> Representa un resumen o leyenda para el contenido de su elemento padre details.</li>
    <li><strong>time:</strong> Solia representar una fecha o hora.</li>
    <li><strong>track:</strong> Antes se usaba para agregar pistas de texto a elementos multimedia.</li>
    <li><strong>video:</strong> Se utilizaba para incrustar videos en una pagina web.</li>
    <li><strong>wbr:</strong> Representa un posible punto de quiebre dentro de una palabra.</li>
</ul>
<hr>
<h2 id="Obsoletos">Elementos ahora obsoletos:</h2>
<hr>
<ul>
    <li><strong>acronym:</strong> Este elemento se utilizaba para definir una abreviatura o acronimo en el texto.</li>
    <li><strong>applet:</strong> En HTML4, se usaba para incrustar applets de Java en una pagina web.</li>
    <li><strong>basefont:</strong> Solia establecer las propiedades de fuente base para todo el documento.</li>
    <li><strong>big:</strong> Anteriormente, se usaba para aumentar el tama�o del texto.</li>
    <li><strong>center:</strong> Este elemento se utilizaba para centrar el contenido en la pagina.</li>
    <li><strong>dir:</strong> Solia crear listas de directorios.</li>
    <li><strong>font:</strong> Se utilizaba para definir propiedades de fuente como tama�o, color y tipo.</li>
    <li><strong>frame:</strong> Antes se usaba para dividir una pagina en marcos.</li>
    <li><strong>frameset:</strong> Solia definir la estructura de marcos en una pagina.</li>
    <li><strong>isindex:</strong> Se utilizaba para crear un campo de busqueda en una pagina.</li>
    <li><strong>noframes:</strong> Anteriormente, se usaba para proporcionar contenido alternativo para navegadores que
        no admitian marcos.
    </li>
    <li><strong>strike:</strong> Solia aplicar una linea horizontal a traves del texto.</li>
    <li><strong>tt:</strong> Se utilizaba para representar texto en una fuente de teletipo (monoespaciada).</li>
</ul>
<hr>
<h2 id="Ref">Referencias</h2>
<hr>
<li><a href="https://www.freecodecamp.org/espanol/news/elementos-semanticos-html5-explicados/">https://www.freecodecamp.org/espanol/news/elementos-semanticos-html5-explicados/</a>
</li>
<li><a href="https://www.mclibre.org/consultar/htmlcss/html/html-obsoletos.html">https://www.mclibre.org/consultar/htmlcss/html/html-obsoletos.html</a>
</li>

<br>
<li><a href="#Top">Volver al inicio</a></li>

</body>
</html>
