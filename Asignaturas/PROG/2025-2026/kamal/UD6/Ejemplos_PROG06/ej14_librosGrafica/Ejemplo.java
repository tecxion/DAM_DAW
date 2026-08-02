package ej14_librosGrafica;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
	
	
public class Ejemplo {
			//array de objetos para guardar los libros
			ArrayList <Libro> libros = new  ArrayList();
			//array de objetos para guardar los clientes
			ArrayList <Cliente> clientes = new  ArrayList();
			//array de objetos para guardar las ventas
			ArrayList <Venta> ventas = new  ArrayList();	
		
	JFrame frame = new JFrame();	
	//Container panel;
	JMenuItem nuevoLibro, borrarLibro, mostrarLibros, nuevoCliente, mostrarClientes, nuevaVenta, mostrarVentas, cerrar;
	JPanel p1 = new JPanel();
	JTextField jtfNum1, jtfNum2, jtfResult;
	JTable tabla = null;
    DefaultTableModel modelo = null;
    JScrollPane desplazamiento = null;
 
	 public void mostrarLibros(){
		 	
		libros.get(0).getIsbn();
	  		
		 	String[] columnas = {"ISBN", "Título", "Autor", "Número de Páginas", "Precio"};
	        tabla = new JTable();
	        modelo = new DefaultTableModel();
	        desplazamiento = new JScrollPane(tabla);   
	     

	        // Modelo de la tabla
	        modelo.setColumnIdentifiers(columnas);

	        // Barras de desplazamiento
	        desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

	        // Propiedades de la tabla
	        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	        tabla.setFillsViewportHeight(true);

	        tabla.setModel(modelo);
	     // Borramos todas las filas en la tabla
	        modelo.setRowCount(0);
	        
	      //Recorremos el ArrayList para imprimir su contenido (método toString)
			for(int i =0; i< libros.size();i++) {
				//System.out.println(libros.get(i));
				//Object[] datosFila = {libros.get(i).getIsbn(), libros.get(i).getTitulo(),libros.get(i).getAutor(),libros.get(i).getNumeroPaginas(), libros.get(i).getPrecio()};
				 // agregamos esos datos
		        //modelo.addRow(datosFila);
			}
	       

	        
			frame.getContentPane().setLayout(new BorderLayout());
			frame.getContentPane().add(desplazamiento, BorderLayout.CENTER);
			frame.setVisible(true);
			System.out.println("En mostrar Libros");
		
			
	}
	
	public static void main(String[] args) {
		new Ejemplo();
	}

		public Ejemplo() {
			
			
			frame.setTitle("Demo application");
			frame.setSize(600, 500);
			
		    frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			placeComponents();
			frame.setVisible(true);
		}
		
		private void placeComponents() {
			//setLayout(null);
			
			JMenuBar barraMenu = new JMenuBar();
			frame.setJMenuBar(barraMenu);
			
			JMenu menuLibros = new JMenu("Libros");
			barraMenu.add(menuLibros); // Añadimos el menú a la barra
			// Los elementos del menú 
			 
			menuLibros.add(nuevoLibro = new JMenuItem("Nuevo Libro")); // La añadimos al menú de libros
			menuLibros.add(mostrarLibros = new JMenuItem("Mostrar Libros")); 
			menuLibros.add(borrarLibro = new JMenuItem("Borrar Libro")); 
			
			JMenu menuClientes = new JMenu("Clientes");
			barraMenu.add(menuClientes); // Añadimos el menú a la barra
			// Los elementos del menú 
			 
			menuClientes.add(nuevoCliente = new JMenuItem("Nuevo Cliente")); // La añadimos al menú de libros
			menuClientes.add(mostrarClientes = new JMenuItem("Mostrar Clientes")); 
			
			JMenu menuVentas = new JMenu("Ventas");
			barraMenu.add(menuVentas); // Añadimos el menú a la barra
			// Los elementos del menú 
			 
			menuVentas.add(nuevaVenta = new JMenuItem("Nueva Venta")); // La añadimos al menú de libros
			menuVentas.add(mostrarVentas = new JMenuItem("Mostrar Ventas")); 
			
			JMenu exitMenu = new JMenu("Salir");
			barraMenu.add(exitMenu);
			exitMenu.add(cerrar = new JMenuItem("Cerrar", 'C'));
			
	  		//leemos el fichero donde está guardado el ArrayList de libros
	  		Fichero.recuperar(libros, "libros.dat");
	  		Fichero.recuperar(clientes, "clientes.dat");
	  		Fichero.recuperar(ventas, "ventas.dat");
			
			
			// Registramos oyentes
			nuevoLibro.addActionListener(new OyenteMenu());
			mostrarLibros.addActionListener(new OyenteMenu());
			borrarLibro.addActionListener(new OyenteMenu());
			nuevoCliente.addActionListener(new OyenteMenu());
			mostrarClientes.addActionListener(new OyenteMenu());
			nuevaVenta.addActionListener(new OyenteMenu());
			mostrarVentas.addActionListener(new OyenteMenu());
			cerrar.addActionListener(new OyenteMenu());
			
		/*	
			
			JLabel userLabel = new JLabel("User");
			userLabel.setBounds(10, 10, 80, 25);
			add(userLabel);

			JTextField userText = new JTextField(20);
			userText.setBounds(100, 10, 160, 25);
			add(userText);

			JLabel passwordLabel = new JLabel("Password");
			passwordLabel.setBounds(10, 40, 80, 25);
			add(passwordLabel);

			JPasswordField passwordText = new JPasswordField(20);
			passwordText.setBounds(100, 40, 160, 25);
			add(passwordText);

			JButton loginButton = new JButton("login");
			loginButton.setBounds(10, 80, 80, 25);
			add(loginButton);

			JButton registerButton = new JButton("register");
			registerButton.setBounds(180, 80, 80, 25);
			add(registerButton);

			ActionListener myButtonListener = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton source = (JButton) e.getSource();
					JOptionPane.showMessageDialog(source, source.getText() + " button has been pressed");
					
				}
			};
			loginButton.addActionListener(myButtonListener);
			
			registerButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton source = (JButton) e.getSource();
					JOptionPane.showMessageDialog(source, source.getText() + " button has been pressed");
				}
			});
		*/
	}

		class OyenteMenu implements ActionListener {
			
			public void actionPerformed(ActionEvent e) {
				String actionCommand = e.getActionCommand();
				if(e.getSource() instanceof JMenuItem) {
					if("Nuevo Libro".equals(actionCommand)) System.out.println("En nuevo libro");
					else if("Mostrar Libros".equals(actionCommand)) mostrarLibros() ;
					else if("Borrar Libro".equals(actionCommand)) ;
					else if("Nuevo Cliente".equals(actionCommand));
					else if("Mostrar Clientes".equals(actionCommand)) ;
					else if("Borrar Cliente".equals(actionCommand));
					else if("Nueva Venta".equals(actionCommand)) ;
					else if("Mostrar Ventas".equals(actionCommand));
					else if("Cerrar".equals(actionCommand)) System.exit(0);
				}
			}
			
		}
		
}


