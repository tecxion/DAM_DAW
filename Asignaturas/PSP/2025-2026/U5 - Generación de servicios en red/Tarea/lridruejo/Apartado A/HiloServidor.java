import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class HiloServidor extends Thread {

    private final Socket socketCliente;

    HiloServidor(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }

    @Override
    public void run() {
        String peticion;
        String html;
        String codigoRespuesta;

        try (socketCliente) {
            // Flujo de entrada para procesar la petición del cliente
            InputStreamReader isr = new InputStreamReader(socketCliente.getInputStream());

            // Espacio en memoria para procesar la entrada de peticiones
            BufferedReader br = new BufferedReader(isr);

            // Permite responder línea a línea al cliente en un flujo de salida
            PrintWriter respuesta = new PrintWriter(socketCliente.getOutputStream(), true);

            // Petición del cliente
            peticion = br.readLine();

            // Procesar la petición
            peticion = peticion.replaceAll(" ", "");

            // Análisis del comando solicitado en la petición del cliente
            if (peticion.startsWith("GET")) {
                // Comando "GET" (único implementado)
                // Extracción de subcadena entre "GET" y "HTTP/1.1"
                peticion = peticion.substring(3, peticion.lastIndexOf("HTTP"));

                // Análisis del recurso solicitado
                if (peticion.isEmpty() || peticion.equals("/")) {
                    // Página de inicio
                    // Devuelve el recurso solicitado
                    html = Paginas.html_index;
                    codigoRespuesta = CodigosRespuesta.codigoRespuesta200;
                } else if (peticion.equals("/loremipsum")) {
                    // Página "Lorem Ipsum"
                    // Devuelve el recurso solicitado
                    html = Paginas.html_loremipsum;
                    codigoRespuesta = CodigosRespuesta.codigoRespuesta200;
                } else {
                    // Otro caso
                    // Devuelve página de error
                    html = Paginas.html_noEncontrado;
                    codigoRespuesta = CodigosRespuesta.codigoRespuesta404;
                }
            } else {
                // Comando diferente a "GET"
                // Devuelve página de comando no implementado
                html = Paginas.html_comandoNoImplementado;
                codigoRespuesta = CodigosRespuesta.codigoRespuesta501;
            }

            // Mostrar respuesta
            respuesta.println(codigoRespuesta);
            respuesta.println(Paginas.primeraCabecera);
            respuesta.println("Content-Length: " + html.length() + 1);
            respuesta.println("\n");
            respuesta.println(html);

            System.out.println("Se ha atendido la solicitud de un cliente");

        } catch (IOException e) {
            System.err.println("Error en el hilo servidor: " + e.getMessage());
        }
    }
}
