import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("=== INICIO DEL PROGRAMA ===");

        try (Scanner sc = new Scanner(System.in)) {
            // Solicitar nombre de usuario y validarlo
            LOGGER.info("Solicitud del nombre de usuario");
            System.out.print("Introduce el nombre de usuario: ");
            String nombreUsuario = sc.nextLine();
            if (!validarUsuario(nombreUsuario)) {
                LOGGER.error("El nombre de usuario no cumple con los requisitos: {}", nombreUsuario);
                return;
            }
            LOGGER.info("Se ha introducido un nombre de usuario válido: {}", nombreUsuario);

            // Solicitar nombre del archivo y validarlo
            LOGGER.info("Solicitud del nombre del archivo");
            System.out.print("Introduce el nombre del archivo: ");
            String nombreArchivo = sc.nextLine();
            if (!validarArchivo(nombreArchivo)) {
                LOGGER.error("El nombre del archivo no cumple con los requisitos: {}", nombreArchivo);
                return;
            }
            LOGGER.info("Se ha introducido un nombre de archivo válido: {}", nombreArchivo);

            // Leer y mostrar el archivo
            leerYMostrarArchivo(nombreArchivo);
        } catch (Exception e) {
            LOGGER.error("Error al leer la entrada del usuario: {}", e.getMessage());
        } finally {
            LOGGER.info("=== FIN DEL PROGRAMA ===");
        }
    }

    /*
     Método para validar el nombre de usuario:
     - Longitud de exactamente 6 caracteres
     - Al menos un carácter alfabético en minúscula
     - Al menos un carácter alfabético en mayúscula
     - Al menos un carácter de tipo dígito numérico
     - Al menos un carácter especial ('.' (punto), '-' (guion), '_' (guion bajo))
     */
    private static boolean validarUsuario(String nombreUsuario) {
        if (nombreUsuario == null) {
            return false;
        }
        Pattern patron = Pattern.compile(
                "^" +  // inicio
                        "(?=.*[a-z])" +  // al menos una minúscula
                        "(?=.*[A-Z])" +  // al menos una mayúscula
                        "(?=.*[0-9])" +  // al menos un dígito numérico
                        "(?=.*[._-])" +  // al menos un carácter especial (punto, guion, guion bajo)
                        ".{6}" +  // 6 caracteres
                        "$"  // fin
        );
        Matcher matcher = patron.matcher(nombreUsuario);
        return matcher.matches();
    }

    /*
     Método para validar el nombre del archivo:
     - Máximo 8 caracteres exclusivamente alfanuméricos
     - Nombre y extensión separados por '.' (punto)
     - Extensión compuesta exactamente por 3 caracteres alfanuméricos
     Según lo entiendo de las especificaciones de la tarea, el nombre del archivo debería tener como máximo 4 caracteres
     de longitud (8 caracteres entiendo que es la longitud máxima de nombreArchivo, lo que incluye el nombre, el punto y
     la extensión.
     Sin embargo, en la tutoría del 24 de marzo pones como ejemplo de archivo válido "doc1213.txt", por lo que he
     aplicado el máximo de 8 caracteres al nombre y no al valor de nombreArchivo.
     */
    private static boolean validarArchivo(String nombreArchivo) {
        if (nombreArchivo == null) {
            return false;
        }
        Pattern patron = Pattern.compile(
                "^" +
                        "[a-zA-Z0-9]{1,8}" +  // 1 a 8 caracteres alfanuméricos
                        "\\." +  // punto
                        "[a-zA-Z0-9]{3}" +  // extensión de 3 caracteres alfanuméricos
                        "$"
        );
        Matcher matcher = patron.matcher(nombreArchivo);
        return matcher.matches();
    }

    // Método para leer y mostrar el contenido de un archivo de texto
    private static void leerYMostrarArchivo(String nombreArchivo) {

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;

            LOGGER.info("Leyendo el archivo: {}", nombreArchivo);
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            LOGGER.info("Archivo leído correctamente");
        } catch (FileNotFoundException e) {
            LOGGER.error("Archivo no encontrado: {}", nombreArchivo);
        } catch (IOException e) {
            LOGGER.error("Error al leer el archivo {}: {}", nombreArchivo, e.getMessage());
        }
    }
}
