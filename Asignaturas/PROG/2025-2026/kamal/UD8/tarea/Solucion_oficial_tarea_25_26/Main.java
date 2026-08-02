package tarea_25_26;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PeliculasDAO dao = new PeliculasDAO();

        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    insertarPelicula(sc, dao);
                    break;
                case 2:
                    actualizarDuracion(sc, dao);
                    break;
                case 3:
                    eliminarPelicula(sc, dao);
                    break;
                case 4:
                    dao.listarTodasLasPeliculas();
                    break;
                case 5:
                    listarPorGenero(sc, dao);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 0);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== MENÚ GESTIÓN DE PELÍCULAS =====");
        System.out.println("1. Insertar película");
        System.out.println("2. Actualizar duración de una película");
        System.out.println("3. Eliminar película");
        System.out.println("4. Listar todas las películas");
        System.out.println("5. Listar películas por género");
        System.out.println("0. Salir");
    }

    private static void insertarPelicula(Scanner sc, PeliculasDAO dao) {
        System.out.print("Introduzca el título: ");
        String titulo = sc.nextLine();

        System.out.print("Introduzca el director: ");
        String director = sc.nextLine();

        System.out.print("Introduzca el género: ");
        String genero = sc.nextLine();

        int anioEstreno = leerEntero(sc, "Introduzca el año de estreno: ");
        int duracion = leerEntero(sc, "Introduzca la duración en minutos: ");

        dao.insertarPelicula(titulo, director, genero, anioEstreno, duracion);
    }

    private static void actualizarDuracion(Scanner sc, PeliculasDAO dao) {
        System.out.print("Introduzca el título de la película: ");
        String titulo = sc.nextLine();

        int nuevaDuracion = leerEntero(sc, "Introduzca la nueva duración en minutos: ");

        dao.actualizarDuracion(titulo, nuevaDuracion);
    }

    private static void eliminarPelicula(Scanner sc, PeliculasDAO dao) {
        System.out.print("Introduzca el título de la película que desea eliminar: ");
        String titulo = sc.nextLine();

        dao.eliminarPelicula(titulo);
    }

    private static void listarPorGenero(Scanner sc, PeliculasDAO dao) {
        System.out.print("Introduzca el género: ");
        String genero = sc.nextLine();

        dao.listarPorGenero(genero);
    }

    private static int leerEntero(Scanner sc, String mensaje) {
        int numero;
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                numero = sc.nextInt();
                sc.nextLine();
                return numero;
            } else {
                System.out.println("Error: debe introducir un número entero.");
                sc.nextLine();
            }
        }
    }
}