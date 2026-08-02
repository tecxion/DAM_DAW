import java.io.*;
import java.net.*;

public class ServidorTCP {

    private static final int PUERTO = 2000;
    private static final int ACIERTOS_PARA_GANAR = 9;
    private static final int ERRORES_PARA_PERDER = 3;

    /**
     * Método principal que inicia la ejecución
     * @param args Vector de argumentos de tipo cadena empleados en la invocación
     */
    public static void main(String[] args) {
        // Uso try-with-resources para no tener que preocuparme por cerrar los recursos
        try (ServerSocket socketServidor = new ServerSocket(PUERTO)) {
            System.out.println("Inicio de escucha en el puerto " + PUERTO);

            try (// Espera activa hasta que se conecte el socketCliente
                    Socket socketCliente = socketServidor.accept()) {

                // Flujos de entrada/salida
                DataInputStream entrada = new DataInputStream(socketCliente.getInputStream());
                DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());

                String alfabeto = "abcdefghijklmnñopqrstuvwxyz";
                int aciertos = 0;
                int errores = 0;
                boolean finalizar = false;

                while (aciertos < ACIERTOS_PARA_GANAR && errores < ERRORES_PARA_PERDER) {
                    // 1. Generar letra aleatoria (a-z)
                    int indice = (int) (Math.random() * alfabeto.length());
                    char caracterActual = alfabeto.charAt(indice);

                    // 2. Decidir si pedir anterior o siguiente y crear solución
                    // Valor aleatorio entre 0 o 1. 0 = anterior, 1 = siguiente
                    boolean anterior = (int) (Math.random() * 2) == 0;
                    String antSig = anterior ? "anterior" : "siguiente";

                    // 3. Obtener solución
                    char solucion = getSolucion(indice, anterior, alfabeto);

                    // 4. Enviar pregunta al cliente
                    salida.writeUTF("Cliente, debe indicar el carácter '" + antSig + "' respecto a este carácter: '" +
                            caracterActual + "'");
                    // salida.flush() después de cada escritura para asegurar el envío inmediato y evitar que los
                    // mensajes se queden en el buffer, sincronizando servidor-cliente
                    salida.flush();

                    // 5. Recibir respuesta del cliente
                    String respuestaCliente = entrada.readUTF().toLowerCase().trim();
                    System.out.println("Respuesta del cliente: " + respuestaCliente);

                    // 6. Comprobar respuesta del cliente
                    boolean acertado = respuestaCliente.length() == 1 && respuestaCliente.charAt(0) == solucion;

                    if (acertado) {
                        aciertos++;
                        System.out.println("El cliente ha acertado el desafío ('" + aciertos + "' aciertos).");
                        salida.writeUTF("¡Enhorabuena! Usted ha acertado.");
                    } else {
                        errores++;
                        System.out.println("El cliente ha errado el desafío ('" + errores + "' errores).");
                        salida.writeUTF("¡Vaya! Mala suerte: usted ha cometido un error.");
                    }
                    salida.flush();

                    if (errores == ERRORES_PARA_PERDER || aciertos == ACIERTOS_PARA_GANAR) {
                        finalizar = true;
                    }

                    salida.writeBoolean(finalizar);
                    salida.flush();
                }

                String resultadoMensaje = aciertos == ACIERTOS_PARA_GANAR
                        ? "¡Enhorabuena! Ha ganado el juego."
                        : "¡Lo siento! Ha perdido el juego.";
                String puntuacionMensaje = "ha logrado un total de '" + aciertos + "' aciertos " +
                        "y un total de '" + errores + "' errores. La puntuación final es de '" + (aciertos - errores) +
                        "' puntos (aciertos - errores).";

                salida.writeUTF(resultadoMensaje + " Usted " + puntuacionMensaje);
                salida.flush();

                System.out.println("Partida finalizada. El cliente " + puntuacionMensaje);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally{
            System.out.println("Finaliza la conexión.");
        }
    }

    /**
     * Método para obtener el carácter solución
     * @param indice Posición del carácter actual
     * @param anterior Booleano para saber si la solución es el carácter siguiente o el anterior
     * @param alfabeto Cadena con las letras del alfabeto castellano
     * @return El caracter solución
     */
    private static char getSolucion(int indice, boolean anterior, String alfabeto) {
        if (indice == 0 && anterior) {
            // Si el carácter actual es el primero y se pide el anterior, la solución es el último
            return alfabeto.charAt(alfabeto.length() - 1);
        } else if (indice == alfabeto.length() - 1 && !anterior) {
            // Si el carácter actual es el último y se pide el siguiente, la solución es el primero
            return alfabeto.charAt(0);
        } else {
            // Si el carácter actual no es ni el primero ni el último, la solución es el anterior/siguiente
            return anterior ? alfabeto.charAt(indice - 1) : alfabeto.charAt(indice + 1);
        }
    }

}
