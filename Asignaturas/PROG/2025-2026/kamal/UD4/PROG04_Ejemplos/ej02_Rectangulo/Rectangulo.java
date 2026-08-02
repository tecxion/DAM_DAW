/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej02_Rectangulo;

/**
 *
 * @author FMA
 */
public class Rectangulo {
    
    // Atributos de clase
    private static int numRectangulos;   			// Número total de rectángulos creados 
    public static final String nombreFigura= "Rectángulo";      //  Nombre de la clase 
    public static final double PI= 3.1416; 			// Constante PI

    // Atributos de objeto
    private String nombre; 	// Nombre del rectángulo
    public double x1, y1;   	// Vértice inferior izquierdo
    public double x2, y2;   	// Vértice superior derecho


    public Rectangulo(double x1, double y1, double x2, double y2) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		numRectangulos++;
	}

    
	public double getX1() {
		return x1;
	}


	public void setX1(double x1) {
		this.x1 = x1;
	}


	public double getY1() {
		return y1;
	}


	public void setY1(double y1) {
		this.y1 = y1;
	}


	public double getX2() {
		return x2;
	}


	public void setX2(double x2) {
		this.x2 = x2;
	}


	public double getY2() {
		return y2;
	}


	public void setY2(double y2) {
		this.y2 = y2;
	}


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


	@Override
	public String toString() {
		return "Rectangulo [nombre=" + nombre + ", x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + "]";
	}

    
    
}


