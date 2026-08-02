import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class RA1a {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        double base = 0;
        double altura = 0;
        Process ra1b;
        Process ra1c;

        try {
            System.out.println("Introduce la base del rectángulo:");
            base = Double.parseDouble(br.readLine().trim());

            System.out.println("Introduce la altura del rectangulo:");
            altura = Double.parseDouble(br.readLine().trim());
        } catch (Exception e) {
            System.err.println("El formato no es válido.");
            return;
        }

        try {
            System.out.println("El resultado ofrecido por RA1b es:");
            ra1b = Runtime.getRuntime().exec("java RA1b " + base + " " + altura);

            // Leer la salida del proceso ra1b
            InputStreamReader isrRa1b = new InputStreamReader(ra1b.getInputStream(), StandardCharsets.UTF_8);
            BufferedReader brRa1b = new BufferedReader(isrRa1b);
            String linea;

            // Mostrar por pantalla la salida del proceso
            while ((linea = brRa1b.readLine()) != null) {
                System.out.println(linea);
            }

            brRa1b.close();
        } catch (Exception e) {
            System.err.println("El programa RA1b no ha podido ejecutarse correctamente.");
            System.err.println(e.getMessage());
        }

        try {
            System.out.println("El resultado ofrecido por RA1c es:");
            ra1c = Runtime.getRuntime().exec("java RA1c " + base + " " + altura);

            // Leer la salida del proceso ra1c
            InputStreamReader isrRa1c = new InputStreamReader(ra1c.getInputStream(), StandardCharsets.UTF_8);
            BufferedReader brRa1c = new BufferedReader(isrRa1c);
            String linea;

            // Mostrar por pantalla la salida del proceso
            while ((linea = brRa1c.readLine()) != null) {
                System.out.println(linea);
            }

            brRa1c.close();
        } catch (Exception e) {
            System.err.println("El programa RA1c no ha podido ejecutarse correctamente.");
            System.err.println(e.getMessage());
        }
    }
}
