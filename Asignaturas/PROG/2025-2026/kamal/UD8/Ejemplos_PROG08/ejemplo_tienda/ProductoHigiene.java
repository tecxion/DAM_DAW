package ejemplo_tienda_mio;

public class ProductoHigiene extends Producto {
	private boolean usoProfesional;

	public ProductoHigiene(String nombre, double precio, boolean usoProfesional) {
		super(nombre, precio);
		// TODO Auto-generated constructor stub
		this.usoProfesional = usoProfesional;
	}

	public boolean isUsoProfesional() {
		return usoProfesional;
	}

	public void setUsoProfesional(boolean usoProfesional) {
		this.usoProfesional = usoProfesional;
	}
	
	@Override
	public double calcularPrecioFinal() {
		if(usoProfesional)
			return precio * 1.15;
		
		return precio;
	}
	@Override
	public String mostrarInformacion() {
		StringBuilder sb = new StringBuilder();
		sb.append("Producto de higiene. ");
		sb.append(" Nombre: "+nombre);
		sb.append(" Precio base: " + String.format("%.2f", precio)); 
		if(usoProfesional)
			sb.append(" Es un producto de uso profesional");
		else
			sb.append(" No es un producto de uso profesional");
		sb.append(" Precio: "+String.format("%.2f", calcularPrecioFinal()));
		return sb.toString();
		
	}

	public void mostrar(){
		System.out.println(mostrarInformacion());
	}
	
}
