package ejemplo_anterior_clientes;


/**
 *
 * @author CIPFPD
 */
public class Cliente {

    private String nif, nombre, apellido;

    public Cliente(String nif, String nombre, String apellido) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nif=" + nif + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
    

}
