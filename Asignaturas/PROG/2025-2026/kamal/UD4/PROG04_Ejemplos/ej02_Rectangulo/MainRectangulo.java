package ej02_Rectangulo;

public class MainRectangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangulo R1 = new Rectangulo(2,3,4,5);
		System.out.println(Rectangulo.nombreFigura);
		System.out.println("Hasta ahora se han creado: "+Rectangulo.obtenerNumRectangulos() +" rectángulos");
		System.out.println("Superficie R1: "+ R1.CalcularSuperficie());
		System.out.println(R1);
	}

}
