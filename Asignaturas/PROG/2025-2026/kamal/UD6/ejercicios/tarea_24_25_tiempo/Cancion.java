package tarea_24_25_tiempo;

public class Cancion {

	private String titulo;
	private int duracion;
	
	private int minutos;  
	private int segundos; 
	protected Cancion(String titulo, int duracion) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		minutos = duracion/60;
		segundos = duracion%60;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
		minutos = duracion/60;
		segundos = duracion%60;
	}
	@Override
	public String toString(){
			
		
		return "{Canción " + titulo + " duración: " + minutos +" minutos " + segundos +" segundos }";
		
	}
	
}
