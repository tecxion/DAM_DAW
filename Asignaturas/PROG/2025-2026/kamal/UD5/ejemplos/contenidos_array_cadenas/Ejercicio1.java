package contenidos_array_cadenas;

import java.util.Scanner;

public class Ejercicio1 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num, max_par = 0, max_impar=0;
	
		for(int i=0;i<4;i++) {
			//System.out.println("introduce un número entero positivo");
			//num = sc.nextInt();
			num = leerNumero();
			if(num %2==0) {
			
				if(num >max_par)
					max_par = num;
			}else {
				if(num >max_impar)
					max_impar = num;
			}			
		}//for
		System.out.println( max_par ==0 ? "No se han introducido números pares" : "El mayor par introducido es "+max_par    );
		System.out.println( max_impar ==0 ? "No se han introducido números impares" : "El mayor impar introducido es "+max_impar    );
	
	}//main
	
	static int leerNumero() {
		
		//String numero;
		int num;
		while(true) {
			try {
				System.out.println("introduce un número entero positivo");
				num = sc.nextInt();
				
				//num = Integer.parseInt(numero);
				if (num > 0) return num;
				else
					System.out.println("Error: el número debe ser entero positivo");
			}catch(Exception e) {
				sc.nextLine();
				System.out.println("Error: El número introducido no es correcto");
			}
		}
			
		
	}
	
	
	
	
	
	
}
