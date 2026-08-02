import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RA5 {

    private static final Logger LOGGER = Logger.getLogger(RA5.class.getName());
    private static final String archivoLog = "RA5.log";

    public static void main(String[] args) {

        // Configurar el logger
        try {
            // Desactivar el handler por defecto (consola)
            LOGGER.setUseParentHandlers(false);  // ← Esto evita heredar handlers del logger raíz
    
            // Eliminar cualquier handler de consola que ya tuviera
            for (java.util.logging.Handler handler : LOGGER.getHandlers()) {
                LOGGER.removeHandler(handler);
            }

            FileHandler fileHandler = new FileHandler(archivoLog, true); // Mantener los logs de ejecuciones anteriores
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.ALL); // Registrar todos los niveles
        } catch (IOException e) {
            System.err.println("No se pudo crear el archivo de log");
        }

        String mensajeLog;

        try (Scanner sc = new Scanner(System.in)) {
            String email;
            boolean emailValido = false;

            while (!emailValido) {
                System.out.println("Introduce tu login (email):");
                email = sc.nextLine();

                /*
                 Email válido:
                    - Una @ en una posición intermedia
                    - Un punto y una extensión de 3 letras
                 */
                Pattern patron = Pattern.compile(".+@.+\\.[a-zA-Z]{3}");

                Matcher matcher = patron.matcher(email);
                if (matcher.matches()) {
                    emailValido = true;
                    mensajeLog = "Se ha conectado el usuario: " + email;
                    System.out.println(mensajeLog);
                    LOGGER.info(mensajeLog);
                }
            }

            boolean respuestaValida = false;
            String respuesta;

            while (!respuestaValida) {
                System.out.println("¿Desea visualizar el fichero log?");
                respuesta = sc.nextLine();

                if (respuesta.equals("Si") || respuesta.equals("si")) {
                    respuestaValida = true;
                    mensajeLog = "El usuario quiere leer el log.";
                    System.out.println(mensajeLog);
                    LOGGER.info(mensajeLog);

                    try (BufferedReader br = new BufferedReader(new FileReader(archivoLog))) {
                        String linea;

                        while ((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        }

                        LOGGER.info("Log mostrado al usuario.");
                    } catch (FileNotFoundException e) {
                        LOGGER.severe("Archivo no encontrado: " + archivoLog);
                    } catch (IOException e) {
                        LOGGER.severe("Error al leer el archivo " + archivoLog + ": " + e.getMessage());
                    }

                } else if (respuesta.equals("No") || respuesta.equals("no")) {
                    respuestaValida = true;
                    mensajeLog = "El usuario no quiere leer el log.";
                    System.out.println(mensajeLog);
                    LOGGER.info(mensajeLog);
                } else {
                    System.out.println("Las respuestas válidas son Si, si, No y no.");
                }
            }

            System.out.println("\nAdiós.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            LOGGER.severe("Error: " + e.getMessage());
        }

    }
}
