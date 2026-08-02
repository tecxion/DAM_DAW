package tarea_25_26;
import java.util.ArrayList;

public class Empresa {
    private ArrayList<Empleado> empleados;

    public Empresa() {
        empleados = new ArrayList<>();
    }

    public boolean agregarEmpleado(Empleado e) {
        if (e == null) {
            return false;
        }
        empleados.add(e);
        return true;
    }

    public void imprimirDetallesEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }

        for (Empleado e : empleados) {
            e.imprimirDetalles();
           
            System.out.println("---------------------------");
          
        }
    }

    public Empleado buscarEmpleado(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            return null;
        }

        for (Empleado e : empleados) {
            if (e.getNombre().equalsIgnoreCase(nombre.trim())) {
                return e;
            }
        }
        return null;
    }
}