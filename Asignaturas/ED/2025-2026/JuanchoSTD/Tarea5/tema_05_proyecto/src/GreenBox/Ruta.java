package GreenBox;

public class Ruta {

	private ZonaGeografica zonaGeografica;
	private DiaSemana[] dias;

	public ZonaGeografica getZonaGeografica() {
		return this.zonaGeografica;
	}

	/**
	 * 
	 * @param zonaGeografica
	 */
	public void setZonaGeografica(ZonaGeografica zonaGeografica) {
		this.zonaGeografica = zonaGeografica;
	}

	public Ruta() {
		// TODO - implement Ruta.Ruta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param zonaGeografica
	 * @param dias
	 */
	public Ruta(ZonaGeografica zonaGeografica, DiaSemana dias) {
		// TODO - implement Ruta.Ruta
		throw new UnsupportedOperationException();
	}

	public DiaSemana[] getDias() {
		return this.dias;
	}

	/**
	 * 
	 * @param dias
	 */
	public void setDias(DiaSemana[] dias) {
		this.dias = dias;
	}

}