package ej13_ejemplos_SWING_Edu4Java;
import javax.swing.*;
import java.awt.*;

public class LoginViewGridLayout {

    public static void main(String[] args) {
        // Crear ventana
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 180);
        frame.setLocationRelativeTo(null); // Centrada

        // Crear panel con GridLayout
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10)); // 4 filas, 2 columnas, espacio entre elementos
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Márgenes

        // Componentes
        JLabel userLabel = new JLabel("Usuario:");
        JTextField userText = new JTextField();

        JLabel passwordLabel = new JLabel("Contraseña:");
        JPasswordField passwordText = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Registro");

        // Añadir componentes al panel
        panel.add(userLabel);
        panel.add(userText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(loginButton);
        panel.add(registerButton);

        // Espacios vacíos para alinear mejor los botones
        panel.add(new JLabel()); 
        panel.add(new JLabel());

        // Añadir panel al frame y mostrar
        frame.add(panel);
        frame.setVisible(true);
    }
}
