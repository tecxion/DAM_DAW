/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej_composicion;

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
    //public double x1, y1;   	// Vértice inferior izquierdo
    //public double x2, y2;   	// Vértice superior derecho
    private Punto vertice1;
    private Punto vertice2;


    //Un constructor sin parámetros, las esquinas del rectángulo sean (0,0) y (1,1)
    public Rectangulo (){

    	this.vertice1= new Punto (0,0);
    	this.vertice2= new Punto (1,1);	
    	numRectangulos++;
    }
    //Un constructor con cuatro parámetros, x1, y1, x2, y2, que cree un rectángulo con los vértices (x1, y1) y (x2, y2).
    public Rectangulo (int x1, int y1, int x2, int y2){
    	this.vertice1= new Punto (x1, y1);
    	this.vertice2= new Punto (x2, y2);
    	numRectangulos++;
    }
 
    //public Rectangulo(double x1, double y1, double x2, double y2) {
   /* public Rectangulo(Punto vertice1, Punto vertice2) {
		super();
		this.nombre = nombre;
		this.vertice1 = vertice1;
		this.vertice2 = vertice2;
		
		this.numRectangulos++;
	}*/
    //mejor crear nuevos objetos vemos la utilidad de los constructores de copia a la hora de tener que clonar objetos
   public Rectangulo (Punto vertice1, Punto vertice2){

    	this.vertice1= new Punto (vertice1.obtenerX(), vertice1.obtenerY() );
    	//this.vertice1 =vertice1;
    	this.vertice2= new Punto (vertice2.obtenerX(), vertice2.obtenerY() );
    	//this.vertice2 =vertice2;
    	numRectangulos++;
}


    //Un constructor con dos parámetros, base y altura,
public Rectangulo (int base,int altura)
{

     this.vertice1= new Punto (0, 0);

     this.vertice2= new Punto (base, altura);

}


//Constructor copia

	public Rectangulo (Rectangulo r) {

		this.vertice1= new Punto (r.getVertice1().obtenerX(), r.getVertice1().obtenerY() );
		this.vertice2= new Punto (r.getVertice2().obtenerX(), r.getVertice2().obtenerY() );

	}


	public Punto getVertice1() {
		 Punto p;

	     p= new Punto (this.vertice1.obtenerX(), this.vertice1.obtenerY()); 

	     return p; 
	     //en lugar de devolver directamente return vertice1;
		
	}

	public void setVertice1(Punto vertice1) {
		this.vertice1 = vertice1;
	}

	public Punto getVertice2() {
		Punto p;

	     p= new Punto (this.vertice2.obtenerX(), this.vertice2.obtenerY()); 

	     return p; 
	}

	public void setVertice2(Punto vertice2) {
		this.vertice2 = vertice2;
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
        //base= x2 - x1;
        base= vertice2.obtenerX() - vertice1.obtenerX();

        // Cálculo de la altura
       // altura= y2-y1;
        altura =  vertice2.obtenerY() - vertice1.obtenerY();
        
        // Cálculo del área   
        area= base * altura;

        // Devolución del valor de retorno
        return area;
    }

    // Método CalcularPerimetro
    public double CalcularPerimetro () {
        double perimetro, base, altura;

        // Cálculo de la base
        //base= x2-x1;
        base= vertice2.obtenerX() - vertice1.obtenerX();
        // Cálculo de la altura
        //altura= y2-y1;
        altura =  vertice2.obtenerY() - vertice1.obtenerY();
        // Cálculo del perímetro   
        perimetro= 2*base + 2*altura;

        // Devolución del valor de retorno
        return perimetro;
    }

    // Método desplazar
    public void desplazar (int X, int Y) {

        // Desplazamiento en el eje X
        //x1= x1 + X;
    	vertice1.establecerX( vertice1.obtenerX() + X);
        //x2= x2 + X;
    	vertice2.establecerX( vertice2.obtenerX() + X);
        // Desplazamiento en el eje X
        //y1= y1 + Y;
    	vertice1.establecerY( vertice1.obtenerY() + Y);
        //y2= y2 + Y;
    	vertice2.establecerY( vertice2.obtenerY() + Y);
    }

    // Método obtenerNumRectangulos
    public static int obtenerNumRectangulos () {
        return numRectangulos;
    }

}


