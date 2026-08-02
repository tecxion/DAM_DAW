package Gestion_Empleados;

public class Principal {
	private static Empresa empresa = new Empresa();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int opcion = 0;
		while (opcion != 4) {
			opcion = Principal.menuPrincipal();
		}
		System.out.println("Saliendo del programa...");
		return;
	}

	public static int menuPrincipal() {
		System.out.println(" ------ Programa de Gestion de Empleados de la Empresa FPD Rioja ------ ");
		System.out.println("A: Registrar empleado.");
		System.out.println("B: Mostrar detalles de empleados.");
		System.out.println("C: Buscar un empleado por nombre.");
		System.out.println("D: Salir.");
		System.out.print("Escoge una opcion: ");
		String opcion = Utilidades.leerStringValida("Escoge una opcion.");
		opcion = opcion.trim().toLowerCase().substring(0, 1);
		switch (opcion) {

		case "a":
		case "1":
			Principal.registrarEmpleado();
			break;

		case "b":
		case "2":
			Principal.mostrarDetallesEmpleados();
			break;

		case "c":
		case "3":
			Principal.buscarEmpleadoPorNombre();
			break;

		case "d":
		case "4":
			return 4;
			
		default: 
			System.out.println("Opcion no valida.");
			Utilidades.pausarInteracion();
			return 0;

		}
		return 0;

	}

	public static int pedirTipoEmpleado() {

		System.out.println("Dime el tipo de empleado que quieres dar de alta:");
		System.out.println("1. Socio.");
		System.out.println("2. General Manager.");
		System.out.println("3. Manager.");
		System.out.println("4. Desarrollador Senior.");
		System.out.println("5. Desarrollador Junior.");
		System.out.print("Escoge un tipo de empleado: ");
		int tipoEmpleado = Utilidades.leerInteger();

		while (tipoEmpleado == 0 || tipoEmpleado > 5) {
			System.out.println("El tipo de empleado indicado no es valido.");
			System.out.print("Escoge un tipo de empleado: ");
			tipoEmpleado = Utilidades.leerInteger();
		}
		return tipoEmpleado;
	}

	public static void registrarEmpleado() {
		int tipoEmpleado = Principal.pedirTipoEmpleado();
		System.out.print("Dime el nombre del nuevo empleado: ");
		String nombre = Utilidades.leerStringValidaSoloLetras("nombre de empleado");
		System.out.print("Dime la edad del nuevo empleado: ");
		int edad = Utilidades.leerInteger();
		while (edad < 16) {
			System.out.print("La edad del empleado no es valida.\nDime una edad valida: ");
			edad = Utilidades.leerInteger();
		}
		System.out.print("Dime el salario base del nuevo empleado: ");
		double salarioBase = Utilidades.leerDouble();
		while (salarioBase <= 0) {
			System.out.print("El salario base introducido no es valido.\nDime un salario base valido: ");
			salarioBase = Utilidades.leerDouble();
		}

		switch (tipoEmpleado) {

		// Socio

		case 1:
			System.out.print("Dime las stock options del socio: ");
			int stockOptions = Utilidades.leerInteger();
			while (stockOptions < 0) {
				System.out.print("El stock Options introducido no es valido.\nDime un stock Options valido (>0): ");
				stockOptions = Utilidades.leerInteger();
			}

			if (empresa.agregarEmpleado(new Socio(nombre, edad, salarioBase, stockOptions))) {
				System.out.println("El nuevo socio ha sido dado de alta correctamente.");
			} else {
				System.out.println("Error al dar de alta al socio.");
			}
			break;

		// General Manager
		case 2:
			if (empresa.agregarEmpleado(new GeneralManager(nombre, edad, salarioBase, pedirBono("general manager")))) {
				System.out.println("El nuevo general manager ha sido dado de alta correctamente.");
			} else {
				System.out.println("Error al dar de alta al general manager.");
			}
			break;

		// Manager
		case 3:
			if (empresa.agregarEmpleado(new Manager(nombre, edad, salarioBase, pedirBono("manager")))) {
				System.out.println("El nuevo manager ha sido dado de alta correctamente.");
			} else {
				System.out.println("Error al dar de alta al manager.");
			}
			break;

		// Desarrollador Senior
		case 4:

			if (empresa.agregarEmpleado(
					new DesarrolladorSenior(nombre, edad, salarioBase, pedirHoras("trabajadas", "desarrollador senior")))) {
				System.out.println("El nuevo desarrollador senior ha sido dado de alta correctamente.");
			} else {
				System.out.println("Error al dar de alta al desarrollador senior.");
			}
			break;

		// Desarrollador Junior
		case 5:
			if (empresa.agregarEmpleado(
					new DesarrolladorJunior(nombre, edad, salarioBase, pedirHoras("extras", "desarrollador junior")))) {
				System.out.println("El nuevo desarrollador junior ha sido dado de alta correctamente.");
			} else {
				System.out.println("Error al dar de alta al desarrollador junior.");
			}
			break;
		}

	}

	public static void mostrarDetallesEmpleados() {
		Utilidades.imprimirSubTituloPrograma("Mostrar listado de empleados");
		empresa.imprimirDetallesEmpleados();

	}

	public static void buscarEmpleadoPorNombre() {
		Utilidades.imprimirSubTituloPrograma("Buscar empleado por nombre.");
		System.out.print("Dime el nombre del empleado que buscas: ");
		String nombreEmpleado = Utilidades.leerStringValidaSoloLetras("nombre de empleado");
		Empleado empleadoBuscado = empresa.buscarEmpleado(nombreEmpleado);
		if (empleadoBuscado != null) {
			empleadoBuscado.imprimirDetalles();

		} else {
			System.out.println("No se ha encontrado el empleado con nombre: " + nombreEmpleado);

		}
		Utilidades.pausarInteracion();
	}

	public static double pedirBono(String TipoManager) {
		System.out.printf("Dime el bono del %s: ", TipoManager);
		double bono = Utilidades.leerDouble();
		while (bono < 0) {
			System.out.printf("El bono introducido del %s no es valido.\nDime un bono valido (>0): ", TipoManager);
			bono = Utilidades.leerDouble();
		}
		return bono;
	}

	public static int pedirHoras(String tipoHoras, String tipoEmpleado) {
		System.out.printf("Dime las horas %s del %s: ", tipoHoras, tipoEmpleado);
		int horas = Utilidades.leerInteger();
		while (horas < 0) {
			System.out.printf("Las horas %s indicadas del %s no son validas.\nDime las horas %s : ", tipoHoras,
					tipoEmpleado, tipoHoras);
			horas = Utilidades.leerInteger();
		}
		return horas;
	}

}
