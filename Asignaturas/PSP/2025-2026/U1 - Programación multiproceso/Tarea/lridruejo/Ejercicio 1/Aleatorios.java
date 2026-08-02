import java.util.Random;

public class Aleatorios {

    public static void main(String[] args) {

        Random random = new Random();

        // Determinar la cantidad de números que se van a generar (entre 10 y 35)
        int cantidad = random.nextInt(26) + 10; // Números entre 10 y 35 = 26 + 10 - 1

        for (int i = 0; i < cantidad; i++) {
            System.out.println(random.nextInt(1001));
        }
    }

}