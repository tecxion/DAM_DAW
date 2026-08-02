

public class Bicicleta {
	static int num=0;
	private int id;
	private String marca;
	private String modelo;
	private double autonomiaMaxima; //Autonomía máxima en kilómetros con la batería al 100%.
	private double bateria; // Porcentaje actual de la batería (0–100).
	private double kmRecorridos; //Kilómetros totales recorridos por la bicicleta.
	private Propietario propietario; // Objeto de la clase Propietario. Inicialmente puede ser null.
/*
	Constructor vacío: Asigna el id automáticamente, inicializa atributos básicos marca y modelo 
	con valores predeterminados y establece la autonomía máxima a 50 km, 
	la batería a 100%, kmRecorridos a 0 y el propietario se establece como null.
*/
	public Bicicleta() {
		this.id = ++num;
		this.marca="Sin marca";
		this.modelo = "Sin modelo";
		this.autonomiaMaxima = 50;
		this.bateria = 100;
		this.kmRecorridos = 0;
		this.propietario = null;
	}
	/*
	 * Constructor parametrizado: Asigna el id automáticamente, recibe marca, modelo y autonomía máxima. 
	 * La batería comienza en 100%, los kmRecorridos en 0 y el propietario se establece como ‘null’.
	 * 
	 */
	public Bicicleta(String marca, String modelo, double autonomiaMaxima) {
		this.id = ++num;
		this.marca=marca;
		this.modelo =modelo;
		this.autonomiaMaxima = autonomiaMaxima;
		this.bateria = 100;
		this.kmRecorridos = 0;
		this.propietario = null;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getAutonomiaMaxima() {
		return autonomiaMaxima;
	}
	public void setAutonomiaMaxima(double autonomiaMaxima) {
		this.autonomiaMaxima = autonomiaMaxima;
	}
	public double getBateria() {
		return bateria;
	}
	public void setBateria(double bateria) {
		this.bateria = bateria;
	}
	public double getKmRecorridos() {
		return kmRecorridos;
	}
	public void setKmRecorridos(double kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public void setPropietario(Propietario propietario) {
		if (this.propietario==null) {
			this.propietario=propietario;
			System.out.println("Propietario asignado correctamente");
		}else {
			System.out.println("La bicicleta ya tiene propietario asignado, debe retirarse antes");
		}
	}
	public void asignarPropietario(String nombre, String dni, String telefono) {
		if (this.propietario==null) {
			Propietario p = new Propietario(nombre, dni, telefono);
			this.propietario = p;
			System.out.println("Propietario asignado correctamente");
		}else {
			System.out.println("La bicicleta ya tiene propietario asignado, debe retirarse antes");
		}
		
	}
	public int getId() {
		return id;
	}
	
	public void retirarPropietario() {
        
        if (this.propietario==null) {
			System.out.println("No hay propietario asignado");
		}else {
			this.propietario=null;
			System.out.println("Propietario eliminado correctamente");
		}
    }
	
	public double getKmMaximosPosibles() {
	    if (autonomiaMaxima <= 0) {
	        return 0; 
	    }
	    return autonomiaMaxima * (bateria / 100.0);
	}
	
	public void realizarRecorrido(double km) {
	    if (km <= 0) {
	        System.out.println("Los km deben ser positivos.");
	        return;
	    }
	    if (autonomiaMaxima <= 0) {
	        System.out.println("Autonomía máxima no válida.");
	        return;
	    }

	    double consumo = (km / autonomiaMaxima) * 100;

	    if (consumo > bateria) {
	        System.out.println("No hay batería suficiente para recorrer " + km + " km.");
	        return;
	    }

	    bateria -= consumo;
	    kmRecorridos += km;

	    System.out.println("Recorrido de " + km + " km realizado.");
	    System.out.println("Batería restante: " + String.format("%.2f", bateria) + "%");
	}

	public double getCargaMaximaPosible() {
	    // Por si la batería estuviera fuera de rango
	    double bat = Math.max(0, Math.min(bateria, 100));
	    return 100 - bat;
	}
	
	public void cargarBateria(double porcentaje) {
	    if (porcentaje <= 0) {
	        System.out.println("La carga debe ser un valor positivo.");
	        return;
	    }
	    bateria = Math.min(bateria + porcentaje, 100);
	    System.out.println("Batería cargada. Nivel actual: " + String.format("%.2f", bateria) + "%");
	}
	
	public static int getTotalBicicletas() {
		return num;
	}
	
	// Devuelve un mensaje indicando el estado de la batería
	public String comprobarBateria() {
		if (bateria > 50) {
			return "Batería suficiente";
		} else if (bateria >= 20) {
			return "Batería moderada";
		} else {
			return "Batería baja";
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Bicicleta [id= ");
		sb.append(id);
		sb.append(", marca= ");
		sb.append(marca);
		sb.append(", modelo= ");
		sb.append(modelo);
		sb.append(", autonomiaMaxima= ");
		sb.append( autonomiaMaxima);
		sb.append(", bateria= ");
		sb.append(bateria);
		sb.append(", kmRecorridos= ");
		sb.append( kmRecorridos);
		if(propietario==null)
			sb.append("\nEsta bicicleta no tiene propietario");
		else
			sb.append("\n" +propietario);
		
		return sb.toString();
	}
			
}
