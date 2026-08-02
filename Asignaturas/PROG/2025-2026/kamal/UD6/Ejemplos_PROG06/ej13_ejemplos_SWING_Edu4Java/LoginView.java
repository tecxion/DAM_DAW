package ej13_ejemplos_SWING_Edu4Java;

//Importación de las clases necesarias para crear una interfaz gráfica con Swing
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView {

	public static void main(String[] args) {
		// Crear la ventana principal (JFrame)
		JFrame frame = new JFrame("Demo application"); // Título de la ventana
		frame.setSize(300, 150); // Tamaño de la ventana
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana

		// Crear un panel para contener los elementos gráficos
		JPanel panel = new JPanel();
		frame.add(panel); // Añadir el panel a la ventana
		placeComponents(panel); // Método que coloca los componentes en el panel

		//La venta se mostrará en el centro de la pantalla
		frame.setLocationRelativeTo(null);
		//venta redimensionable
		frame.setResizable(true);
		// Hacer visible la ventana
		frame.setVisible(true);
	}

	// Método que organiza y coloca los componentes dentro del panel
	private static void placeComponents(JPanel panel) {

		panel.setLayout(null); // Se desactiva el layout por defecto para colocar manualmente los elementos

		// Etiqueta para "User"
		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25); // Posición y tamaño
		panel.add(userLabel); // Añadir etiqueta al panel

		// Campo de texto para el usuario
		JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		// Etiqueta para "Password"
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		// Campo de contraseña (texto oculto)
		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		// Botón de login
		JButton loginButton = new JButton("login");
		loginButton.setBounds(10, 80, 80, 25);
		panel.add(loginButton);

		// Botón de registro
		JButton registerButton = new JButton("register");
		registerButton.setBounds(180, 80, 80, 25);
		panel.add(registerButton);
	}
}
