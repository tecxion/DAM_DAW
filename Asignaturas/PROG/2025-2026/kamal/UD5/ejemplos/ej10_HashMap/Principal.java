package ej10_HashMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Punto> h = new HashMap<String, Punto>();
		//Punto p1 = new Punto(2, 4);
		h.put("p1",  new Punto(2, 4));
		
		//Punto p2 = new Punto();
		h.put("p2",  new Punto());
		//Ahora, cuando queremos modificar algún punto de nuestro mapa, lo recogemos por su clave y usamos sus métodos
		Punto p2 = h.get("p2");
		p2.establecerX(3);
		p2.establecerY(7);
		//todo lo que modifico con p2 se cambia en el mapa, ya que apuntan a la misma dirección de memoria.
		
		Punto p1 = h.get("p1");
		double d1 = h.get("p1").distanciaCentro();
		System.out.printf("La distandia de p1("+p1.obtenerX()+", "+p1.obtenerY()  +") es %.2f\n", d1);
		System.out.println(p1);
		
		
		double d2 = h.get("p2").distanciaCentro();
		System.out.printf("La distandia de p2("+p2.obtenerX()+", "+p2.obtenerY()  +") es %.2f\n", d2);
		System.out.println(h.get("p2"));
		
		
		
		//p2, p3 y h.get("p2") apuntan a la misma dirección de memoria. Lo vemos con estos ejemplos:
		Punto p3 = h.get("p2");
		p3.establecerX(45);
		System.out.println(p2.obtenerX());
		System.out.println(p3.obtenerX());
		System.out.println(h.get("p2").obtenerX());
		
		h.get("p2").establecerX(-34);
		System.out.println(p2.obtenerX());
		System.out.println(p3.obtenerX());
		System.out.println(h.get("p2").obtenerX());
	
		moverPunto(h.get("p2"), 5);
		System.out.println(p2.obtenerX());
		System.out.println(p3.obtenerX());
		System.out.println(h.get("p2").obtenerX());
		
		for(Punto p : h.values())
			System.out.println(p);
		
		for(String p : h.keySet())
			System.out.println(p);

	}
	
	//este método módifica cada valor x, y de un punto sumando un valor.
	public static void moverPunto(Punto p, int desplazamiento) {
		
		p.establecerX(p.obtenerX() + desplazamiento);
		p.establecerY(p.obtenerY() + desplazamiento);
		
	}

}
