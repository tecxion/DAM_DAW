package ej01_Clase_Punto;

public class Circunferencia {

	public Punto centro;
	public int radio;
	
	public Circunferencia() {
		this.centro = null;
		this.radio = 0;
	}
	
	public Circunferencia(Punto centro, int radio) {
		this.centro = centro;
		this.radio = radio;
	}
	
	public Circunferencia(int x, int y, int radio) {
		this.centro = new Punto(x,y);
		this.radio = radio;
	}

	public Punto getCentro() {
		return centro;
	}

	public void setCentro(Punto centro) {
		this.centro = centro;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
	
	
	
	
}
