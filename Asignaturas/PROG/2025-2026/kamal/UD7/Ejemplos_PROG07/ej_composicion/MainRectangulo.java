package ej_composicion;

public class MainRectangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Punto p1 = new Punto(2,3);
		Punto p2 = new Punto(4,5);
		Rectangulo R1 = new Rectangulo(p1, p2);
		System.out.println("Nombre " + Rectangulo.nombreFigura);
		System.out.println("Numero total de "+Rectangulo.nombreFigura +" creados " + Rectangulo.obtenerNumRectangulos());
		System.out.println("Superficie " + R1.CalcularSuperficie());
		System.out.println("Perímetro " + R1.CalcularPerimetro());
		//no modificamos el rectángulo, su vertice p2 ver constructor  public Rectangulo (Punto vertice1, Punto vertice2)
		p2.establecerX(45);
		
		System.out.println("Superficie " + R1.CalcularSuperficie());
		//System.out.print(R1);
		System.out.println("Perímetro " + R1.CalcularPerimetro());
		
		//Aquí sí que modificamos su vertice, con un método específico 
		R1.setVertice2(p2);
		System.out.println("Superficie " + R1.CalcularSuperficie());
		
		System.out.println("Perímetro " + R1.CalcularPerimetro());
	}

}
