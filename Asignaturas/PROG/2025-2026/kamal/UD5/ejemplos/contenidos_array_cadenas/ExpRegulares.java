package contenidos_array_cadenas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpRegulares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String uno = "[a-z]{1,4}[0-9]+";
		String dos ="[XYxy]?[0-9]{1,9}[A-Za-z]";
		
		Pattern p = Pattern.compile(dos);
		
		Matcher m=p.matcher("123456789F");
		
		if (m.matches()) 
			System.out.println("Si, contiene el patrón");
		else 
			System.out.println("No, contiene el patrón");
	
		p=Pattern.compile("([XY]?)([0-9]{1,9})([A-Za-z])");
		 m=p.matcher("X123456789Z Y00110011M 999999T");
		 while (m.find())
		 {

		    System.out.println("Letra inicial (opcional):"+m.group(1));

		    System.out.println("Número:"+m.group(2));

		    System.out.println("Letra NIF:"+m.group(3));

		 }
		 
		 //Ejemplo para validar fechas formato dd/mm/aaa:  String regexp = "\\d{1,2}/\\d{1,2}/\\d{4}"; 
		// Lo siguiente devuelve true 
		 System.out.println("Ejemplos para fechas");
		 String regexp = "\\d{1,2}/\\d{1,2}/\\d{4}";
		 System.out.println(Pattern.matches(regexp, "11/12/2014")); 
		 
		 System.out.println(Pattern.matches(regexp, "11/12/14")); // El año no tiene cuatro cifras 
		
		 //meses con iniciales
		 //case insensitive (?i) (la 'i' es  de ignore case) 
		 String literalMonthRegexp = "(?i)\\d{1,2}/(ene|feb|mar|abr|may|jun|jul|ago|sep|oct|nov|dic)/\\d{4}";

		// Lo siguiente devuelve true 
		 System.out.println("Ejemplo fechas con meses letra");
		 System.out.println(Pattern.matches(literalMonthRegexp, "11/dic/2014")); 
		 System.out.println(Pattern.matches(literalMonthRegexp, "1/nov/2014")); 
		 System.out.println(Pattern.matches(literalMonthRegexp, "1/AGO/2014"));  // Mes en mayúsculas 

		 
		//Si se desea encontrar una fecha en una cadena más larga (en lugar de que coincida toda la cadena), 
			//se puede usar Pattern y Matcher:
		 
		 Pattern pattern = Pattern.compile(literalMonthRegexp);
	        Matcher matcher = pattern.matcher("Hoy es 11/dic/2014 y hace frío");

	        if (matcher.find()) {
	            System.out.println("Fecha encontrada: " + matcher.group());
	        } else {
	            System.out.println("No se encontró ninguna fecha válida.");
	        }
		 
		 System.out.println("Ejemplo DNI");
		// El siguiente código muestra un ejemplo completo de la expresión regular de DNI 
		 String dniRegexp = "\\d{8}[A-HJ-NP-TV-Z]"; 
		// Lo siguiente devuelve true 
		
		 System.out.println(Pattern.matches(dniRegexp, "01234567C")); 
		// Lo siguiente devuelve faslse 
		System.out.println(Pattern.matches(dniRegexp, "01234567U")); // La U no es válida 
		System.out.println(Pattern.matches(dniRegexp, "0123567X")); // No tiene 8 cifras 

				
	}
	

}
