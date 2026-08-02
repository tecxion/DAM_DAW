public class Ejercicio2A {

    public static void main(String[] args) {
        if (args.length > 0) {
            // Concatenar todos los argumentos en una cadena
            String cadena = String.join(" ", args);

            // Mostrar la cadena 2 veces identificando el número de línea
            System.out.println("1: " + cadena);
            System.out.println("2: " + cadena);
        } else {
            // Mostrar mensaje si no hay ninguna cadena
            System.out.println("No se ha proporcionado ningún argumento. " +
                    "No hay ninguna cadena.");
        }
    }

}