package ej11_Serializacion;

import java.io.Serializable;

public class Alumno implements Serializable {
	static int numAlumnos=0;
	private int id;
	private String dni;
    private String nombre;
    private double nota;

    public Alumno(String nombre, String dni, double nota) {
    	this.id = numAlumnos++;
    	this.dni = dni;
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }
    
    public String getDNI() {
    	return dni;
    }
    
    public static int getNumAlumnos() {
    	return numAlumnos;
    }
    
    
    @Override
    public String toString() {
        return id + " " + dni + " "+ nombre + " - " + nota;
    }
}
