package ej07_List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionNotas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Double> notas = new ArrayList<>();

        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Añadir nota");
            System.out.println("2. Eliminar nota");
            System.out.println("3. Mostrar notas");
            System.out.println("4. Mostrar media");
            System.out.println("5. Salir");
            System.out.print("Elige opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Introduce nota (0-10): ");
                    double nota = sc.nextDouble();

                    if (nota >= 0 && nota <= 10) {
                        notas.add(nota);
                        System.out.println("Nota añadida.");
                    } else {
                        System.out.println("Nota no válida.");
                    }
                    break;

                case 2:
                    System.out.print("Introduce nota a eliminar: ");
                    double eliminar = sc.nextDouble();

                    if (notas.remove(Double.valueOf(eliminar))) {
                        System.out.println("Nota eliminada.");
                    } else {
                        System.out.println("La nota no existe.");
                    }
                    break;

                case 3:
                    if (notas.isEmpty()) {
                        System.out.println("No hay notas.");
                    } else {
                        System.out.println("Notas: " + notas);
                    }
                    break;

                case 4:
                    if (notas.isEmpty()) {
                        System.out.println("No hay notas para calcular media.");
                    } else {
                        double suma = 0;
                        for (double n : notas) {
                            suma += n;
                        }
                        System.out.println("Media: " + (suma / notas.size()));
                    }
                    break;

                case 5:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        sc.close();
    }
}
