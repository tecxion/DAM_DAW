import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
    
    private static final int PUERTO = 2000;
    private static final String HOST = "localhost";

    /**
     * Método principal que inicia la ejecución
     * @param args Vector de argumentos de tipo cadena empleados en la invocación
     */
    public static void main(String[] args) {
        try (Socket socketCliente = new Socket(HOST, PUERTO)) {
            System.out.println("Bienvenido, cliente. Procedamos con el juego.");
            System.out.println("INSTRUCCIONES:");
            System.out.println("Usted debe acertar el próximo carácter (carácter A si el actual propuesto fuera " +
                    "el carácter Z) o el anterior carácter (carácter Z si el actual propuesto fuera el carácter A)." +
                    "\nPuede responder haciendo uso indistinto de mayúscula o minúscula. A los 3 errores finalizará " +
                    "el juego y si logra '9' aciertos antes de haber cometido un máximo de '3' errores, habrá logrado " +
                    "la máxima puntuación con lo cual el juego finalizará." +
                    "\n¡Mucha suerte!");

            // Flujos de entrada/salida
            DataInputStream entrada = new DataInputStream(socketCliente.getInputStream());
            DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());

            Scanner sc = new Scanner(System.in);
            boolean finalizar = false;

            while (!finalizar) {
                // 1. Recibir pregunta del servidor
                System.out.println(entrada.readUTF());

                // 2. Enviar respuesta del cliente
                salida.writeUTF(sc.nextLine());
                salida.flush();

                // 3. Recibir resultado (acierto/error) del servidor
                System.out.println(entrada.readUTF());

                // 4. Recibir estado del juego
                finalizar = entrada.readBoolean();
            }

            // Mostrar resultado del juego
            System.out.println(entrada.readUTF());

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println("Finaliza la conexión. FIN.\nSaludos...\nSocket closed");
        }
    }
}
