package tarea_25_26;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Empresa empresa = new Empresa();
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(sc, "Elige una opción: ");

            switch (opcion) {
                case 1:
                    registrarEmpleado(sc, empresa);
                    break;
                case 2:
                    empresa.imprimirDetallesEmpleados();
                    break;
                case 3:
                    buscarEmpleado(sc, empresa);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 4);

        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n=== GESTIÓN DE EMPLEADOS ===");
        System.out.println("1. Registrar empleado");
        System.out.println("2. Mostrar detalles de empleados");
        System.out.println("3. Buscar empleado por nombre");
        System.out.println("4. Salir");
    }

    public static void registrarEmpleado(Scanner sc, Empresa empresa) {
        System.out.println("\nTipo de empleado:");
        System.out.println("1. Socio");
        System.out.println("2. GeneralManager");
        System.out.println("3. Manager");
        System.out.println("4. DesarrolladorSenior");
        System.out.println("5. DesarrolladorJunior");

        int tipo = leerEntero(sc, "Selecciona el tipo: ");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();

        int edad = leerEdadValida(sc);
        double salarioBase = leerSalarioBaseValido(sc);

        Empleado empleado = null;

        switch (tipo) {
            case 1:
                int stockOptions = leerEnteroNoNegativo(sc, "Stock options: ");
                empleado = new Socio(nombre, edad, salarioBase, stockOptions);
                break;
            case 2:
                double bonoGM = leerDoubleNoNegativo(sc, "Bono: ");
                empleado = new GeneralManager(nombre, edad, salarioBase, bonoGM);
                break;
            case 3:
                double bonoM = leerDoubleNoNegativo(sc, "Bono: ");
                empleado = new Manager(nombre, edad, salarioBase, bonoM);
                break;
            case 4:
                int horasTrabajadas = leerEnteroNoNegativo(sc, "Horas trabajadas: ");
                empleado = new DesarrolladorSenior(nombre, edad, salarioBase, horasTrabajadas);
                break;
            case 5:
                int horasExtras = leerEnteroNoNegativo(sc, "Horas extra: ");
                empleado = new DesarrolladorJunior(nombre, edad, salarioBase, horasExtras);
                break;
            default:
                System.out.println("Tipo de empleado no válido.");
                return;
        }

        if (empresa.agregarEmpleado(empleado)) {
            System.out.println("Empleado registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el empleado.");
        }
    }

    public static void buscarEmpleado(Scanner sc, Empresa empresa) {
        System.out.print("Introduce el nombre del empleado: ");
        String nombre = sc.nextLine().trim();

        Empleado e = empresa.buscarEmpleado(nombre);

        if (e != null) {
            e.imprimirDetalles();
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número entero válido.");
            }
        }
    }

    public static int leerEdadValida(Scanner sc) {
        int edad;
        do {
            edad = leerEntero(sc, "Edad (>=16): ");
            if (edad < 16) {
                System.out.println("La edad debe ser mayor o igual que 16.");
            }
        } while (edad < 16);
        return edad;
    }

    public static int leerEnteroNoNegativo(Scanner sc, String mensaje) {
        int valor;
        do {
            valor = leerEntero(sc, mensaje);
            if (valor < 0) {
                System.out.println("El valor no puede ser negativo.");
            }
        } while (valor < 0);
        return valor;
    }

    public static double leerDouble(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número válido.");
            }
        }
    }

    public static double leerSalarioBaseValido(Scanner sc) {
        double salarioBase;
        do {
            salarioBase = leerDouble(sc, "Salario base (>0): ");
            if (salarioBase <= 0) {
                System.out.println("El salario base debe ser mayor que 0.");
            }
        } while (salarioBase <= 0);
        return salarioBase;
    }

    public static double leerDoubleNoNegativo(Scanner sc, String mensaje) {
        double valor;
        do {
            valor = leerDouble(sc, mensaje);
            if (valor < 0) {
                System.out.println("El valor no puede ser negativo.");
            }
        } while (valor < 0);
        return valor;
    }
}