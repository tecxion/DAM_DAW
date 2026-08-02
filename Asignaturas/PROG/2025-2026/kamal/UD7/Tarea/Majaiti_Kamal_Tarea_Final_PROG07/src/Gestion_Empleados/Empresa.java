package Gestion_Empleados;

import java.util.ArrayList;

public class Empresa {

	ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	

	public boolean agregarEmpleado(Empleado e) {
		return empleados.add(e);

	}

	public void imprimirDetallesEmpleados() {

		for (Empleado empleado : empleados) {
			empleado.imprimirDetalles();
			Utilidades.pausarInteracion();
		}

	}

	public Empleado buscarEmpleado(String Nombre) {

		for (Empleado empleado : empleados) {
			/*
			 * Si encontramos un empleado que se llame igual lo devolvemos y nada mas, lo malo que 
			 * si hay dos empleados con el mismo nombre, nunca enocntraremos el proximo empleado, solo primero que haga match... =(, la solucion es buscar por nombre y apellidos, 
			 * pero el ejercicio no lo pide.
			 */
			
			if (Nombre.equalsIgnoreCase(empleado.nombre)) {
				return empleado;
			}

		}
		return null;
	}
	


}
