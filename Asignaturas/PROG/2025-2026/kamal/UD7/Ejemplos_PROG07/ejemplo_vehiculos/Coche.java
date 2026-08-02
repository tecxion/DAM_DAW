package ejemplo_vehiculos;

public class Coche extends Vehiculo {

	private int numPuertas;
	private double estadoDeposito; //litros actuales del deposito
	private double consumo; //gasto de litros en 100km
	
	public Coche( String marca, String modelo,double velocidadMaxima ,  int numPuertas, double estadoDeposito,double consumo) {
		super(marca, modelo, velocidadMaxima);
		this.numPuertas = numPuertas;
		this.estadoDeposito =estadoDeposito;
		this.consumo = consumo;
	}
	
	
	public void abrirMaletero() {
		
		System.out.println("Maletero abierto");
	}
	public void cerrarMaletero() {
		
		System.out.println("Maletero cerrado");
	}
	
	@Override
	public void mostrarInformacion() {
		
		System.out.println("=== Coche === ");
		super.mostrarInformacion();
		System.out.print(" Número de puertas: " + numPuertas +"\n");
		
	}
	@Override
	public double calcularAutonomia() {
		
		return  100* estadoDeposito / consumo;
	}
}
