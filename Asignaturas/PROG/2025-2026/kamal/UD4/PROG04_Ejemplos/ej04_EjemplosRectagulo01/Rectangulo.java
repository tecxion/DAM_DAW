package ej04_EjemplosRectagulo01;


/**----------------------------------------------------------------
 * Clase Rectangulo
 ----------------------------------------------------------------*/
public class Rectangulo {
    
    // Atributos de clase
    private static int numRectangulos;   			// Número total de rectángulos creados 
    public static final String nombreFigura= "Rectángulo";      //  Nombre de la clase 
    public static final double PI= 3.1416; 			// Constante PI

    // Atributos de objeto
    private String nombre; 	// Nombre del rectángulo
    public double x1, y1;   	// Vértice inferior izquierdo
    public double x2, y2;   	// Vértice superior derecho


    // Método obtenerNombre
    public String obtenerNombre () {
        return nombre;
    }

    // Método establecerNombre
    public void establecerNombre (String nom) {
        nombre= nom;
    }

    // Método CalcularSuperficie
    public double CalcularSuperficie () {
        double area, base, altura;

        // Cálculo de la base
        base= x2-x1;

        // Cálculo de la altura
        altura= y2-y1;

        // Cálculo del área   
        area= base * altura;

        // Devolución del valor de retorno
        return area;
    }

    // Método CalcularPerimetro
    public double CalcularPerimetro () {
        double perimetro, base, altura;

        // Cálculo de la base
        base= x2-x1;

        // Cálculo de la altura
        altura= y2-y1;

        // Cálculo del perímetro   
        perimetro= 2*base + 2*altura;

        // Devolución del valor de retorno
        return perimetro;
    }

    // Método desplazar
    public void desplazar (double X, double Y) {

        // Desplazamiento en el eje X
        x1= x1 + X;
        x2= x2 + X;

        // Desplazamiento en el eje X
        y1= y1 + Y;
        y2= y2 + Y;

    }

    // Método obtenerNumRectangulos
    public static int obtenerNumRectangulos () {
        return numRectangulos;
    }


}


