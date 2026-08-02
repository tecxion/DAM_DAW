package ej12_ejemplos_SWING;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui22 extends JFrame{
	private static final long serialVersionUID = 1L;
	//Container panel;
	JTextField jtfNum1, jtfNum2, jtfResult;
	JMenuItem jmiSuma, jmiResta, jmiMul, jmiDiv, jmiCerrar;

public Gui22() {
	super("Menús");
	JMenuBar jmb = new JMenuBar(); //barra de menús
	setJMenuBar(jmb); 
	JMenu operationMenu = new JMenu("Operación");
	operationMenu.setMnemonic('O'); // Letra distinguida
	jmb.add(operationMenu);
	operationMenu.add(jmiSuma = new JMenuItem("Suma", 'S'));
	operationMenu.add(jmiResta = new JMenuItem("Resta", 'R'));
	operationMenu.add(jmiMul = new JMenuItem("Multiplica",'M'));
	operationMenu.add(jmiDiv = new JMenuItem("Divide", 'D'));

	JMenu exitMenu = new JMenu("Salir");
	jmb.add(exitMenu);
	exitMenu.add(jmiCerrar = new JMenuItem("Cerrar", 'C'));

	JPanel p1 = new JPanel();
	p1.setLayout(new FlowLayout());
	p1.add(new JLabel("Número 1"));
	p1.add(jtfNum1 = new JTextField(3));
	p1.add(new JLabel("Número 2"));
	p1.add(jtfNum2 = new JTextField(3));
	p1.add(new JLabel("Resultado"));
	p1.add(jtfResult = new JTextField(4));
	
	jtfResult.setEditable(false);
	
	getContentPane().setLayout(new BorderLayout());
	getContentPane().add(p1, BorderLayout.CENTER);

	// Registramos oyentes
	jmiSuma.addActionListener(new OyenteMenu());
	jmiResta.addActionListener(new OyenteMenu());
	jmiMul.addActionListener(new OyenteMenu());
	jmiDiv.addActionListener(new OyenteMenu());
	
	jmiCerrar.addActionListener(new OyenteMenu());
}

public static void main(String args[]) {
	Gui22 ventana = new Gui22();
	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ventana.pack();
	ventana.setLocationRelativeTo(null);
	ventana.setVisible(true);
}

private void calculate(char operator) {
	double num1 = (Double.parseDouble(jtfNum1.getText().trim()));
	double num2 = (Double.parseDouble(jtfNum2.getText().trim()));
	double result = 0;
	switch (operator) {
		case '+': result = num1 + num2; break;
		case '-': result = num1 - num2; break;
		case '*': result = num1 * num2; break;
		case '/': result = num1 / num2;
	}
	jtfResult.setText(String.valueOf(result));

}
class OyenteMenu implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(e.getSource() instanceof JMenuItem) {
			if("Suma".equals(actionCommand)) calculate('+');
			else if("Resta".equals(actionCommand)) calculate('-');
			else if("Multiplica".equals(actionCommand)) calculate('*');
			else if("Divide".equals(actionCommand)) calculate('/');
			else if("Cerrar".equals(actionCommand)) System.exit(0);
		}
	}
}

}