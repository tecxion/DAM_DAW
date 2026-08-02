package ejemplo_vehiculos;

public class Moto extends Vehiculo {
	private boolean tieneSidecar;
	private double estadoDeposito; //litros actuales del deposito
	private double consumo; //gasto de litros en 100km
	
	public Moto( String marca, String modelo,double velocidadMaxima , boolean tieneSidecar, double estadoDeposito,double consumo) {
		super(marca, modelo, velocidadMaxima);
		this.tieneSidecar = tieneSidecar;
		this.estadoDeposito =estadoDeposito;
		this.consumo = consumo;
	}
	
	
	public void hacerCaballito() {
		
		System.out.println("La moto hace el caballito ");
		
	}
	
	@Override
	public void mostrarInformacion() {
		
		System.out.println("=== Moto === ");
		super.mostrarInformacion();
		if(tieneSidecar)
			System.out.print(" Tiene sidecar" );
		else
			System.out.print(" No tiene sidecar" );
	}
	@Override
	public double calcularAutonomia() {
		
		return  100* estadoDeposito / consumo;
	}
}
