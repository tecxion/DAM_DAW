/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej05_EjemplosRectagulo02;

/**
 *
 * @author FMA
 */
public class EjemploRectangulos2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Rectangulo r1, r2, r3;
        
        System.out.printf ("PRUEBA DE USO DE LA CLASE RECTÁNGULO\n");
        System.out.printf ("------------------------------------\n\n");
        System.out.printf ("Creando rectángulos...\n\n");
        r1= new Rectangulo ();
        r2= new Rectangulo (1,1, 3,3);
        r3= new Rectangulo (10, 5);
        
        
        System.out.printf ("Recángulo r1: \n");
        System.out.printf ("r1.x1: %4.2f\nr1.y1: %4.2f\n", r1.x1, r1.y1);
        System.out.printf ("r1.x2: %4.2f\nr1.y2: %4.2f\n", r1.x2, r1.y2);
        System.out.printf ("Perimetro: %4.2f\nSuperficie: %4.2f\n", r1.CalcularPerimetro(), r1.CalcularSuperficie());
        System.out.printf ("Recángulo r2: \n");
        System.out.printf ("r2.x1: %4.2f\nr2.y1: %4.2f\n", r2.x1, r2.y1);
        System.out.printf ("r2.x2: %4.2f\nr2.y2: %4.2f\n", r2.x2, r2.y2);
        System.out.printf ("Perimetro: %4.2f\nSuperficie: %4.2f\n", r2.CalcularPerimetro(), r2.CalcularSuperficie());
        System.out.printf ("Recángulo r3: \n");
        System.out.printf ("r3.x1: %4.2f\nr3.y1: %4.2f\n", r3.x1, r3.y1);
        System.out.printf ("r3.x2: %4.2f\nr3.y2: %4.2f\n", r3.x2, r3.y2);
        System.out.printf ("Perimetro: %4.2f\nSuperficie: %4.2f\n", r3.CalcularPerimetro(), r3.CalcularSuperficie());
    }
    
}
