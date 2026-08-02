package ejercicioContrasenas;

public class ContraClase_Casa {
public static int numContra=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mayusculas = "ASDFGHJKLÑ";
		String minusculas = "asdfghjklñ";
		String numeros = "1234567890";
		String simbolos ="!@#$%^&*";
		
		//mayusculas.charAt(0);
		//int v = (int)(Math.random()*mayusculas.length());
		//System.out.print(v +"  " +  mayusculas.charAt(v) + "\n");
	
		//System.out.println(generarLongitud());
		//System.out.println(generarCaracterAleatorio(mayusculas));
		for(int i =0; i<10;i++)
		System.out.println(generarContrasena(mayusculas, minusculas, numeros, simbolos));
		System.out.println("Se han generado " + numContra + " Contraseñas");
		
	}
	//Genera una longitud aleatoria múltiplo de 4, entre 8 y 32.   (2 - 8 )* 4   
	public static int generarLongitud() {
		return (int)(Math.random()*7+2)*4;
		
	}
	
	//	Devuelve un carácter aleatorio según el tipo ("mayuscula", "minuscula", "numero", "simbolo").
	public static char generarCaracterAleatorio(String tipo) {
		int v = (int)(Math.random()*tipo.length());
		return tipo.charAt(v);
	}
	
	//Genera y devuelve la contraseña siguiendo las reglas establecidas.
	//La longitud debe ser múltiplo de 4, entre 8 y 32.
	// Al menos letra mayúscula (A-Z)  letra minúscula (a-z) número (0-9) símbolo especial (!@#$%^&*)
	//El primer y último carácter deben ser iguales.
	
	public static String generarContrasena(String mayus, String minus, String num, String sim){
		StringBuilder sb = new StringBuilder();
		int longitud = generarLongitud();
		char primer=' ';
		//Una de cada como mínimo 0 mayúsculas 1 minusculas 2 número y 3 símbolo
		int val;
		boolean my=false, mn = false, nm=false, sm=false;
		for(int i = 0; i<4; i++) {
			val = (int)(Math.random()*4);
			
				
			switch(val) {
			case 0:
				if(my) { 
					i--;
					continue;
				}
				if(i==0) {
					primer = generarCaracterAleatorio(mayus);
					sb.append(primer);
				}else
					sb.append(generarCaracterAleatorio(mayus));
					
				my=true;
				break;
			case 1:
				if(mn){ 
					i--;
					continue;
				}
				if(i==0) {
					primer = generarCaracterAleatorio(minus);
					sb.append(primer);
				}else
					sb.append(generarCaracterAleatorio(minus));
				
				mn=true;
				break;
			case 2:
				if(nm) { 
					i--;
					continue;
				}
				if(i==0) {
					primer = generarCaracterAleatorio(num);
					sb.append(primer);
				}else
					sb.append(generarCaracterAleatorio(num));
				
				nm=true;
				break;
			case 3:
				if(sm){ 
					i--;
					continue;
				}
				if(i==0) {
					primer = generarCaracterAleatorio(sim);
					sb.append(primer);
				}else
					sb.append(generarCaracterAleatorio(sim));
				
				sm=true;
				break;
				
			}
			
		}
		int tipo;
		for(int i = 4 ; i<longitud-1;i++) {
			if(i%4==0) {
				sb.append('-');
			}
			tipo = (int)(Math.random()*4);
			
			switch(tipo) {
			case 0:
				
				sb.append(generarCaracterAleatorio(mayus));
			
				break;
			case 1:
				
				sb.append(generarCaracterAleatorio(minus));
			
				break;
			case 2:
				
				sb.append(generarCaracterAleatorio(num));
				
				break;
			case 3:
				
				sb.append(generarCaracterAleatorio(sim));
			
				break;
				
			}
			
		}
			
		sb.append(primer);
		numContra++;
		
		return sb.toString();
		
	}

}
