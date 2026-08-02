package alumnos;
// Programa principal Main.java
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AlumnoDAO dao = new AlumnoDAO();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Insertar alumno");
            System.out.println("2. Modificar edad");
            System.out.println("3. Eliminar alumno");
            System.out.println("4. Mostrar alumnos");
            System.out.println("5. Salir");
            System.out.print("Elige opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("DNI: ");
                    String dni = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = Integer.parseInt(sc.nextLine());
                    dao.insertarAlumno(new Alumno(dni, nombre, edad));
                    break;
                case 2:
                    System.out.print("DNI del alumno: ");
                    dni = sc.nextLine();
                    System.out.print("Nueva edad: ");
                    edad = Integer.parseInt(sc.nextLine());
                    dao.modificarEdad(dni, edad);
                    break;
                case 3:
                    System.out.print("DNI del alumno a eliminar: ");
                    dni = sc.nextLine();
                    dao.eliminarAlumno(dni);
                    break;
                case 4:
                    List<Alumno> alumnos = dao.listarAlumnos();
                    for (Alumno a : alumnos)
                    	System.out.println(a);
                  
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        sc.close();
    }
}
