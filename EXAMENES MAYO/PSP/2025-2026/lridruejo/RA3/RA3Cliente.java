import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RA3Cliente {

    private static final int PUERTO = 2026;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        try (Socket socketCliente = new Socket(HOST, PUERTO)) {
            // Flujos de entrada/salida
            DataInputStream entrada = new DataInputStream(socketCliente.getInputStream());
            DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());

            Scanner sc = new Scanner(System.in);
            double numeroSolicitado = -1;

            // Recibir bienvenida e instrucciones del servidor
            System.out.println(entrada.readUTF());

            while (numeroSolicitado != 0) {

                // Leer entrada de usuario por teclado
                try {
                    numeroSolicitado = sc.nextDouble();
                    sc.nextLine();

                    // Enviar petición del cliente
                    salida.writeDouble(numeroSolicitado);
                    salida.flush();

                    if (numeroSolicitado != 0) {
                        // Recibir raíz cuadrada o error del servidor
                        System.out.println(entrada.readUTF());
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, introduzca un número positivo.\n");
                    sc.nextLine();
                }
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println("Finaliza la conexión.\n");
        }
    }
}
