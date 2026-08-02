package ej_composicion;

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
    // M�todos
    int obtenerX () { return x; }
    int obtenerY()  {return y;}
    void establecerX (int vx) { x= vx; };
    void establecerY (int vy) { y= vy; };

    public double distanciaCentro() {
    	/*double distancia =0;
    	distancia = Math.sqrt(x^2 + y^2);*/
   
    	return  Math.sqrt(x^2 + y^2);  
    }
   
    public String toString() {
    	DecimalFormat formato = new DecimalFormat("0.00");
    	String cadena = "El punto de coordendadas ("+x+","+y +")";
    	cadena += " tiene una distancia al origen de " + formato.format(distanciaCentro());
  
    	return cadena;
    }
    

}