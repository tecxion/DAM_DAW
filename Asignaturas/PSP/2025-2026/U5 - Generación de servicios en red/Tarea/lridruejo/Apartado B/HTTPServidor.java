import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServidor {

    private static final int PUERTO = 8500;

    public static void main(String[] args) {
        // Inicio del servidor en el puerto
        try (ServerSocket socketServidor = new ServerSocket(PUERTO)) {
            anuncio();
            Socket socketCliente;

            while (true) {
                // Espera activa hasta que se conecte un cliente
                socketCliente = socketServidor.accept();

                System.out.println("Recibida la solicitud de un cliente");

                // Crear hilo servidor para atender al cliente
                HiloServidor hiloServidor = new HiloServidor(socketCliente);
                hiloServidor.start();  // El hiloServidor maneja el socketCliente y lo cierra
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }

    // Método para mostrar indicaciones en la consola donde se ejecuta el proceso servidor con
    // aclaraciones de funcionamiento
    private static void anuncio() {
        System.out.println("""
                El servicio HTTP se está prestando y atiende peticiones en el puerto 8500.
                Las peticiones deben ser dirigidas a la URL: http://localhost:8500
                Si quieres obtener el recurso 'tempminima' deberás solicitar la URL: http://localhost:8500/tempminima
                Si quieres obtener el recurso 'loremipsum' deberás solicitar la URL: http://localhost:8500/loremipsum
                Si quieres obtener una simulación de error solicita la URL: localhost:8500/q""");
    }
}
