package tarea_PROG04_arrays;

import java.util.Scanner;

public class Principal {
	
	static Bicicleta[] bicicletas = new Bicicleta[10]; 
	static int contador =0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		
		Bicicleta b1 = new Bicicleta();
		Bicicleta b2 = new Bicicleta();
		if(Propietario.validarDni("12345678Z"))
			b1.asignarPropietario("Juan Pérez","12345678Z", "666123456");
		else
			System.out.println("Error al asigar propietario, dni no válido");
		System.out.println("El número total de bicicletas creadas es "+ Bicicleta.getTotalBicicletas());
		
		System.out.println(b1);
		System.out.println(b2);
		
		bicicletas[contador++]=b1;
		bicicletas[contador++]=b2;
		
		int opcion = 0;
		do {
			System.out.println("Elige una opción:");
			System.out.println("0. Añadir bicicleta.");
			System.out.println("1. Asignar propietario.");
			System.out.println("2. Retirar propietario.");
			System.out.println("3. Realizar recorrido.");
			System.out.println("4. Cargar batería");
			System.out.println("5. Mostrar información");
			System.out.println("6. Salir");
			opcion = leerEntero(sc, 0, 6);
			
			switch(opcion) {
			case 0:
				anadirBicicleta(sc);
				break;
			case 1:
				asignarPropietario(sc);
					
				break;
			case 2:
				retirarPropietario(sc);
				break;
			case 3:
				Bicicleta br;
				br = elegirBicicleta(sc);
				System.out.printf("Con esa bicicleta puedes realizar un máximo de %.2f km%n", br.getKmMaximosPosibles());
				double km =  leerDouble("Kilómetros a recorrer: ", sc); 
				br.realizarRecorrido(km);
				break;
			case 4:
				Bicicleta bc;
				bc = elegirBicicleta(sc);
				System.out.printf("Esa bicicleta admite una carga máxima de %.2f%%%n", bc.getCargaMaximaPosible());
				double porc = leerDouble("Porcentaje de carga: ", sc);
				bc.cargarBateria(porc);
				break;
			case 5:
				mostrarBicicletas();
				break;
			case 6:
				System.out.println("Saliendo del programa...");
				break;
			
			}
			
		}while(opcion != 6);
		sc.close();
	}
	
	static void mostrarBicicletas() {
		for(int i=0;i<contador;i++) {
			System.out.println(bicicletas[i]);			
		}
	}
	
	static void anadirBicicleta(Scanner sc) {
		if (contador >= bicicletas.length) {
		    System.out.println("No se pueden añadir más bicicletas (máximo 10).");
		    return;
		}
		System.out.println("Vas a añadir una nueva bicicleta");
		System.out.println("Dime la marca: ");
		String marca = sc.nextLine();
		System.out.println("Dime el modelo: ");
		String modelo = sc.nextLine();
		
		double autmax = leerDouble("Dime la autonomía máxima: ", sc);
		bicicletas[contador++] = new Bicicleta(marca, modelo, autmax);
	}
	
	static int leerEntero(Scanner sc, int l1, int l2) {
		int op=0;
		while(true) {
			try {
				op = Integer.parseInt(sc.nextLine());
				if(op<l1 || op>l2 )
					System.out.println("Debes introducir un número entero entre " +l1 +" y "+ l2);
				else
					return op;
			}catch(Exception e) {
				System.out.println("Debes introducir un número entero entre " +l1 +" y "+ l2);
			}	
		}
	}
	static Bicicleta elegirBicicleta(Scanner sc) {
		if (contador == 0) {
	        System.out.println("No hay bicicletas.");
	        return null;
	    }
			
		System.out.println("las bicicleta disponibles son : ");
		mostrarBicicletas();
		
		int min = bicicletas[0].getId();
		int max = bicicletas[contador-1].getId();
		System.out.println("Elige el id de la bicicleta que deseas usar ");
		int valor = leerEntero(sc, min, max);
		
		return bicicletas[valor];
	}
	
	static void asignarPropietario(Scanner sc) {
		Bicicleta elegida;
		elegida = elegirBicicleta(sc);
		if(elegida.getPropietario() != null) {
			System.out.println("Esta Bicicleta ya tiene propietario, no se puede asignar uno");
			return;
		}else
			System.out.println("Esta Bicicleta no tiene propietario, se puede asignar uno");
		System.out.println("Introduce el nombre: ");
		String nombre = sc.nextLine();
		
		System.out.println("Introduce el teléfono: ");
		String telefono = sc.nextLine();
		String dni;
		do {
			System.out.println("Introduce el DNI: ");
			dni= sc.nextLine();
			if(!Propietario.validarDni(dni))
				System.out.println("Debes introducir un DNI válido");
		}while(!Propietario.validarDni(dni));
		elegida.asignarPropietario(nombre, dni, telefono);
		System.out.println(elegida);
	}
	
	static void retirarPropietario(Scanner sc) {
		Bicicleta elegida;
		elegida = elegirBicicleta(sc);
		if(elegida.getPropietario() == null) {
			System.out.println("Esta Bicicleta no tiene propietario, no se puede quitar propietario");
			return;
		}else
			System.out.println("Esta Bicicleta tiene propietario, se puede quitar");
		
		elegida.retirarPropietario();
		System.out.println(elegida);
	}
private static double leerDouble(String mensaje,  Scanner sc) {
        
        double valor;
        while (true) {
            try {
                System.out.print(mensaje);
                valor= Double.parseDouble(sc.nextLine());
                if(valor>0)
                    return valor;
                else
                	System.out.println("Debes introducir un número positivo.");
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número válido.");
            }
        }
    }
}