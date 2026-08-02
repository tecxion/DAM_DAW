package ej10_Aleatorios;
import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("Hola Mundo");
		Random rc = new Random();
		int alea;
		for (int i=1; i<20; i++) {
			
			alea = rc.nextInt(9) + 1;
			System.out.print(alea + " ");
		}
		System.out.println();
		for (int i=1; i<20; i++) {
			alea = (int) (Math.random()*9)+1;
			System.out.print(alea+ " ");
		}
	}

}
