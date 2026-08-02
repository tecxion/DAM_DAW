package ej13_ejemplos_SWING_Edu4Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginViewGridLayoutListener {

    public static void main(String[] args) {
        // Crear ventana
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 180);
        frame.setLocationRelativeTo(null); // Centrada

        // Crear panel con GridLayout
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

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
        panel.add(new JLabel());
        panel.add(new JLabel());

        // Añadir funcionalidad a los botones

        // Listener común para mostrar datos del formulario
        ActionListener mostrarDatosListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = userText.getText();
                String contrasena = new String(passwordText.getPassword());
                String botonPulsado = e.getActionCommand();

                JOptionPane.showMessageDialog(frame,
                        "Botón pulsado: " + botonPulsado +
                        "\nUsuario: " + usuario +
                        "\nContraseña: " + contrasena);
            }
        };

        // Asignar oyente a ambos botones
        loginButton.addActionListener(mostrarDatosListener);
        registerButton.addActionListener(mostrarDatosListener);

        // Mostrar la ventana
        frame.add(panel);
        frame.setVisible(true);
    }
}
