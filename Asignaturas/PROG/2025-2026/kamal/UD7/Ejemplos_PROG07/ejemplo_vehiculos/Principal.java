package ejemplo_vehiculos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coche c1 = new Coche("Seat", "Panda", 178.56, 4, 56, 6.5);
		Moto m1 = new Moto("Honda", "Rápida", 267.8, false, 23.67, 3.89 );
		
		CocheElectrico ce1 = new CocheElectrico("Tesla", "Model", 178.56, 4, 60, 13);
		
		c1.abrirMaletero();
		c1.cerrarMaletero();
		c1.arrancar();
		c1.mostrarInformacion();
		System.out.println(" La autonomía actual es: " + String.format("%.2f",c1.calcularAutonomia()) +" Km ");
		
		
		m1.hacerCaballito();
		m1.arrancar();
		m1.mostrarInformacion();
		System.out.println(" La autonomía actual es: " + String.format("%.2f",m1.calcularAutonomia())+" Km ");
		
		
		ce1.abrirMaletero();
		ce1.cerrarMaletero();
		ce1.arrancar();
		ce1.mostrarInformacion();
		System.out.println(" La autonomía actual es: " + String.format("%.2f",ce1.calcularAutonomia())+" Km ");
		
		ce1.cargarBateria();
		
	}

}
