package ejercicioContrasenas;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String [] contrasenas = new String[10];
				//	System.out.println(GeneradorContrasena.generarLongitud());
				String c;	
				//System.out.println(GeneradorContrasena.generarCaracterAleatorio("MAYUSCULAS"));
				c = GeneradorContrasena.generarContrasena();
				System.out.println(c);
				String[] cadenas = c.split("-");
				System.out.print(String.join(" ", cadenas));
				
				System.out.println(GeneradorContrasena.generarContrasena());
				
				for (int i =0; i<contrasenas.length;i++) {
					contrasenas[i] = GeneradorContrasena.generarContrasena();
					
				}
				
				for (int i =0; i<contrasenas.length;i++) {
					System.out.println(contrasenas[i]);
				}
				System.out.println("Número de contraseñas generadas: " + GeneradorContrasena.contGeneradas);
		
	}

}
