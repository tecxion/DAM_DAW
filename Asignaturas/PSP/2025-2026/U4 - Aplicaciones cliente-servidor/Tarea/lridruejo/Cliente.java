import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    private static final String HOST = "localhost";
    private static final int PUERTO = 1234;

    public static void main(String[] args) {
        // Conectar al servidor
        try (Socket socketCliente = new Socket(HOST, PUERTO);
        ) {
            System.out.println("Para enviar un mensaje a otro cliente debe, en cada mensaje, anotar al destinatario. " +
                    "Esto se hace escribiendo, tras el mensaje, el carácter '@' seguido del cliente. Por ejemplo:\n" +
                    "hola@cliente X (en este caso se envía el texto 'hola' al cliente 'cliente X' donde X es un " +
                    "número natural)\nPara salir y finalizar la ejecución debe escribir la palabra 'salir'.\n");

            // Flujos de entrada/salida
            DataInputStream flujoEntrada = new DataInputStream(socketCliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(socketCliente.getOutputStream());

            // Hilo para recibir mensajes del servidor
            new Thread(() -> {
                try {
                    while (true) {
                        System.out.println(flujoEntrada.readUTF());
                    }
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }).start();

            Scanner sc = new Scanner(System.in);
            String mensaje;

            // Bucle para enviar mensajes hasta que el mensaje sea "salir"
            while (true) {
                mensaje = sc.nextLine().trim();
                flujoSalida.writeUTF(mensaje);
                flujoSalida.flush();

                if (mensaje.equals("salir")) {
                    break;
                }
            }

            // Los streams se cierran automáticamente al cerrar el socket
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
