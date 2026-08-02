import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ClienteUDP {

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

            // 2. Buffer para recibir las respuestas del servidor (con un tamaño de 1024 no es suficiente para
            // la letra de las canciones 1 y 3)
            /*
                Para cubrir canciones largas, se podría proceder de una de las siguientes maneras:
                    1 - Asignar un buffer grande asumiendo un posible desperdicio de memoria
                    2 - Recibir del servidor primero un paquete con el tamaño necesario del buffer
                        // El servidor enviaría
                        byte[] longitud = String.valueOf(respuesta.length).getBytes(StandardCharsets.UTF_8);
                        DatagramPacket paqueteLongitud = new DatagramPacket(
                            longitud,
                            longitud.length,
                            paquetePeticion.getAddress(),
                            paquetePeticion.getPort()
                        );
                        socket.send(paqueteLongitud);

                        // Y el cliente lo recibiría
                        DatagramPacket paqueteLongitud = new DatagramPacket(new byte[10], 10);
                        socket.receive(paqueteLongitud);
                        int longitud = Integer.parseInt(new String(
                            paqueteLongitud.getData(),
                            0,
                            paqueteLongitud.getLength(),
                            StandardCharsets.UTF_8
                        ));
                        // Y crearía el paquete para recibir la respuesta sabiendo la longitud
                        DatagramPacket paqueteRespuesta = new DatagramPacket(new byte[longitud], longitud);
                Pero en este caso no merece la pena por eficiencia habiendo solo 3 canciones y de longitudes similares
                y habría que manejar casos límite (longitud demasiado corta o demasiado larga)
            */
            DatagramPacket paqueteRespuesta = new DatagramPacket(new byte[2048], 2048);

            while (true) {
                // 3. Leer selección del cliente
                String seleccion = sc.nextLine().trim();

                // 4. Procesar peticion para enviarla
                byte[] peticion = seleccion.getBytes(StandardCharsets.UTF_8);

                // 5. Enviar petición
                DatagramPacket paquetePeticion = new DatagramPacket(
                        peticion,
                        peticion.length,
                        InetAddress.getByName(host),
                        puerto
                );
                socket.send(paquetePeticion);

                // 6. Si la selección es 0, salir
                if (seleccion.equals("0")) {
                    return;
                }

                // 7. Recibir respuesta
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

}
