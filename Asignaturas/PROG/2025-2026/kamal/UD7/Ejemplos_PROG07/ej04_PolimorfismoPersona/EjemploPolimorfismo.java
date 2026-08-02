
/*
 * Ejemplo de utilización del polimorfismo y la ligadura dinámica.
 */
package ej04_PolimorfismoPersona;

import java.util.GregorianCalendar;
import java.util.Date;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 *
 * Ejemplo de utilización del polimorfismo y la ligadura dinámica.
 */
public class EjemploPolimorfismo {

    /**
     * Clase principal
     */
    public static void main(String[] args) {
        String stringContenidoUsuario;
        
        String nombre= null, apellidos= null, tipo= null;
        Persona usuario= null;
        GregorianCalendar fecha= null;
        
        // PRESENTACIÓN
        // ------------
        System.out.printf ("PRUEBA DE USO DEl POLIMORFISMO Y LA LIGADURA DINÁMICA. \n");
        System.out.printf ("------------------------------------------------------\n\n");
        
        // ENTRADA DE DATOS
        // ----------------
        // Nombre
        System.out.print("Nombre del usuario: ");    
        try {
            nombre= lecturaTeclado();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());               
        }        

        // Apellidos
        System.out.print("Apellidos del usuario: ");    
        try {
            apellidos= lecturaTeclado();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());               
        }

        // Fecha de nacimiento
        boolean fechaValida= true;
        do {
            String stringFecha= null;
            SimpleDateFormat formatoFecha= null;
            Date dateFecha= null;
            
            System.out.print("Fecha de nacimiento del usuario (formato DD/MM/AAAA): ");          
            try {
                stringFecha= lecturaTeclado();
            }
            catch (Exception e) {
                System.err.println(e.getMessage());               
            }        
            
            // Conversión del texto en fecha
            formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            try {
                dateFecha= formatoFecha.parse(stringFecha);
            } catch (ParseException e)  {
                fechaValida= false;
            }
            fecha= new GregorianCalendar ();
            fecha.setTime(dateFecha);

        } while (!fechaValida);
        
        // ¿Alumno o Profesor?
        do {
            System.out.println("¿Es alumno(A) o profesor(P)?");          
            try {
                tipo= lecturaTeclado();
            }
            catch (Exception e) {
                System.err.println(e.getMessage());               
            }        
            if (tipo.equals("P") || tipo.equals("p")) tipo="profesor";
            else if (tipo.equals("A") || tipo.equals("a")) tipo="alumno";
            else tipo="X";

        } while (tipo.equals("X"));
        
        // Creación del objeto usuario (desconocido en tiempo de compilación)
        // Sabemos que será subclase de Persona, pero no sabemos si será Alumno o Profesor
        // (dependerá de la ejecución)
        if (tipo.equals("profesor")) {
            usuario= new Profesor (nombre, apellidos, fecha);
        }     
        else if (tipo.equals("alumno")) {
            usuario=  new Alumno (nombre, apellidos, fecha);            
        } else {
            
        }
      
        // Obtención del contenido del objeto usuario a través del método devolverContenidoString.
        // El método que se va a ajecutar aún no se sabe cuál es (ligadura dinámica), pues 
        // este objeto usuario no sabemos si será Alumno o Profesor. Tan solo sabemos que será de la
        // superclase Persona. En tiempo de ejecución se sabrá de qué tipo de subclase se trata y será
        // también en ese momento cuando el entorno de ejecución pueda resolver qué método se ejecuta
        // (el de método devolverContenidoString de la clase Alumno o el de la clase Profesor)
        
        stringContenidoUsuario= usuario.devolverContenidoString();
        
        // Impresión en pantalla del contenido del objeto usuario a través de la estructura obtenida
        System.out.printf ("Contenido del objeto usuario: %s\n", stringContenidoUsuario);      
       
    }
    
    
    //---------------------------------------------------------------        
    // MÉTODO lecturaTeclado: Captura de una cadena de teclado
    //---------------------------------------------------------------      
    private static String lecturaTeclado () throws Exception {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            return line;
        }
        catch (Exception e) {
            throw e;

        }

    }
}
