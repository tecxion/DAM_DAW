package ejercicioContrasenas;

public class GeneradorContrasena {

	private  static final String MAYUSCULAS ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private  static final String MINUSCULAS ="abcdefghijklmnopqrstuvwxyz";
	private  static final String NUMEROS ="0123456789";
	private  static final String SIMBOLOS ="!@#$%^&*";
	public static int contGeneradas =0; 
	public static int generarLongitud() {
		
		int i = (int)(Math.random()*7+2) *4 ;  //devuelve números aleatorios enteros entre 0 y 8
		
		return i;
	}
	
	public static char generarCaracterAleatorio(String tipo) {
		char c=' ';
		int i;
		//
		//i = (int)(Math.random()*tipo.length()-1); porque Math.random() nunca generará exactamente 1.0.
		i= (int)(Math.random()*tipo.length());
		c = tipo.charAt(i);

		return c;
	}
	
	public static String generarContrasena() {
		
		String contrasena="";
		char c=' ';
		int val;
		
		int longitud = generarLongitud();
		//System.out.println("Longitud: "+ longitud+ "\n");
		int longtotal = longitud + (longitud/4 -1);
		char [] cont= new char[longtotal];
		cont[0] = generarCaracterAleatorio(MAYUSCULAS);
		char primero = cont[0];
		cont[1] = generarCaracterAleatorio(MINUSCULAS);
		cont[2] = generarCaracterAleatorio(NUMEROS);
		cont[3] = generarCaracterAleatorio(SIMBOLOS);
		int j=4;
		
		for(int i =4; i<longitud;i++) {
			val = (int)(Math.random()*4);
			switch(val) {
			case 0:
				c = generarCaracterAleatorio(MAYUSCULAS);
				break;
			
			case 1:
				c = generarCaracterAleatorio(MINUSCULAS);
				break;
			
			case 2:
					c = generarCaracterAleatorio(NUMEROS);
					break;
			case 3:
				c = generarCaracterAleatorio(SIMBOLOS);
				break;
			}
			
			if(i%4==0)
				cont[j++]='-';
			if(i==longitud-1)
				cont[j++]=primero;
			else
				cont[j++]= c;
			
			//System.out.print(c);
			
	}
			
		contGeneradas++;
		return new String(cont);
		
	}
public static String generarContrasena2() {
		//Con la clase StringBuilder
		
		StringBuilder sb = new StringBuilder();
		
		char c=' ';
		int val;
		
		int longitud = generarLongitud();
		//System.out.print("Longitud: "+ longitud+ "\n");
		
	
		char primero= generarCaracterAleatorio(MAYUSCULAS);
		sb.append(primero);
		sb.append(generarCaracterAleatorio(MINUSCULAS));
		sb.append(generarCaracterAleatorio(NUMEROS));
		sb.append(generarCaracterAleatorio(SIMBOLOS));
			
		for(int i =4; i<longitud;i++) {
			val = (int)(Math.random()*4);
			switch(val) {
			case 0:
				c = generarCaracterAleatorio(MAYUSCULAS);
				break;
			
			case 1:
				c = generarCaracterAleatorio(MINUSCULAS);
				break;
			
			case 2:
					c = generarCaracterAleatorio(NUMEROS);
					break;
			case 3:
				c = generarCaracterAleatorio(SIMBOLOS);
				break;
			}
			sb.append(c);
			
			
	}
			
		
		StringBuilder sbf = new StringBuilder();
		for(int i =0; i<sb.length();i++) {
			sbf.append(sb.charAt(i));
			
			if((i+1)%4==0 && (i + 1) != sb.length())
				sbf.append('-');
				
		}
		contGeneradas++;
		return sbf.toString();
		
	}
	
	
}
