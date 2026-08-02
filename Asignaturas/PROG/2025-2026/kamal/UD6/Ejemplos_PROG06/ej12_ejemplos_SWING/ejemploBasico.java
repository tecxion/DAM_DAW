package ej12_ejemplos_SWING;

//https://www.javatpoint.com/java-jframe

	import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;  
	import javax.swing.JFrame;  
	import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
  
	
	public class ejemploBasico extends JFrame{ 
		
		private static final long serialVersionUID = 1L;
		private  JTextField texto;
		
		
	    public ejemploBasico() {  
	        super("JFrame Examplo");  //Creación de la ventana
	       
	        JPanel panel = new JPanel();  //creación del panel
	        panel.setLayout(new FlowLayout());  //Elegimos el modo en que los elementos se añaden al panel Layout
	        
	        JLabel label = new JLabel("Dame tu edad");   //creación de una etiqueta
	        
	        texto  = new JTextField(10);
	        
	        JButton button = new JButton();  //creación de un boton
	        button.setText("Acceso");   //Ponemos el texto del botón
	        
	        button.addActionListener(new OyenteBoton());
	        
	        
	        panel.add(label);   //añadimos la etiqueta al panel
	        panel.add(texto);   //añadimos el cuadro de texto
	        panel.add(button);  //añadimos el botón al panel
	        
	        
	        add(panel);   //se ñade el panel a la ventana
	        
	        setSize(200, 300);  //se establecen las dimensiones de la ventana
	        setLocationRelativeTo(null);  //de esta forma la ventana aparce centrada en pantalla
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Finaliza la aplicación cuando se cierra la ventana
	        setVisible(true);  //así se hace visible la ventana 
	    }
	    
	    public static void main(String s[]) { 
	    	ejemploBasico ventana = new ejemploBasico();
	    }
	    
	    class OyenteBoton implements ActionListener{
	    	public void actionPerformed(ActionEvent e) {
	    		String mensaje;
	    		if(texto.getText().length()==0){
	    		     mensaje = "Debes introducir tu edad";
	    		     JOptionPane.showMessageDialog( ejemploBasico.this, mensaje);
	    		}
	    		else{
	    		    try {	
	    		    	
	    		    			
	    		    	int edad =  Integer.parseInt(texto.getText());
	    		     
			    		if(edad >= 18 ) {
			    			mensaje = "Acceso Autorizado";
			    		
			    		}else {
			    			mensaje = "Acceso No Autorizado";
			    		}
			    		JOptionPane.showMessageDialog( ejemploBasico.this, mensaje);
	    		    }catch(Exception es){
	    		    	JOptionPane.showMessageDialog(ejemploBasico.this,"error en los datos de entrada");
	    		    }
	    		}
		    		
		    	
	    }
	} 
}

