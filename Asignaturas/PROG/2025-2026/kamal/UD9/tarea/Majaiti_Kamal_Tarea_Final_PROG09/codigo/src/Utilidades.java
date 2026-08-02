import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Utilidades para validar la informacion que se introduce.
public class Utilidades {

	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static Scanner sc = new Scanner(System.in);

	// Utilidades para validar informacion que introduce el usuario.

	// Regex para validar codigo de dispositivo.
	public static boolean validarStringNumerosYLetrasInsensibleMayus(String string) {
		// Evitamos null pointer exception..si viene nulo.
		if (string == null || string.isEmpty())
			return false;
		// Evitamos espacios al principio y al final.
		string = string.trim();
		/*
		 * Explicacion breve.. ^ indica el comienzo del String. Luego entre corchetes va
		 * el patron de caracteres aceptados es sensible a mayusculas, minusculas. +
		 * Indica minimo 1 vez. $ indica fin de String. Agrego acentos porque fallan xd:
		 * áéíóúÁÉÍÓÚñÑ Fuente:
		 * https://es.stackoverflow.com/questions/431121/como-puedo-agregarle-una-coma-a
		 * -una-expresi%C3%B3n-delimitadora-de-caracteres
		 */
		Pattern patronRegex = Pattern.compile("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]+$");
		Matcher comprobadorRegex = patronRegex.matcher(string);
		return comprobadorRegex.matches();
	}

	public static boolean validarStringSoloLetras(String string) {
		/*
		 * Explicacion breve.. ^ indica el comienzo del String. Luego entre corchetes va
		 * el patron de caracteres aceptados es sensible a mayusculas, minusculas. +
		 * Indica minimo 1 vez. $ indica fin de String. Fuente de los acentos:
		 * https://es.stackoverflow.com/questions/431121/como-puedo-agregarle-una-coma-a
		 * -una-expresi%C3%B3n-delimitadora-de-caracteres
		 */
		// Evitamos null pointer exception..si viene nulo.
		if (string == null || string.isEmpty())
			return false;
		// Evitamos espacios al principio y al final.
		string = string.trim();
		Pattern patronRegex = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$");
		Matcher comprobadorRegex = patronRegex.matcher(string);
		return comprobadorRegex.matches();
	}

	public static int leerInteger() {
		int numObtenido = 0;
		boolean lecturaIntegerValida = false;
		while (!lecturaIntegerValida) {
			try {
				numObtenido = Integer.parseInt(sc.nextLine());
				lecturaIntegerValida = true;
			} catch (Exception e) {
				System.out.println(ANSI_RED + "Error al intentar leer el valor numerico.\nError: " + e + ANSI_RESET);
				System.out.print("Dime una entrada valida [int]: ");
				lecturaIntegerValida = false;
			}
		}
		return numObtenido;
	}

	public static int leerInteger( int maximo, int minimo) {
		int numObtenido = 0;
		boolean lecturaIntegerValida = false;
		while (!lecturaIntegerValida) {
			try {
				numObtenido = Integer.parseInt(sc.nextLine());
				if (numObtenido <= maximo && numObtenido >= minimo) {
					lecturaIntegerValida = true;
				} else {
					System.out.println(ANSI_RED + "El rango elegido no es valido." + ANSI_RESET);
					System.out.print("Dime una opcion valida dentro del rango [int entre "+minimo+" y "+maximo+"] : ");
				}
				
			} catch (Exception e) {
				System.out.println(ANSI_RED + "Error al intentar leer el valor numerico.\nError: " + e + ANSI_RESET);
				System.out.print("Dime una entrada valida [int]: ");
				lecturaIntegerValida = false;
			}
		}
		return numObtenido;
	}
	
	
	public static double leerDouble() {
		double numObtenido = 0.0;
		boolean lecturaDoubleValida = false;
		while (!lecturaDoubleValida) {
			try {
				numObtenido = Double.parseDouble(sc.nextLine());
				lecturaDoubleValida = true;
			} catch (Exception e) {
				System.out.println(ANSI_RED + "Error al intentar leer el valor double.\nError: " + e + ANSI_RESET);
				System.out.print("Dime una Nº double valido [Double]: ");
				lecturaDoubleValida = false;
			}
		}
		return numObtenido;
	}

	public static void pausarInteracion() {
		System.out.print(ANSI_RED + "Pulsa intro para continuar...." + ANSI_RESET);
		sc.nextLine();
	}

	public static String leerStringValida(String complementoMensaje) {
		System.out.print("Dime el " + complementoMensaje + ": ");
		String stringLeida = sc.nextLine();
		while (Utilidades.validarStringNumerosYLetrasInsensibleMayus(stringLeida) == false) {
			System.out.println("El " + complementoMensaje + " introducido no es valido.");
			System.out.print("Dime un " + complementoMensaje + " valido [a-zA-Z0-9]: ");
			stringLeida = sc.nextLine();
		}
		return stringLeida;
	}

	public static String leerStringValidaSoloLetras(String complementoMensaje) {
		String stringLeida = sc.nextLine();
		while (Utilidades.validarStringSoloLetras(stringLeida) == false) {
			System.out.println("El " + complementoMensaje + " introducido no es valido.");
			System.out.print("Dime un " + complementoMensaje + " valido [a-zA-Z]: ");
			stringLeida = sc.nextLine();
		}
		return stringLeida;
	}

	public static void imprimirTituloPrograma() {
		System.out.println(
				ANSI_PURPLE + "------ Programa de Gestion de Peliculas de la Empresa FPD Rioja ------" + ANSI_RESET);
	}

	public static void imprimirSubTituloPrograma(String nombreSubmenu) {
		Utilidades.imprimirTituloPrograma();
		System.out.println(ANSI_PURPLE + "------ " + nombreSubmenu + " ------" + ANSI_RESET);

	}

	public static int leerAnyo() {
		int numObtenido = 0;
		System.out.print("Dime el año: ");
		boolean lecturaIntegerValida = false;
		while (!lecturaIntegerValida) {
			try {
				numObtenido = Integer.parseInt(sc.nextLine());

				/*
				 * La película más antigua del mundo que se conserva es
				 * "La escena del jardín de Roundhay" (Roundhay Garden Scene), filmada por el
				 * inventor francés Louis Le Prince el 14 de octubre de 1888.
				 * 
				 * Obtener el año:
				 * https://es.stackoverflow.com/questions/470587/c%C3%B3mo-obtener-la-fecha-actual-dd-mm-hh-mm-en-diferentes-variables-en-java
				 */

				if (numObtenido>1888 && numObtenido <= LocalDateTime.now().getYear() ) {
					lecturaIntegerValida = true;
				} else {
					System.out.println(ANSI_RED + "El año introducido no es valido, debe ser superior a 1888 e igual o menor al año actual." + ANSI_RESET);
					System.out.print("Dime una año valido [YYYY]: ");
					lecturaIntegerValida = false;
				}
					
			} catch (Exception e) {
				System.out.println(ANSI_RED + "El año introducido no es valido, debe ser superior a 1888 e igual o menor al año actual." + ANSI_RESET);
				System.out.print("Dime una año valido [YYYY]: ");
				lecturaIntegerValida = false;
			}
		}
		return numObtenido;
	}

	
	public static int leerMinutos() {
		int numObtenido = 0;
		boolean lecturaIntegerValida = false;
		System.out.print("Dime la duración en minutos: ");
		while (!lecturaIntegerValida) {
			try {
				numObtenido = Integer.parseInt(sc.nextLine());

				/*
				 * La película más antigua del mundo que se conserva es
				 * "La escena del jardín de Roundhay" (Roundhay Garden Scene), filmada por el
				 * inventor francés Louis Le Prince el 14 de octubre de 1888.
				 * 
				 * Obtener el año:
				 * https://es.stackoverflow.com/questions/470587/c%C3%B3mo-obtener-la-fecha-actual-dd-mm-hh-mm-en-diferentes-variables-en-java
				 */

				if (numObtenido>0 ) {
					lecturaIntegerValida = true;
				} else {
					System.out.println(ANSI_RED + "La duracion de la pelicula debe ser superior a 0 minutos, si limite maximo." + ANSI_RESET);
					System.out.print("Dime la duracion en minutos valida [N]: ");
					lecturaIntegerValida = false;
				}
					
			} catch (Exception e) {
				System.out.println(ANSI_RED + "La duracion de la pelicula debe ser superior a 0 minutos, si limite maximo." + ANSI_RESET);
				System.out.print("Dime la duracion en minutos valida [N]: ");
				lecturaIntegerValida = false;
			}
		}
		return numObtenido;
	}
	
}