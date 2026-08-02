import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor extends Thread {

    private static final int PUERTO = 1234;
    private static int contadorClientes = 0;
    private static final ArrayList<Servidor> clientesConectados = new ArrayList<>();

    private final int clienteID;
    private final Socket socketCliente;
    private DataOutputStream flujoSalida;

    // Constructor
    private Servidor(Socket socketCliente) {
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
                System.out.println("\nNueva petición de cliente recibida:");
                System.out.println("\t- " + socketCliente);
                System.out.println(("\t- Cliente agregado con identificador 'cliente " + contadorClientes +
                        "' a la lista activa de clientes en el sistema"));

                // Crear otro hilo del servidor para atender al cliente
                Servidor hiloServidor = new Servidor(socketCliente);
                hiloServidor.start();

                // Añadir a clientes conectados
                clientesConectados.add(hiloServidor);
                contadorClientes++;

                // Notificar a los otros clientes
                notificarClientesDisponibles();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    // Método para notificar los clientes disponibles
    private static void notificarClientesDisponibles() {
        for (Servidor s : clientesConectados) {
            try {
                List<Servidor> clientesDisponibles = new ArrayList<>(clientesConectados);
                clientesDisponibles.remove(s);
                if (s.flujoSalida != null) {
                    s.flujoSalida.writeUTF("\t- Clientes actualmente conectados a los cuales es " +
                            "posible enviar mensajes: " + clientesDisponibles);
                    s.flujoSalida.flush();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    // Método para notificar la desconexión de un cliente
    private static void notificarDesconexion(int clienteID) {
        for (Servidor s : clientesConectados) {
            try {
                if (s.flujoSalida != null) {
                    s.flujoSalida.writeUTF("\t- 'cliente " + clienteID + "' ha solicitado desconexión y no " +
                            "será posible enviarle mensajes");
                    s.flujoSalida.flush();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public void run() {
        try {
            // Flujos de entrada/salida
            DataInputStream flujoEntrada = new DataInputStream(socketCliente.getInputStream());
            flujoSalida = new DataOutputStream(socketCliente.getOutputStream());

            String mensajeCompleto;

            // Bucle infinito para recibir mensajes hasta que el mensaje sea "salir"
            while (true) {
                mensajeCompleto = flujoEntrada.readUTF().trim();

                // Mostrar el mensaje en el servidor
                System.out.println("\nMensaje recibido desde 'cliente " + clienteID + "': '" + mensajeCompleto + "'");

                // Si el mensaje es "salir", salir del bucle
                if (mensajeCompleto.equals("salir")) {
                    break;
                }

                // Si el mensaje no es "salir", intentar dividir el mensaje
                String[] partesMensaje = mensajeCompleto.split("@cliente ", 2);

                // Si el mensaje no tiene dos partes, no hacer nada
                if (partesMensaje.length == 2) {
                    // Si el mensaje tiene dos partes, intentar obtener el ID del cliente destinatario
                    int clienteDestinatario = Integer.parseInt(partesMensaje[1]);
                    // Buscar el cliente destinatario en la lista de clientes conectados
                    for (Servidor s : clientesConectados) {
                        // Si el cliente destinatario no está en la lista de clientes conectados, no hacer nada
                        if (s.clienteID == clienteDestinatario) {
                            // Si el cliente destinatario está en la lista de clientes conectados, enviar el mensaje
                            try {
                                s.flujoSalida.writeUTF("cliente " + clienteID + " : " + partesMensaje[0]);
                                s.flujoSalida.flush();
                            } catch (IOException e) {
                                System.err.println(e.getMessage());
                            }
                        }
                    }
                }
            }

            // El mensaje es "salir"
            // Mostrar clientes conectados antes de la desconexión de este cliente
            System.out.println("\t- Clientes actualmente conectados: " + clientesConectados);

            // Desconectar cliente
            this.socketCliente.close();
            clientesConectados.remove(this);

            // Mostrar clientes conectados tras la desconexión de este cliente
            System.out.println("\t- 'cliente " + clienteID + "' ha solicitado finalizar la conexión y ha sido " +
                    "eliminado");
            System.out.println("\t- Clientes actualmente conectados: " + clientesConectados);
            notificarDesconexion(clienteID);
            notificarClientesDisponibles();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "cliente " + clienteID;
    }
}
