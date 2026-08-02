package ejercicios_28_01;
/*Desarrolla un programa en Java que, dada una cantidad de dinero entera en euros, 
 * muestre el desglose mínimo de billetes y monedas necesario para representar dicha cantidad.
 * Utilizar un array con los valores de los billetes y monedas disponibles:
500, 200, 100, 50, 20, 10, 5, 2 y 1.
Calcular cuántos billetes o monedas de cada tipo son necesarios, empezando siempre por el valor más alto.
Al finalizar, el programa deberá mostrar por pantalla el número de billetes y monedas necesarios
 */
public class Desglose {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int cantidad = 345; // 200 + 100 +  20 +20 + 5
		
		int[] billetes = {500, 200, 100, 50, 20, 10, 5, 1}; 
		
		int valor;
		for(int i= 0; i<billetes.length;i++) {
			valor = cantidad /billetes[i];
			if(valor > 0) {
				if(billetes[i]>2)
					System.out.println("Son cesarios " + valor + " billetes de " + billetes[i]);
				else
					System.out.println("Son cesarias " + valor + " monedas de " + billetes[i]);
				cantidad %= billetes[i];
			}
				
		}
		if(cantidad>0)
			System.out.println("Se han quedado " + cantidad+ " sin deglosar");
		
	}

}
