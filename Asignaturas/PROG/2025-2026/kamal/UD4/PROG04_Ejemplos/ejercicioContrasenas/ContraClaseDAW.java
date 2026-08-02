package ejercicioContrasenas;

public class ContraClaseDAW {
	
public static int numContra=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String  mayusculas = "ASDFGHJKLÑ";
		final String minusculas = "asdfghjklñ";
		final String numeros = "1234567890";
		final String simbolos ="!@#$%^&*";
		String c1;
		for(int i =0;i<10;i++) {
			c1 = generarContrasena(mayusculas, minusculas, numeros, simbolos);
			System.out.println(c1);
		}
		
		System.out.println("Contraseñas generadas: " + numContra);
	}
	
	//Genera una longitud aleatoria múltiplo de 4, entre 8 y 32.  (2 - 8)
	public static int generarLongitud() {
		return (int)(Math.random()*7 +2)*4;  
	
	}
	//Devuelve un carácter aleatorio según el tipo ("mayuscula", "minuscula", "numero", "simbolo").
	public static char generarCaracterAleatorio(String tipo) {
		int v = (int)(Math.random()*tipo.length());
		
		return tipo.charAt(v);
	}
	//La longitud debe ser múltiplo de 4, entre 8 y 32
	//1 letra mayúscula (A-Z), 1 letra minúscula (a-z), 1 número (0-9) y	1 símbolo especial (!@#$%^&*)
	//El primer y último carácter deben ser iguales.
	public static String generarContrasena(String mayusculas, String minusculas, String numeros, String simbolos) {
		int longitud =  generarLongitud();
		char primero=' ';
		StringBuilder sb = new StringBuilder();
		primero = generarCaracterAleatorio(mayusculas);
		sb.append(primero);
		sb.append(generarCaracterAleatorio(minusculas));
		sb.append(generarCaracterAleatorio(numeros));
		sb.append(generarCaracterAleatorio(simbolos));
		for(int i = 4;i<longitud-1;i++) {
			//generar aleatorio entre 0 y 3 
			
			sb.append(generarCaracterAleatorio(minusculas));
			
		}
	
		
		sb.append(primero);
		
		numContra++;
		return sb.toString();
	}
	

}
