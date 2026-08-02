import java.io.Serializable;

public class CredencialesBean implements Serializable {

    // Propiedades del Bean
    private String usuario;
    private String password;
    private boolean sesionActiva;

    // Constructor sin argumentos
    public CredencialesBean() {
        usuario = "user";
        password = "pass";
        sesionActiva = false;
    }

    // Constructor parametrizado
    public CredencialesBean(String usuario, String password, boolean sesionActiva) {
        this.usuario = usuario;
        this.password = password;
        this.sesionActiva = sesionActiva;
    }

    // Getters y Setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSesionActiva() {
        return sesionActiva;
    }

    public void setSesionActiva(boolean sesionActiva) {
        this.sesionActiva = sesionActiva;
    }
}
