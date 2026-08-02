package ej09_ejMenuOpciones;
public class MenuDemo {
    public static void main(String[] args) {
        // Crear las opciones del menú
        String[] opciones = {
            "Opción 1: Mostrar información",
            "Opción 2: Realizar cálculo",
            "Opción 3: Configuración"
        };

        // Instanciar el menú
        Menu menu = new Menu("Menú Principal", opciones);

        // Mostrar el menú y capturar la elección
        int opcionSeleccionada;
        do {
            opcionSeleccionada = menu.mostrarYObtenerSeleccion();

            // Procesar la elección del usuario
            switch (opcionSeleccionada) {
                case 1:
                    System.out.println("Has seleccionado: Mostrar información");
                    break;
                case 2:
                    System.out.println("Has seleccionado: Realizar cálculo");
                    break;
                case 3:
                    System.out.println("Has seleccionado: Configuración");
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no reconocida.");
                    break;
            }
        } while (opcionSeleccionada != 0);
    }
}
