package ej14_librosGrafica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * *QUÉ ES UNA CLASE?
Las clases son la base de la programación orientada a objetos, una clase es una
 plantilla, molde o modelo para crear objetos.

Una clase está compuesta por características, propiedades o atributos (variables)
 y por su comportamiento (métodos) que trabajan sobre las propiedades.
 
 * ABSTRACCIÓN
El término abstracción consiste en ver a algo como un todo sin saber
cómo está formado internamente. Un ejemplo de abstracción en Java es una clase, 
ya que se la define como un todo.
El objetivo es que el usuario pueda crear objetos de esa clase, que utilice sus
 métodos, y que no se preocupe  por su implementación o como está diseñada.
 
 *ENCAPSULAMIENTO
Cuando se habla de encapsulamiento, hablamos de ocultar la información.
Significa que sólo se debe mostrar los detalles esenciales de un objeto,
mientras que los detalles no esenciales se deben ocultar.

El encapsulamiento en Java lo tenemos en una clase, en la que se puede ocultar
o restringir los datos (variables) o el código (métodos) utilizando palabras
reservadas del lenguaje (public, private, protected)
 
 *HERENCIA
El concepto fundamental de la herencia es el proceso en el que un objeto adquiere
 características de otro objeto.
 La herencia también ayuda a la reutilización, puesto que si ya tengo algo creado
  lo puedo reutilizar y no perder tiempo creando algo de nuevo.

En Java se maneja herencia simple, es decir que solo se puede heredar de una
 sola clase a la vez.

Para decir que una clase hereda de otra, se utiliza la palabra reservada
 extends seguido de la clase que se quiere heredar.

*POLIMORFISMO
Es la capacidad de un objeto para comportarse de diferentes  formas de acuerdo
 al mensaje enviado.
 En Java un método con el mismo nombre puede comportarse de forma diferente
  de acuerdo al objeto recibido.
 
 */


public class Inicio {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 boolean salir = false;
	     int opcion;
	     Scanner sc = new Scanner(System.in);
	     
		//array de objetos para guardar los libros
		ArrayList <Libro> libros = new  ArrayList();
		//array de objetos para guardar los clientes
		ArrayList <Cliente> clientes = new  ArrayList();
		//array de objetos para guardar las ventas
		ArrayList <Venta> ventas = new  ArrayList();		
		
		//leemos el fichero donde está guardado el ArrayList de libros
		Fichero.recuperar(libros, "src/librosGrafica/libros.dat");
		Fichero.recuperar(clientes, "src/librosGrafica/clientes.dat");
		Fichero.recuperar(ventas, "src/librosGrafica/ventas.dat");
		do{
			
	          System.out.println("1. Introducir Libro");
	          System.out.println("2. Borrar Libro");
	          System.out.println("3. Mostrar Libros");
	          System.out.println("4. Introducir Cliente");
	          System.out.println("5. Mostrar Clientes");
	          System.out.println("6. Realizar Venta");
	          System.out.println("7. Mostrar Ventas");
	          System.out.println("8. Salir ");
	          
	          try {

	              System.out.println("Elige una opción");
	              opcion = sc.nextInt();

	              switch (opcion) {
	                  case 1:
	                      introducirLibro(libros);
	                      break;
	                  case 2:
	                      borrarLibro(libros);
	                      break;
	                  case 3:
	                      mostrar(libros);
	                      break;
	                  case 4:
	                      introducirCliente(clientes);
	                      break;
	                  case 5:
	                      mostrar(clientes);
	                      break;
	                  case 6:
	                      realizarVenta(ventas, clientes, libros);
	                      break;
	                  case 7:
	                      mostrar(ventas);
	                      break;
	                  case 8:
	                      salir = true;
	                      break;
	                  default:
	                      System.out.println("Solo números entre 1 y 8");
	              }
	          } catch (InputMismatchException e) {
	              System.out.println("Debes introducir un número" + e.getMessage());
	              sc.next();
	          }
	      }while (!salir);
		Fichero.grabar(libros,"src/librosGrafica/libros.dat");
		Fichero.grabar(clientes, "src/librosGrafica/clientes.dat");
		Fichero.grabar(ventas, "src/librosGrafica/ventas.dat");
		
	}
	public static int realizarVenta(ArrayList <Venta> v, ArrayList <Cliente> c,  ArrayList <Libro> l  ) {
		Scanner sc = new Scanner(System.in);
		String letra;
		String dni;
		String isbn;
		int indiceCli=-1;
		int indiceLib=-1;
		int cantidad;
		boolean seguir;
		boolean encontradoCli;
		boolean encontradoLib;
		
		do {
			seguir=true;
			
			encontradoCli = false;
			System.out.print("Dime el DNI del cliente: ");
			dni = sc.nextLine();
			//Recorremos el ArrayList de clientes para buscar el cliente (objeto) por el DNI
			for(int i =0; i< c.size();i++)
				if(c.get(i).getDni().equals(dni)) {
					indiceCli = i;
					encontradoCli = true;
					break;
				}
			if(encontradoCli) {
				System.out.println("Hemos encontrado el cliente:  ");
				System.out.println(c.get(indiceCli));
				seguir = false;
			}else {
				System.out.println("Lo siento, no hay ningún cliente con ese DNI ");
				System.out.println("¿Quieres volver a intentarlo? introduce s, en caso contrario cualquier otro ");
				letra = sc.nextLine();
				if (!letra.equals("s")) {
					return -1;
				}
				
			}
		}while(seguir);
		
		do {
			seguir=true;
			 
			encontradoLib = false;
			System.out.print("Dime el ISBN del libro: ");
			isbn = sc.nextLine();
			//Recorremos el ArrayList de clientes para buscar el cliente (objeto) por el DNI
			for(int i =0; i< l.size();i++)
				if(l.get(i).getIsbn().equals(isbn)) {
					indiceLib = i;
					encontradoLib = true;
					break;
				}
			if(encontradoLib) {
				System.out.println("Hemos encontrado el libro:  ");
				System.out.println(l.get(indiceLib));
				seguir = false;
			}else {
				System.out.println("Lo siento, no hay ningún libro con ese ISBN ");
				System.out.println("¿Quieres volver a intentarlo? introduce s, en caso contrario cualquier otro ");
				letra = sc.nextLine();
				if (!letra.equals("s")) {
					return -1;
				}
				
			}
		}while(seguir);
		
		//Si llegamos aquí hemos encontrado el cliente y el libro para realizar la venta
		//Pedimos la cantidad
		System.out.println("Introduce la cantidad de ejemplares ");
		cantidad = sc.nextInt();
		
		//Creamos la venta
		Venta venta = new Venta(l.get(indiceLib), c.get(indiceCli), "12/02/2021", cantidad); 
		v.add(venta);
		
		
		return 1;
	}
	
	
	public static void introducirLibro(ArrayList <Libro> l) {
		Scanner sc = new Scanner(System.in);
		String isbn;
		String titulo;
		String autor;
		int	numeroPaginas;
		double precio;
		
		   System.out.print("ISBN: ");
	          isbn = sc.nextLine();          
	          System.out.print("Título: ");
	          titulo = sc.nextLine();
	          System.out.print("Autor: ");
	          autor = sc.nextLine();
	          System.out.print("Número de páginas: ");
	          numeroPaginas = sc.nextInt();
	          System.out.print("Precio: ");
	          precio = sc.nextDouble();
	          sc.nextLine(); //limpiar el intro
		Libro lib = new Libro(isbn, titulo, autor, numeroPaginas, precio );
		l.add(lib);
		
	}
	public static void introducirCliente(ArrayList <Cliente> c) {
		Scanner sc = new Scanner(System.in);
		String dni;
		String nombre;
		String apellidos;
		String direccion;
		String telefono;
		
		System.out.print("DNI: ");
        dni = sc.nextLine(); 
		System.out.print("Nombre: ");
		nombre = sc.nextLine();          
		System.out.print("Apellidos: ");
		apellidos = sc.nextLine();
		System.out.print("Dirección: ");
		direccion = sc.nextLine();
		System.out.print("Teléfono: ");
		telefono = sc.nextLine();
	          
	         
		Cliente cli = new Cliente(dni,  nombre, apellidos, direccion, telefono);
		c.add(cli);
		
	}


//Método para mostrar el contendio de los objetos de un ArrayList en pantalla	
public static void mostrar(ArrayList v) {
		
	//Recorremos el ArrayList para imprimir su contenido (método toString)
			for(int i =0; i< v.size();i++)
				System.out.println(v.get(i));
		
	}



//Método para borrar un libro	
public static void borrarLibro(ArrayList <Libro> l) {
	Scanner sc = new Scanner(System.in);
	boolean encontrado = false;
	String letra;
	int indice = -1;
	String isbn;
	System.out.println("Dime el ISBN del libro que quieres borrar");
	isbn = sc.nextLine();
	//Recorremos el ArrayList de libros para buscar el libro (objeto) por el ISBN
			for(int i =0; i< l.size();i++)
				if(l.get(i).getIsbn().equals(isbn)) {
					indice = i;
					encontrado = true;
					break;
				}
			if(encontrado) {
				
				System.out.println("Estás seguro de borrar el siguiente libro: ");
				System.out.println(l.get(indice));
				System.out.println("Introduce s para borrar y otro para cancelar");
				letra = sc.nextLine();
				if (letra.equals("s")) {
					l.remove(indice);
					System.out.println("Libro borrardo");
				}
				else
					System.out.println("Operación cancelada.");
			}
			else {
				System.out.println("Lo siento, no hay ningún libro con ese ISBN ");
			}
		
	}

}
