package ej11_Serializacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AlmacenAlumnos {

	
	
//Atributos 
	private List<Alumno> alumnos; //lista de alumnos
	private Map<String, Alumno> indicePorDni; //Permite buscar un Alumno por DNI

	//Constructor:
		//Inicializa el ArrayList y el HashMap vacíos.
	public AlmacenAlumnos() {
		this.alumnos = new ArrayList<>();
        this.indicePorDni = new HashMap<>();
	}
	
	
	//Métodos
	
	//metodo para cargar datos del fichero
	public void cargar(String ruta) {
	    // 1) Vaciar estructuras actuales
	    alumnos.clear();
	    indicePorDni.clear();

	    // 2) Recuperar lista desde fichero
	    Fichero_ArrayList.recuperar(alumnos, ruta);

	    // 3) Reconstruir el índice (mapa) a partir de la lista
	    for (Alumno a : alumnos) {
	        if (a == null) continue;
	        String dni = a.getDNI();
	        if (dni == null || dni.trim().isEmpty()) continue;

	        dni = dni.trim();

	        // Si en el fichero hay DNIs duplicados, ignoramos los repetidos
	        if (!indicePorDni.containsKey(dni)) {
	            indicePorDni.put(dni, a);
	        }
	    }
	}
	//metodo para guardar datos en el fichero
	public void guardar(String ruta) {
	    // Guardamos la lista (fuente de verdad)
	    Fichero_ArrayList.grabar(alumnos, ruta);
	}
	
	public boolean altaAlumno(Alumno a) {
		 if (a == null) return false;

	        String dni = a.getDNI();
	        if (dni == null) return false;

	        dni = dni.trim();
	        if (dni.isEmpty()) return false;
	        
	        if (indicePorDni.containsKey(dni)) {
	            return false; // código duplicado
	        }
	        
	        alumnos.add(a);
	    
	        indicePorDni.put(dni, a);
	        return true;
	}
	
	
	

	//Devuelve el alumno o null si no existe.
	public Alumno buscarPorDni(String dni) {
		 if (dni == null) return null;
		 
	     return indicePorDni.get(dni);
	}
	
	//Recorre el array y muestra los alumnos existentes con toString().
	public void listarAlumnos() {
		if (alumnos.size() == 0) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(alumnos.get(i));
        }
	}
	
	//Calcula la media de notas de todos los alumnos.
	public double mediaNotas() {
		if (alumnos.size() == 0) return 0;

        double suma = 0;
        for (int i = 0; i < alumnos.size(); i++) {
        	suma += alumnos.get(i).getNota();
        }
            
        return suma / alumnos.size();
	}
	
	//Devuelve el alumno con mayor nota (si no hay alumnos, null).
	public Alumno alummnoMasNota() {
		if (alumnos.size() == 0) return null;

        Alumno max = alumnos.get(0);
        for (int i = 1; i < alumnos.size(); i++) {
            if (alumnos.get(i).getNota() > max.getNota()) {
                max = alumnos.get(i);
            }
        }
        return max;
    }
	//Devuelve el alumno con mayor nota (si no hay alumnos, null).
		public Alumno alummnoMasNota2() {
			if (alumnos.size() == 0) return null;
				
			Alumno mejor = Collections.max(
			        alumnos,
			        Comparator.comparingDouble(Alumno::getNota)
			);
	        return mejor;
	    }
}


