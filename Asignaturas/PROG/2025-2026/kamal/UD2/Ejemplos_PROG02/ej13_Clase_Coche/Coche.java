package ej13_Clase_Coche;

public class Coche {
    // Atributos del coche (estado)
    private String marca;
    private String modelo;
    private String color;
    private int cilindrada;
    private int velocidadActual;
    private boolean encendido;

    // Constructor
    public Coche(String marca, String modelo, String color, int cilindrada) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.cilindrada = cilindrada;
        this.velocidadActual = 0;
        this.encendido = false;
    }

    // Métodos (comportamiento)
    
    // Método para arrancar el coche
    public void arrancar() {
        if (!encendido) {
            encendido = true;
            System.out.println("El coche ha arrancado.");
        } else {
            System.out.println("El coche ya está arrancado.");
        }
    }

    // Método para parar el coche
    public void parar() {
        if (encendido) {
            encendido = false;
            velocidadActual = 0;
            System.out.println("El coche se ha detenido.");
        } else {
            System.out.println("El coche ya está detenido.");
        }
    }

    // Método para acelerar el coche
    public void acelerar(int incremento) {
        if (encendido) {
            velocidadActual += incremento;
            System.out.println("El coche ha acelerado. Velocidad actual: " + velocidadActual + " km/h");
        } else {
            System.out.println("No se puede acelerar. El coche está apagado.");
        }
    }

    // Método para frenar el coche
    public void frenar(int decremento) {
        if (encendido && velocidadActual > 0) {
            velocidadActual -= decremento;
            if (velocidadActual < 0) {
                velocidadActual = 0;
            }
            System.out.println("El coche ha frenado. Velocidad actual: " + velocidadActual + " km/h");
        } else if (!encendido) {
            System.out.println("No se puede frenar. El coche está apagado.");
        } else {
            System.out.println("El coche ya está detenido.");
        }
    }

    // Métodos adicionales para mostrar información del coche
    public void mostrarInformacion() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Color: " + color);
        System.out.println("Cilindrada: " + cilindrada + " cc");
        System.out.println("Velocidad actual: " + velocidadActual + " km/h");
        System.out.println("Estado: " + (encendido ? "Encendido" : "Apagado"));
    }

    // Getters y Setters
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getVelocidadActual() {
        return velocidadActual;
    }

    public boolean isEncendido() {
        return encendido;
    }
}
