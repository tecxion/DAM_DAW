public class RA1b {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("El número de argumentos no es valido.");
        } else {
            try {
                double base = Double.parseDouble(args[0]);
                double altura = Double.parseDouble(args[1]);
                double area = base * altura;

                System.out.println("El área del rectángulo de base " + base + " y altura " +
                        altura + " es: " + area);
            } catch (NumberFormatException e) {
                System.err.println("El formato de los argumentos no es valido.");
            }
        }
    }
}
