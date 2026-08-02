import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServidorHTTP {

    private static final int PUERTO = 8080;

    public static void main(String[] args) {
        // Inicio del servidor en el puerto
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            Socket socketCliente;

            while (true) {
                // Espera activa hasta que se conecte un cliente
                socketCliente = serverSocket.accept();

                // Crear hilo servidor para atender al cliente
                new HiloServidor(socketCliente).start();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

class HiloServidor extends Thread {

    private final Socket socketCliente;

    public HiloServidor(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }

    @Override
    public void run() {
        String peticion;
        String html;
        String codigoHttp;

        try (socketCliente) {
            // Flujo de entrada para procesar la petición del cliente
            InputStreamReader isr = new InputStreamReader(socketCliente.getInputStream());

            // Espacio en memoria para procesar la entrada de peticiones
            BufferedReader br = new BufferedReader(isr);

            // Permite responder línea a línea al cliente en un flujo de salida
            PrintWriter respuesta = new PrintWriter(socketCliente.getOutputStream(), true);

            // Petición del cliente
            peticion = br.readLine();

            if (peticion == null) return;

            // Parsear método y recurso
            String[] partes = peticion.split(" ");
            String metodo = partes[0];
            String recurso = partes[1];

            // Análisis de la petición del cliente
            if (metodo.equals("GET")) {
                // Método GET
                html = construirRespuesta(recurso);
                codigoHttp = CodigosHTTP.OK;
            } else {
                // Cualquier otro método
                html = Paginas.html_comandoNoImplementado;
                codigoHttp = CodigosHTTP.NOT_IMPLEMENTED;
            }

            // Mostrar respuesta
            respuesta.println(codigoHttp);
            respuesta.println(Paginas.primeraCabecera);
            respuesta.println("Content-Length: " + html.getBytes(StandardCharsets.UTF_8).length);
            respuesta.println();
            respuesta.println(html);

        } catch (IOException e) {
            System.err.println("Error en el hilo del servidor: " + e.getMessage());
        }
    }

    private String construirRespuesta(String recurso) {

        recurso = recurso.substring(1);
        recurso = java.net.URLDecoder.decode(recurso, StandardCharsets.UTF_8);
        StringBuilder respuesta = new StringBuilder();

        try {
            int numero = Integer.parseInt(recurso);

            for (int i = 0; i < numero; i++) {
                respuesta.append("Línea número: ").append(i + 1).append("<br>");
            }
        } catch (NumberFormatException e) {
            respuesta.append("Hola ").append(recurso);
        }

        return respuesta.toString();
    }
}