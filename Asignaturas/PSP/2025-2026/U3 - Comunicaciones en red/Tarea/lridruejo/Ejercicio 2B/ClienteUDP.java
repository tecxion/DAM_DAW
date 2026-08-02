import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ClienteUDP {
    
    private static final int MAX_PACKET_SIZE = 65507; // Máximo UDP
    
    /**
     * Método principal que inicia la ejecución
     * @param args Vector de argumentos de tipo cadena empleados en la invocación
     */
    public static void main(String[] args) {
        // Verificar argumentos: host puerto
        if (args.length != 2 || !esPuertoValido(args[1])) {
            System.out.println("Argumentos incorrectos." +
                    "\nUso: java ClienteUDP <host> <puerto>" +
                    "\nEjemplo: java ClienteUDP localhost 2000" +
                    "\nEjemplo: java ClienteUDP 192.168.1.100 2000" +
                    "\nEl puerto tiene que estar comprendido entre 1024 y 49151");
            return;
        }

        String host = args[0];
        int puerto = Integer.parseInt(args[1]);

        try (DatagramSocket socket = new DatagramSocket()) {
            // 1. Scanner para leer la entrada del usuario
            Scanner sc = new Scanner(System.in);

            while (true) {
                // 2. Leer selección del cliente
                String seleccion = sc.nextLine().trim();

                // 3. Procesar peticion para enviarla
                byte[] peticion = seleccion.getBytes(StandardCharsets.UTF_8);

                // 4. Enviar petición
                DatagramPacket paquetePeticion = new DatagramPacket(
                        peticion,
                        peticion.length,
                        InetAddress.getByName(host),
                        puerto
                );
                socket.send(paquetePeticion);

                // 5. Si la selección es 0, salir
                if (seleccion.equals("0")) {
                    return;
                }

                // 6. Recibir longitud de la respuesta
                DatagramPacket paqueteLongitud = new DatagramPacket(new byte[10], 10);
                socket.receive(paqueteLongitud);

                // 7. Validar longitud y crear el paquete para recibir la respuesta
                DatagramPacket paqueteRespuesta = getDatagramPacket(paqueteLongitud);

                // 8. Recibir respuesta
                socket.receive(paqueteRespuesta);
                System.out.println(new String(
                        paqueteRespuesta.getData(),
                        0,
                        paqueteRespuesta.getLength(),
                        StandardCharsets.UTF_8
                ));
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
     * Método para validar la longitud de la respuesta y crear el paquete para recibirla
     * @param paqueteLongitud Paquete que contiene la longitud de la respuesta que el servidor quiere enviar
     * @return DatagramPacket con la longitud exacta para recibir la respuesta del servidor
     * @throws IOException Si el paquete no contiene una longitud válida
     */
    private static DatagramPacket getDatagramPacket(DatagramPacket paqueteLongitud) throws IOException {
        int longitud = Integer.parseInt(new String(
                paqueteLongitud.getData(),
                0,
                paqueteLongitud.getLength(),
                StandardCharsets.UTF_8
        ));

        // Validar tamaño de la respuesta
        if (longitud <= 0 || longitud > MAX_PACKET_SIZE) {
            throw new IOException("La longitud de la respuesta es inválida.");
        }

        // Devolver el paquete para recibir la respuesta
        return new DatagramPacket(new byte[longitud], longitud);
    }

}
