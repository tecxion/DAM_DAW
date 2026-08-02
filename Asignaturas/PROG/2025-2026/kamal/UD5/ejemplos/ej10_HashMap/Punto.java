package ej10_HashMap;

import java.text.DecimalFormat;

/**
 *
 * Ejemplo de clase Punto
 */

class Punto {
    // Atributos
    private int x,y;

    public Punto() {
    super();	    	
    }
    public Punto(int x, int y) {
    	super();
    	this.x = x;
    	this.y = y;
    }
    // Métodos
    int obtenerX () { return x; }
    int obtenerY()  {return y;}
    void establecerX (int vx) { x= vx; };
    void establecerY (int vy) { y= vy; };

	    public double distanciaCentro() {
	    	//return  Math.sqrt(x^2 + y^2); ERROR es el operador  lógico xor
	    	 //return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	    	return  Math.sqrt(x*x + y*y);  
	    }
   
    public String toString() {
    	DecimalFormat formato = new DecimalFormat("0.00");
    	String cadena = "El punto de coordendadas ("+x+","+y +")";
    	cadena += " tiene una distancia al origen de " + formato.format(distanciaCentro());
  
    	return cadena;
    }
    

}