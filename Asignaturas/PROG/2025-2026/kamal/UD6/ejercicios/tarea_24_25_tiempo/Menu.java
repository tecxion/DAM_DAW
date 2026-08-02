package tarea_24_25_tiempo;

import java.util.Scanner;

public class Menu {
    private String titulo;         // Título del menú
    private String[] opciones;    // Opciones del menú
    private Scanner scanner;      // Objeto para capturar la entrada del usuario

    // Constructor para inicializar el menú
    public Menu(String titulo, String[] opciones) {
        this.titulo = titulo;
        this.opciones = opciones;
        this.scanner = new Scanner(System.in);
    }

    // Método para mostrar el menú y capturar la elección del usuario
    public int mostrarYObtenerSeleccion() {
        int opcion = -1; // Variable para almacenar la selección del usuario
        boolean esValido = false;

        while (!esValido) {
            try {
                // Mostrar el título
                System.out.println("\n" + titulo);
                System.out.println("=".repeat(titulo.length()));

                // Mostrar las opciones
                for (int i = 0; i < opciones.length; i++) {
                    System.out.println((i + 1) + ". " + opciones[i]);
                }
               
                // Capturar la elección del usuario
                System.out.print("Selecciona una opción: ");
                opcion = Integer.parseInt(scanner.nextLine());

                // Verificar si la opción está en el rango permitido
                if (opcion >= 0 && opcion <= opciones.length) {
                    esValido = true;
                } else {
                    System.out.println("Error: Por favor, selecciona una opción válida entre 0 y " + opciones.length + ".");
                }
            } catch (NumberFormatException e) {
                // Capturar entradas no numéricas
                System.out.println("Error: La entrada debe ser un número. Inténtalo de nuevo.");
            }
        }

        return opcion; // Retornar la opción seleccionada
    }
}
