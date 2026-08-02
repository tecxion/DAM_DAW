package ej01_Clase_Punto;
import java.text.DecimalFormat;

/**
 *
 * Ejemplo de clase Punto
 */

public class Punto {

	 // Atributos
    private int x,y, id;
    
    private static int numPuntos=0;
    
    public Punto() {
    super();
      	
    id=numPuntos++;
    }
    public Punto(int x, int y) {
    	super();
    	id = numPuntos++;
    	this.x = x;
    	this.y = y;
    }
    // Métodos
    int obtenerX () { return x; }
    int obtenerY()  {return y;}
    void establecerX (int vx) { x= vx; };
    void establecerY (int vy) { y= vy; };

    public static int numeroPuntos() {
    	return numPuntos;
    }
    
    public double distanciaCentro() {
    	/*double distancia =0;
    	distancia = Math.sqrt(x^2 + y^2);*/
    	
    	return  Math.sqrt(x^2 + y^2);  
    }
    
    
    @Override
    public String toString() {
    
    	DecimalFormat formato = new DecimalFormat("0.00");
    	
    	String cadena = "El punto de coordendadas ("+x+","+y +")";
    	cadena += " tiene una distancia al origen de " + formato.format(distanciaCentro());
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append(cadena);
    	sb.append(2345.234);
    	sb.toString();
    	return cadena;
    }
 

	
	
}
