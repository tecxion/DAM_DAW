package ejemplo_vehiculos;

public class CocheElectrico extends Vehiculo implements Electrico{
	private int numPuertas;
	private double capacidadBateria; //KW de la batería
	private double consumo; //gasto KW por 100km
	
	public CocheElectrico( String marca, String modelo,double velocidadMaxima ,  int numPuertas, double capacidadBateria,double consumo) {
		super(marca, modelo, velocidadMaxima);
		this.numPuertas = numPuertas;
		this.capacidadBateria =capacidadBateria;
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
		
		System.out.println("=== Coche Eléctrico === ");
		super.mostrarInformacion();
		System.out.print(" Número de puertas: " + numPuertas +"\n");
		
	}
	@Override
	public double calcularAutonomia() {
		
		return  100* capacidadBateria / consumo;
	}
	
	public void cargarBateria() {
		System.out.println("Cargando la bartería ");
		
	}
	
}
