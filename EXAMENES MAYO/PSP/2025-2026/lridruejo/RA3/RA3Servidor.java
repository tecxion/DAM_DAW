import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RA3Servidor extends Thread {

    private static final int PUERTO = 2026;
    private static int contadorClientes = 1;

    private final int clienteID;
    private final Socket socketCliente;

    // Constructor
    private RA3Servidor(Socket socketCliente) {
        clienteID = contadorClientes;
        this.socketCliente = socketCliente;
    }

    public static void main(String[] args) {
        // Inicio el servidor en el puerto
        try (ServerSocket socketServidor = new ServerSocket(PUERTO)) {
            while (true) {
                // Espera activa hasta que se conecte un cliente
                Socket socketCliente = socketServidor.accept();

                // Mostrar conexión de un nuevo cliente
                System.out.println("\nNuevo cliente conectado: Cliente con ID = " + contadorClientes);

                // Crear otro hilo del servidor para atender al cliente
                RA3Servidor hiloServidor = new RA3Servidor(socketCliente);
                hiloServidor.start();
                contadorClientes++;
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            // Flujos de entrada/salida
            DataInputStream entrada = new DataInputStream(socketCliente.getInputStream());
            DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());

            double numeroSolicitado;
            double raiz;

            // Dar la bienvenida al cliente y enviarle las instrucciones
            salida.writeUTF("ClienteID = " + clienteID + "\n" +
                    "Escriba un número positivo para recibir su raíz cuadrada.\n" +
                    "Escriba 0 para salir.\n");
            salida.flush();

            // Bucle infinito para recibir mensajes hasta que el número recibido sea 0
            while (true) {
                try {
                    // No debería lanzar excepción porque ya se maneja en la entrada del cliente
                    numeroSolicitado = entrada.readDouble();

                    // Si el número solicitado es 0, salir
                    if (numeroSolicitado == 0) {
                        break;
                    }

                    // Si el número solicitado es menor que 0, lanzar excepción
                    if (numeroSolicitado < 0) {
                        throw new IOException();
                    }

                    // Calcular la raíz cuadrada
                    raiz = Math.sqrt(numeroSolicitado);

                    // Enviar al cliente la raíz cuadrada
                    salida.writeUTF("Raíz cuadrada de " + Double.toString(numeroSolicitado) + ":\n\t" +
                            Double.toString(raiz) + "\n");
                    salida.flush();

                } catch (IOException e) {
                    salida.writeUTF("Número no válido. Por favor, introduzca un número positivo.\n");
                    salida.flush();
                }
            }

            // Notificar desconexión cliente
            System.out.println("\nEl cliente " + clienteID + " se ha desconectado.");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
