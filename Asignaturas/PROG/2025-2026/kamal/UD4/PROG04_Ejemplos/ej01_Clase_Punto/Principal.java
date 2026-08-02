package ej01_Clase_Punto;
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Punto p1 = new Punto(2, 4);
		Punto p2 = new Punto();
		p2.establecerX(3);
		p2.establecerY(7);
		double d1 = p1.distanciaCentro();
		double d2 = p2.distanciaCentro();
		
		
		Circunferencia c1 = new Circunferencia();
		
		Punto pc = new Punto(3, 6);
		Circunferencia c2 = new Circunferencia(pc, 8);
		System.out.println("x: " + c2.getCentro().obtenerX());
		pc.establecerX(12);
		System.out.println("x: " + c2.getCentro().obtenerX());
		
		Circunferencia c3 = new Circunferencia(5, 7, 8);
		
		
		/*
		
		System.out.println("Se han creado " + Punto.numeroPuntos()+ " puntos");
		
		System.out.printf("La distandia de p1("+p1.obtenerX()+", "+p1.obtenerY()  +") es %.2f\n", d1);
		System.out.printf("La distandia de p2("+p2.obtenerX()+", "+p2.obtenerY()  +") es %.2f\n", d2);
		System.out.println(p1);
		*/
		
	
	}

}
