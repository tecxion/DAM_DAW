package ej08_OperacionesCadenas;


/**
 *
 * @author FMA
 */
public class ejemplocadenas {
    public static void main(String[] args)
    {
          String cad1 = "CICLO DAM";
          String cad2 = "ciclo dam";

          System.out.printf( "La cadena cad1 es: %s y cad2 es: %s", cad1,cad2 );

          System.out.printf( "\nLongitud de cad1: %d", cad1.length() );

          // concatenación de cadenas (concat o bien operador +)
          System.out.printf( "\nConcatenación: %s", cad1.concat(cad2) );

          //comparación de cadenas
          System.out.printf("\ncad1.equals(cad2) es %b", cad1.equals(cad2) );
          System.out.printf("\ncad1.equalsIgnoreCase(cad2) es %b", cad1.equalsIgnoreCase(cad2) );
          System.out.printf("\ncad1.compareTo(cad2) es %d", cad1.compareTo(cad2) );

          //obtención de subcadenas
          System.out.printf("\ncad1.substring(0,5) es %s", cad1.substring(0,5) );

          //pasar a minúsculas
          System.out.printf("\ncad1.toLowerCase() es %s", cad1.toLowerCase() );

          System.out.println();
    } // fin main

} // fin ejemplocadenas
