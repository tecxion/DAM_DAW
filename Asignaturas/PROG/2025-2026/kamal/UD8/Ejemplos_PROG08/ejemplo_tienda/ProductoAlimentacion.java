package ejemplo_tienda_mio;

public class ProductoAlimentacion extends Producto {

	private int caducidad;

	public ProductoAlimentacion(String nombre, double precio, int caducidad) {
		super(nombre, precio);
		// TODO Auto-generated constructor stub
		this.caducidad = caducidad;
	}

	public int getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(int caducidad) {
		this.caducidad = caducidad;
	}
	@Override
	public double calcularPrecioFinal() {
		if(caducidad <=3)
			return precio * 0.9;
		else
			return precio;
	}
	@Override
	public String mostrarInformacion() {
		StringBuilder sb = new StringBuilder();
		sb.append("Producto de alimentación. ");
		sb.append(" Nombre: "+nombre);
		sb.append(" Precio base: " + String.format("%.2f", precio)); 
		sb.append(" Cadudidad en días: " + caducidad);
		sb.append(" Precio: "+ String.format("%.2f",calcularPrecioFinal()));
		return sb.toString();
		
	}

	public void mostrar(){
		System.out.println(mostrarInformacion());
	}
}
