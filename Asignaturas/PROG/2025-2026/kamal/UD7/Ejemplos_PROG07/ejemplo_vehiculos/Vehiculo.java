package ejemplo_vehiculos;
public abstract class Vehiculo implements Imprimible {

	protected String marca;
	protected String modelo;
	protected double velocidadMaxima;
	
	
	
	public Vehiculo() {
		super();
		this.marca ="Sin marca";
		this.modelo ="Sin modelo";
		this.velocidadMaxima = 0.0;
	}

	public Vehiculo( String marca, String modelo,double velocidadMaxima ) {
		
		this.marca = marca;
		this.modelo = modelo;
		this.velocidadMaxima = velocidadMaxima;
		
	}
	
	protected void arrancar() {
		System.out.println("El vehículo arranca");
		
	}
	
	protected void mostrarInformacion() {
		
		System.out.print("Marca: " + marca + " Modelo: " + modelo + " Velocidad Máxima: " + velocidadMaxima);	
	}
	
	
	protected abstract double calcularAutonomia(); 

	public void imprimirDatos(){
		System.out.print("Imprimir datos " );
		
		
	}
	
}
