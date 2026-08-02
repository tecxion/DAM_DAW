import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenarNumeros {

    public static void main(String[] args) {

        // Lector de entrada estándar
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String lineaTeclado;

        // ArrayList para almacenar los números
        List<Integer> numeros = new ArrayList<>();

        try {
            while ((lineaTeclado = br.readLine()) != null) {
                try {
                    numeros.add(Integer.valueOf(lineaTeclado.trim()));
                } catch (NumberFormatException e) {
                    // La línea se ignora si no es numérica
                }
            }
        } catch (IOException e) {
            System.err.println("Se ha producido un error de E/S.");
            System.err.println(e.getMessage());
        }

        // Ordenar en forma descendiente
        numeros.sort(Collections.reverseOrder());

        // Mostrar los números ordenados
        System.out.println("Números ordenados:");
        for (Integer numero : numeros) {
            System.out.println(numero);
        }

        System.out.println("Se han ordenado: " + numeros.size() + " números.");
    }

}