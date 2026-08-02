import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ServidorUDP {

    // Estructuras para almacenar las canciones
    private static final List<String> TITULOS = new ArrayList<>();
    private static final Map<String, String> CANCIONES = new HashMap<>(); // <titulo, letra>

    /**
     * Método principal que inicia la ejecución
     * @param args Vector de argumentos de tipo cadena empleados en la invocación
     */
    public static void main(String[] args) {
        // Verificar argumentos: archivoCanciones puerto
        if (args.length != 2 || !esPuertoValido(args[1])) {
            System.out.println("Argumentos incorrectos." +
                    "\nUso: java ServidorUDP <archivoCanciones> <puerto>" +
                    "\nEjemplo: java ServidorUDP Canciones.txt 2000" +
                    "\nEl puerto tiene que estar comprendido entre 1024 y 49151");
            return;
        }

        String archivoCanciones = args[0];
        int puerto = Integer.parseInt(args[1]);

        // 1. Cargar las canciones del archivo pasado como argumento
        cargarCanciones(archivoCanciones);
        if (CANCIONES.isEmpty()) {
            System.out.println("No hay canciones en el servidor");
            return;
        }

        // Uso try-with-resources para no tener que preocuparme por cerrar los recursos
        try (DatagramSocket socket = new DatagramSocket(puerto)) {
            // 2. Paquete con el buffer para recibir las respuestas del cliente
            DatagramPacket paquetePeticion = new DatagramPacket(new byte[1024], 1024);

            // Bucle infinito para recibir peticiones del cliente
            while (true) {
                // 3. Esperar petición del cliente
                socket.receive(paquetePeticion);

                // 4. Convertir petición a texto y mostrar petición
                String peticion = new String(
                        paquetePeticion.getData(),
                        0,
                        paquetePeticion.getLength(),
                        StandardCharsets.UTF_8
                ).trim();
                System.out.println("Petición recibida del cliente: " + peticion);

                // 5. Si la petición es 0, desconectar
                if (peticion.equals("0")) {
                    System.out.println("Socket error: Socket closed");
                    break;
                }

                // 6. Lógica del menú
                byte[] respuesta = procesarPeticion(peticion).getBytes(StandardCharsets.UTF_8);

                // 7. Enviar respuesta
                DatagramPacket paqueteRespuesta = new DatagramPacket(
                        respuesta,
                        respuesta.length,
                        paquetePeticion.getAddress(),
                        paquetePeticion.getPort()
                );
                socket.send(paqueteRespuesta);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Método para determinar si se pasa un puerto válido como argumento
     * @param puerto Cadena que es validada
     * @return true si es un puerto válido
     */
    private static boolean esPuertoValido(String puerto) {
        try {
            return Integer.parseInt(puerto) >= 1024 && Integer.parseInt(puerto) <= 49151;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Método para cargar las CANCIONES desde un archivo
     * @param archivoCanciones Archivo que contiene las canciones con el siguiente formato:
     *                        % separador de título y letra
     *                        # separador de versos
     *                        ## separador de estrofas
     */
    private static void cargarCanciones(String archivoCanciones) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCanciones))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                // Separar título y letra con el separador '%', máximo 2 partes
                String[] partes = linea.split("%", 2);

                // Si hubiera solo una parte, ignorar
                if (partes.length == 2) {
                    String titulo = partes[0].trim();
                    String letra = partes[1].trim();

                    // Reemplazar saltos de línea
                    letra = letra.replaceAll("#", "\n");

                    // Guardar las CANCIONES
                    CANCIONES.put(titulo, letra);
                    TITULOS.add(titulo);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar las canciones del archivo " + archivoCanciones);
        }
    }

    /**
     * Método para procesar las peticiones y elegir la respuesta
     * @param peticion Cadena a procesar para elegir la respuesta del servidor
     * @return La respuesta del servidor al cliente
     */
    private static String procesarPeticion(String peticion) {
        StringBuilder respuesta = new StringBuilder();
        // Si la petición es una cadena vacía (si solo son espacios ya se eliminan en la recepción de la petición
        // pero, por si acaso, no cuesta nada usar isBlank() en vez de isEmpty()) se devuelve el menú
        if (peticion.isBlank()) {
            respuesta.append(generarMenu());
        } else {
            // Si no es una cadena vacía, se intenta convertir la cadena a un número
            try {
                int opcion = Integer.parseInt(peticion);
                // Se intenta obtener la letra de la canción a partir de su título
                if (opcion > 0 && opcion <= TITULOS.size()) {
                    respuesta.append(CANCIONES.get(TITULOS.get(opcion - 1)));
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                respuesta.append("La opción seleccionada no existe en el catálogo.\n\n").append(generarMenu());
            }
        }
        respuesta.append("\n\nIntroduzca la opción deseada ('0' para salir):");
        return respuesta.toString();
    }

    /**
     * Método para generar el catálogo
     * @return El catálogo en forma de cadena de texto
     */
    private static String generarMenu() {
        StringBuilder menu = new StringBuilder("Estimado usuario. Usted dispone de '" + TITULOS.size() +
                "' opciones para disfrutar de la letra del catálogo de canciones disponibles en el sistema." +
                "\nSi usted selecciona la opción '0', se finalizará la comunicación." +
                "\nLas opciones disponibles son las siguientes canciones:");
        for (int i = 0; i < TITULOS.size(); i++) {
            menu.append("\n\tOpción ").append(i + 1).append(": ").append(TITULOS.get(i));
        }
        return menu.toString();
    }
}
