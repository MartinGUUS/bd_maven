package Datos;

import Modelo.*;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class MetodosDAO {


    public List<Razas> listarRazaMain() {
        List<Razas> razas = RazasDAO.listarRazas();
        System.out.println("\n\n\nRAZAS\nID\tNOMBRE\tDESCRIPCION");
        for (int i = 0; i < razas.size(); i++) {
            System.out.print(razas.get(i).getIdRaza() + "\t");
            System.out.print(razas.get(i).getNombre() + "\t");
            System.out.print(razas.get(i).getDescripcion() + "\t");
            System.out.println();
        }
        return razas;
    }

    public List<Personaje_Eventos> listarPersonajes_EventosMain() {
        List<Personaje_Eventos> p_e = Personaje_EventosDAO.listarPersonajes_Eventos();
        System.out.println("\n\n\nPERSONAJES_EVENTOS\nEVENTO\tPERSONAJE");
        for (int i = 0; i < p_e.size(); i++) {
            System.out.print(p_e.get(i).getFk_evento() + "\t");
            System.out.print(p_e.get(i).getFk_personaje() + "\t");
            System.out.println();
        }
        return p_e;
    }

    public List<Personaje_Eventos> listareventospersonajes() {
        List<Personaje_Eventos> p_e = Personaje_EventosDAO.listarPersonajes_Eventos();
        return p_e;
    }

    public List<Eventos> listarEventosMain() {
        List<Eventos> eventos = EventosDAO.listarEventos();
        System.out.println("\n\n\nEVENTOS\nID\tNOMBRE\tDESCRIPCION\tFECHA\tLUGAR");
        for (int i = 0; i < eventos.size(); i++) {
            System.out.print(eventos.get(i).getIdEvento() + "\t");
            System.out.print(eventos.get(i).getNombre() + "\t");
            System.out.print(eventos.get(i).getDescripcion() + "\t");
            System.out.print(eventos.get(i).getFecha() + "\t");
            System.out.print(eventos.get(i).getFk_lugar() + "\t");
            System.out.println();
        }
        return eventos;
    }

    public List<Personajes> listarPersonajesMain() {
        List<Personajes> personajes = PersonajesDAO.listarPersonajes();
        System.out.println("\n\n\nPERSONAJES\nID\tNOMBRE\tDESCRIPCION\tLUGAR\tRAZA");
        for (int i = 0; i < personajes.size(); i++) {
            System.out.print(personajes.get(i).getIdPersonaje() + "\t");
            System.out.print(personajes.get(i).getNombre() + "\t");
            System.out.print(personajes.get(i).getDescripcion() + "\t");
            System.out.print(personajes.get(i).getFk_lugar() + "\t");
            System.out.print(personajes.get(i).getFk_raza() + "\t");
            System.out.println();
        }
        return personajes;
    }

    public List<Lugares> listarLugaresMain() {
        List<Lugares> lugares = LugaresDAO.listarLugares();
        System.out.println("\n\n\nlUGARES\nID\tNOMBRE\tDESCRIPCION\tREGION");
        for (int i = 0; i < lugares.size(); i++) {
            System.out.print(lugares.get(i).getIdLugar() + "\t");
            System.out.print(lugares.get(i).getNombre() + "\t");
            System.out.print(lugares.get(i).getDescripcion() + "\t");
            System.out.print(lugares.get(i).getRegion() + "\t");
            System.out.println();
        }
        return lugares;
    }


    public void insertRazas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la raza:");
        String name = scanner.nextLine();
        System.out.println("Ingrese una descripción de l@s " + name);
        String description = scanner.nextLine();
        Razas razas = new Razas(name, description);
        RazasDAO razasDAO = new RazasDAO();
        razasDAO.insert(razas);

    }


    public void insertLugares() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del lugar");
        String name = scanner.nextLine();
        System.out.println("Ingrese el la region a la que pertenece " + name);
        String region = scanner.nextLine();
        System.out.println("Ingrese una descripcion de " + name);
        String description = scanner.nextLine();
        Lugares lugares = new Lugares(name, description, region);
        LugaresDAO lugaresDAO = new LugaresDAO();
        lugaresDAO.insert(lugares);
    }


    public void insertPersonajes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del personaje");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese una descripcion del personaje");
        String description = scanner.nextLine();
        int raza = 0;
        int lugar = 0;
        boolean razabool = false;
        boolean lugarbool = false;
        List<Razas> razas = null;
        List<Lugares> lugares = null;
        String error = "";

        try {
            razas = listarRazaMain();
            System.out.print("\nIngrese el id de su raza: ");
            raza = scanner.nextInt();
            lugares = listarLugaresMain();
            System.out.print("\nIngrese el id de su lugar de origen: ");
            lugar = scanner.nextInt();

            for (int i = 0; i < razas.size(); i++) {
                if (razas.get(i).getIdRaza() == raza) {
                    razabool = true;
                }
            }
            for (int i = 0; i < lugares.size(); i++) {
                if (lugares.get(i).getIdLugar() == lugar) {
                    lugarbool = true;
                }
            }
            if (!razabool) {
                error += "La raza no es ta en la lista\n";
            }
            if (!lugarbool) {
                error += "El lugar no es ta en la lista\n";
            }
        } catch (Exception e) {
            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }

        if (lugarbool && razabool) {
            Personajes personajes = new Personajes(nombre, raza, lugar, description);
            PersonajesDAO personajesDAO = new PersonajesDAO();
            personajesDAO.insert(personajes);
        } else {
            System.out.println("No se ha insertado\n" + error);

        }

    }

    public void insertEvento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del evento");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese una descripcion del evento");
        String description = scanner.nextLine();
        System.out.println("Ingrese la fecha del evento (en formato yyyy-mm-dd)");
        String fechaStr = scanner.nextLine();
        Date fecha = null;
        int lugar = 0;
        boolean lugarbool = false;
        List<Lugares> lugares = null;
        String error = "";

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fecha = new Date(sdf.parse(fechaStr).getTime());
            lugares = listarLugaresMain();
            System.out.print("\nIngrese el id del lugar del evento: ");
            lugar = scanner.nextInt();

            for (int i = 0; i < lugares.size(); i++) {
                if (lugares.get(i).getIdLugar() == lugar) {
                    lugarbool = true;
                    break;
                }
            }

            if (!lugarbool) {
                error += "El lugar no está en la lista\n";
            }
        } catch (ParseException e) {
            System.out.println("Error al convertir la fecha. Asegúrate de ingresarla en el formato correcto (yyyy-MM-dd).");
        } catch (InputMismatchException e) {
            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }

        if (fecha != null && lugarbool) {
            Eventos event = new Eventos(nombre, description, fecha, lugar);
            EventosDAO evedao = new EventosDAO();
            evedao.insert(event);
        } else {
            System.out.println(error);
        }
    }

    public void insertPersonajeEvento() {
        Scanner scanner = new Scanner(System.in);
        int personaje = 0, evento = 0;
        boolean personajebool = false, eventobool = false, confirmacion = true;
        List<Personajes> personajes = null;
        List<Eventos> eventos = null;
        List<Personaje_Eventos> eveper = listareventospersonajes();
        String error = "";
        try {
            personajes = listarPersonajesMain();
            System.out.print("\nIngrese el id del personaje asistente: ");
            personaje = scanner.nextInt();
            eventos = listarEventosMain();
            System.out.print("\nIngrese el id del evento: ");
            evento = scanner.nextInt();
            for (int i = 0; i < personajes.size(); i++) {
                if (personajes.get(i).getIdPersonaje() == personaje) {
                    personajebool = true;
                    break;
                }
            }
            for (int i = 0; i < eventos.size(); i++) {
                if (eventos.get(i).getIdEvento() == evento) {
                    eventobool = true;
                    break;
                }
            }
            for (int i = 0; i < eveper.size(); i++) {
                if (eveper.get(i).getFk_evento() == evento && eveper.get(i).getFk_personaje() == personaje) {
                    confirmacion = false;
                    break;
                }
            }
            if (!confirmacion) {
                error += "\nYa existe este registro\n";
            } else {
                if (!personajebool) {
                    error += "\nPersonaje no encontrado\n";
                }
                if (!eventobool) {
                    error += "\nEvento no encontrado\n";
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }
        if (personajebool && eventobool && confirmacion) {
            Personaje_Eventos personaje_eventos = new Personaje_Eventos(personaje, evento);
            Personaje_EventosDAO personaje_EventosDAO = new Personaje_EventosDAO();
            personaje_EventosDAO.insert(personaje_eventos);
        } else {
            System.out.println(error);
        }
    }

    public void actualizarRazas() {
        Scanner scanner = new Scanner(System.in);
        int raza = 0;
        Razas razasmodelo = null;
        List<Razas> razas = null;
        boolean razabool = false, namebool = false, descriptionbool = false;
        String error = "", nombreoriginal = "", descripcionoriginal = "";
        RazasDAO razasDAO = new RazasDAO();
        try {
            razas = listarRazaMain();
            System.out.print("\nIngrese el id de su raza: ");
            raza = scanner.nextInt();

            for (int i = 0; i < razas.size(); i++) {
                if (razas.get(i).getIdRaza() == raza) {
                    razabool = true;
                    nombreoriginal = razas.get(i).getNombre();
                    descripcionoriginal = razas.get(i).getDescripcion();
                }
            }

            if (!razabool) {
                error += "La raza no esta en la lista\n";
            }
        } catch (InputMismatchException e) {
            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");

        }
        if (razabool) {
            scanner.nextLine();
            System.out.println("Ingrese el nombre de la raza, El actual es: " + nombreoriginal);
            String name = scanner.nextLine().trim();
            System.out.println("Ingrese una descripción de l@s " + name + ", El actual es: " + descripcionoriginal);
            String description = scanner.nextLine().trim();
            if (name.equalsIgnoreCase(nombreoriginal)) {
                namebool = true;
            }
            if (description.equalsIgnoreCase(descripcionoriginal)) {
                descriptionbool = true;
            }
            if (!namebool && !descriptionbool) {
                razasmodelo = new Razas(raza, name, description);
                razasDAO.update(razasmodelo);
            } else if (!namebool && descriptionbool) {
                razasmodelo = new Razas(raza, name);
                razasDAO.updateName(razasmodelo);
            } else if (namebool && !descriptionbool) {
                razasmodelo = new Razas();
                razasmodelo.setDescripcion(description);
                razasmodelo.setIdRaza(raza);
                razasDAO.updateDescription(razasmodelo);
            } else {
                System.out.println("No has actualizado\n");
            }

        } else {
            System.out.println(error);
        }


    }

    public void actualizarPersonajes() {
        Scanner scanner = new Scanner(System.in);
        int personaje = 0, raza = 0, lugar = 0, razaoriginal = 0, lugaroriginal = 0;
        boolean personajebool = false, razabool = false, lugarbool = false;
        String nombreoriginal = "", descripcionoriginal = "";
        List<Personajes> personajes = null;
        List<Razas> razas = null;
        List<Lugares> lugares = null;
        String error = "";
        PersonajesDAO personajesDAO = new PersonajesDAO();
        try {
            personajes = listarPersonajesMain();
            System.out.print("\nIngrese el id de su Personaje: ");
            personaje = scanner.nextInt();
            razas = listarRazaMain();
            System.out.print("\nIngrese el id de su raza: ");
            raza = scanner.nextInt();
            lugares = listarLugaresMain();
            System.out.print("\nIngrese el id de su lugar: ");
            lugar = scanner.nextInt();
            for (int i = 0; i < personajes.size(); i++) {
                if (personajes.get(i).getIdPersonaje() == personaje) {
                    personajebool = true;
                    nombreoriginal = personajes.get(i).getNombre();
                    descripcionoriginal = personajes.get(i).getDescripcion();
                    lugaroriginal = personajes.get(i).getFk_lugar();
                    razaoriginal = personajes.get(i).getFk_raza();
                    break;
                }
            }
            for (int i = 0; i < razas.size(); i++) {
                if (razas.get(i).getIdRaza() == raza) {
                    razabool = true;
                    break;
                }
            }
            for (int i = 0; i < lugares.size(); i++) {
                if (lugares.get(i).getIdLugar() == lugar) {
                    lugarbool = true;
                    break;
                }
            }
            if (!lugarbool) {
                error += "El lugar no esta en la lista\n";
            }
            if (!personajebool) {
                error += "El personaje no esta en la lista\n";
            }
            if (!razabool) {
                error += "La raza no esta en la lista\n";
            }

        } catch (InputMismatchException e) {
            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }
        if (personajebool && razabool && lugarbool) {
            scanner.nextLine();
            System.out.println("Ingrese el nombre del personaje, El actual es: " + nombreoriginal);
            String name = scanner.nextLine().trim();
            System.out.println("Ingrese una descripción del personaje, el actual es: " + descripcionoriginal);
            String description = scanner.nextLine().trim();
            if (!name.equalsIgnoreCase(nombreoriginal)) {
                Personajes personajess = new Personajes();
                personajess.setNombre(name);
                personajess.setIdPersonaje(personaje);
                personajesDAO.updatenombre(personajess);
            }
            if (!description.equalsIgnoreCase(descripcionoriginal)) {
                Personajes personajesss = new Personajes();
                personajesss.setDescripcion(description);
                personajesss.setIdPersonaje(personaje);
                personajesDAO.updatedescrip(personajesss);
            }
            if (raza != razaoriginal) {
                Personajes personajessss = new Personajes();
                personajessss.setFk_raza(raza);
                personajessss.setIdPersonaje(personaje);
                personajesDAO.updateraza(personajessss);
            }
            if (lugar != lugaroriginal) {
                Personajes personajesssss = new Personajes();
                personajesssss.setFk_lugar(lugar);
                personajesssss.setIdPersonaje(personaje);
                personajesDAO.updatelugar(personajesssss);
            }
        } else {
            System.out.println(error);
        }
    }

    public void actualizarLugar() {
        Scanner scanner = new Scanner(System.in);
        LugaresDAO lugaresDAO = new LugaresDAO();
        int lugar = 0;
        boolean lugarbool = false;
        String error = "", nombreoriginal = "", descripcionoriginal = "", regionoriginal = "";
        List<Lugares> lugares = null;

        try {
            lugares = listarLugaresMain();
            System.out.print("\nIngrese el id de su lugar: ");
            lugar = scanner.nextInt();

            for (int i = 0; i < lugares.size(); i++) {
                if (lugares.get(i).getIdLugar() == lugar) {
                    lugarbool = true;
                    nombreoriginal = lugares.get(i).getNombre();
                    regionoriginal = lugares.get(i).getRegion();
                    descripcionoriginal = lugares.get(i).getDescripcion();
                    break;
                }
            }
            if (!lugarbool) {
                error += "El lugar no esta en la lista\n";
            }

        } catch (InputMismatchException e) {
            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }

        if (lugarbool) {
            scanner.nextLine();
            System.out.println("Ingrese el nombre de la region, la actual es: " + nombreoriginal);
            String name = scanner.nextLine().trim();
            System.out.println("Ingrese una descripción de la region, la actual es: " + descripcionoriginal);
            String description = scanner.nextLine().trim();
            System.out.println("Ingrese la region del lugar, la actual es: " + regionoriginal);
            String region = scanner.nextLine().trim();

            if (!name.equalsIgnoreCase(nombreoriginal)) {
                Lugares lugaress = new Lugares();
                lugaress.setNombre(name);
                lugaress.setIdLugar(lugar);
                lugaresDAO.updatenombre(lugaress);
            }
            if (!description.equalsIgnoreCase(descripcionoriginal)) {
                Lugares lugaress = new Lugares();
                lugaress.setDescripcion(description);
                lugaress.setIdLugar(lugar);
                lugaresDAO.updatedescripcion(lugaress);
            }
            if (!region.equalsIgnoreCase(regionoriginal)) {
                Lugares lugaress = new Lugares();
                lugaress.setRegion(region);
                lugaress.setIdLugar(lugar);
                lugaresDAO.updateregion(lugaress);
            }

        } else {
            System.out.println(error);
        }

    }

    public void actualizarEventos() {
        Scanner scanner = new Scanner(System.in);
        EventosDAO eventosDAO = new EventosDAO();
        boolean eventosbool = false, lugarbool = false;
        String error = "", nombreoriginal = "", descripcionoriginal = "";
        List<Lugares> lugares = null;
        List<Eventos> eventos = null;
        Date fechaoriginal = null, fecha = null;
        int evento = 0, lugaroriginal = 0, lugar = 0;
        try {
            eventos = listarEventosMain();
            System.out.print("\nIngrese el id del evento: ");
            evento = scanner.nextInt();
            lugares = listarLugaresMain();
            System.out.print("\nIngrese el id del lugar: ");
            lugar = scanner.nextInt();


            for (int i = 0; i < eventos.size(); i++) {
                if (eventos.get(i).getIdEvento() == evento) {
                    eventosbool = true;
                    fechaoriginal = eventos.get(i).getFecha();
                    nombreoriginal = eventos.get(i).getNombre();
                    fechaoriginal = eventos.get(i).getFecha();
                    lugaroriginal = eventos.get(i).getFk_lugar();
                    break;
                }
            }
            scanner.nextLine();
            System.out.println("Ingrese la fecha del evento (en formato yyyy-mm-dd) la fecha actua es: " + fechaoriginal);
            String fechaStr = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fecha = new Date(sdf.parse(fechaStr).getTime());

            for (int i = 0; i < lugares.size(); i++) {
                if (lugares.get(i).getIdLugar() == lugar) {
                    lugarbool = true;
                    break;
                }
            }
            if (!eventosbool) {
                error += "El evento no esta en la lista\n";
            }
            if (!lugarbool) {
                error += "El lugar no esta en la lista\n";
            }

        } catch (ParseException e) {
            System.out.println("Error al convertir la fecha. Asegúrate de ingresarla en el formato correcto (yyyy-MM-dd).");
        } catch (InputMismatchException e) {
            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }

        if (eventosbool && lugarbool && fecha != null) {
            System.out.println("Ingrese el nombre del evento, el actual es: " + nombreoriginal);
            String name = scanner.nextLine().trim();
            System.out.println("Ingrese una descripción del evento, el actual es: " + descripcionoriginal);
            String description = scanner.nextLine().trim();

            if (!name.equalsIgnoreCase(nombreoriginal)) {
                Eventos eventos1 = new Eventos();
                eventos1.setIdEvento(evento);
                eventos1.setNombre(name);
                eventosDAO.updatenombre(eventos1);
            }
            if (!description.equalsIgnoreCase(descripcionoriginal)) {
                Eventos eventos1 = new Eventos();
                eventos1.setIdEvento(evento);
                eventos1.setDescripcion(description);
                eventosDAO.updatedescripcion(eventos1);
            }
            if (lugar != lugaroriginal) {
                Eventos eventos1 = new Eventos();
                eventos1.setIdEvento(evento);
                eventos1.setFk_lugar(lugar);
                eventosDAO.updatelugar(eventos1);
            }
            if (fecha != fechaoriginal) {
                Eventos eventos1 = new Eventos();
                eventos1.setIdEvento(evento);
                eventos1.setFecha(fecha);
                eventosDAO.updatefecha(eventos1);
            }

        } else {
            System.out.println(error);
        }
    }

    public void actualizarPersonajeEventos() {
        Scanner scanner = new Scanner(System.in);
        int personaje = 0, evento = 0, personajeNuevo = 0;
        boolean personajebool = false, eventobool = false, confirmacion = true, personanuevojebool = false;
        List<Personajes> personajes = null;
        List<Eventos> eventos = null;
        List<Personaje_Eventos> eveper = listareventospersonajes();
        String error = "";
        try {
            System.out.println("Eligue el personaje seguido de su evento");
            listarPersonajes_EventosMain();
            personajes = listarPersonajesMain();
            System.out.print("\nIngrese el id del personaje asistente: ");
            personaje = scanner.nextInt();
            eventos = listarEventosMain();
            System.out.print("\nIngrese el id del evento: ");
            evento = scanner.nextInt();

            personajes = listarPersonajesMain();
            System.out.print("\nIngrese el id del personaje que deseas modificar, el anterior es:  " + personaje);
            personajeNuevo = scanner.nextInt();

            for (int i = 0; i < personajes.size(); i++) {
                if (personajes.get(i).getIdPersonaje() == personaje) {
                    personajebool = true;
                    break;
                }
            }

            for (int i = 0; i < personajes.size(); i++) {
                if (personajes.get(i).getIdPersonaje() == personajeNuevo) {
                    personanuevojebool = true;
                    break;
                }
            }

            for (int i = 0; i < eventos.size(); i++) {
                if (eventos.get(i).getIdEvento() == evento) {
                    eventobool = true;
                    break;
                }
            }
            for (int i = 0; i < eveper.size(); i++) {
                if (eveper.get(i).getFk_evento() == evento && eveper.get(i).getFk_personaje() == personaje) {
                    confirmacion = false;
                    break;
                }
            }
            if (!confirmacion) {
                error += "\nYa existe este registro\n";
            } else {
                if (!personajebool) {
                    error += "\nPersonaje viejo no encontrado\n";
                }
                if (!personanuevojebool) {
                    error += "\nPersonaje nuevo no encontrado\n";
                }
                if (!eventobool) {
                    error += "\nEvento no encontrado\n";
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }
        if (personajebool && eventobool && personanuevojebool) {
            Personaje_EventosDAO personaje_EventosDAO = new Personaje_EventosDAO();
            personaje_EventosDAO.update(personajeNuevo, personaje, evento);
        } else {
            System.out.println(error);
        }
    }


    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("Menu: \n1.-Listar\n2.-Agregar\n3.-Modificar\n4.-Salir");
            System.out.print("\nSeleccione una opción: ");
            try {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        subMenuListar();
                        break;
                    case 2:
                        subMenuInsertar();
                        break;
                    case 3:
                        subMenuActualizar();
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                scanner.next();
            }
        } while (opcion != 4);

    }

    private void subMenuListar() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n\n¿Qué deseas listar?");
            System.out.println("1. Razas");
            System.out.println("2. Personajes");
            System.out.println("3. Lugares");
            System.out.println("4. Eventos");
            System.out.println("5. Personajes-Eventos");
            System.out.println("6. Volver al menú principal");

            System.out.print("\nSeleccione una opción: ");

            try {
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        listarRazaMain();
                        break;
                    case 2:
                        listarPersonajesMain();
                        break;
                    case 3:
                        listarLugaresMain();
                        break;
                    case 4:
                        listarEventosMain();
                        break;
                    case 5:
                        listarPersonajes_EventosMain();
                        break;
                    case 6:
                        System.out.println("Volviendo al menú principal...\n\n");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                scanner.next();
            }
        } while (opcion != 6);
    }


    private void subMenuInsertar() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n\n¿Qué deseas insertar?");
            System.out.println("1. Razas");
            System.out.println("2. Personajes");
            System.out.println("3. Lugares");
            System.out.println("4. Eventos");
            System.out.println("5. Personajes-Eventos");
            System.out.println("6. Volver al menú principal");

            System.out.print("\nSeleccione una opción: ");

            try {
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        insertRazas();
                        break;
                    case 2:
                        insertPersonajes();
                        break;
                    case 3:
                        insertLugares();
                        break;
                    case 4:
                        insertEvento();
                        break;
                    case 5:
                        insertPersonajeEvento();
                        break;
                    case 6:
                        System.out.println("Volviendo al menú principal...\n\n");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                scanner.next();
            }
        } while (opcion != 6);
    }


    private void subMenuActualizar() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n\n¿Qué deseas actualizar?");
            System.out.println("1. Razas");
            System.out.println("2. Personajes");
            System.out.println("3. Lugares");
            System.out.println("4. Eventos");
            System.out.println("5. Personajes-Eventos");
            System.out.println("6. Volver al menú principal");

            System.out.print("\nSeleccione una opción: ");

            try {
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        actualizarRazas();
                        break;
                    case 2:
                        actualizarPersonajes();
                        break;
                    case 3:
                        actualizarLugar();
                        break;
                    case 4:
                        actualizarEventos();
                        break;
                    case 5:
                        actualizarPersonajeEventos();
                        break;
                    case 6:
                        System.out.println("Volviendo al menú principal...\n\n");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                scanner.next();
            }
        } while (opcion != 6);
    }


}
