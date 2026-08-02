import javax.xml.bind.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Ejemplo completo de JAXB para marshalling y unmarshalling
 * Convierte objetos Java a XML y viceversa
 */
public class JaxbCompleteExample {
    
    private static final String XML_FILE = "biblioteca.xml";
    
    public static void main(String[] args) {
        try {
            // 1. MARSHALLING: De objetos Java a XML
            
            // Crear datos de ejemplo
            Biblioteca biblioteca = createSampleData();
            
            // Crear contexto JAXB
            JAXBContext context = JAXBContext.newInstance(Biblioteca.class);
            
            // Crear marshaller
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            // Convertir a XML y mostrar por pantalla
            System.out.println("=== XML GENERADO ===");
            marshaller.marshal(biblioteca, System.out);
            
            // Guardar en archivo
            marshaller.marshal(biblioteca, new File(XML_FILE));
            System.out.println("\nArchivo guardado: " + XML_FILE);
            
            // 2. UNMARSHALLING: De XML a objetos Java
            
            System.out.println("\n=== DATOS LEÍDOS DEL XML ===");
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Biblioteca bibliotecaLeida = (Biblioteca) unmarshaller.unmarshal(new File(XML_FILE));
            
            // Mostrar datos leídos
            displayBiblioteca(bibliotecaLeida);
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Crear datos de ejemplo para la biblioteca
     */
    private static Biblioteca createSampleData() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setNombre("Biblioteca Central");
        biblioteca.setCiudad("Madrid");
        
        // Crear libros
        ArrayList<Libro> libros = new ArrayList<>();
        
        Libro libro1 = new Libro();
        libro1.setIsbn("978-84-376-0494-7");
        libro1.setTitulo("Cien años de soledad");
        libro1.setAutor("Gabriel García Márquez");
        libro1.setAnio(1967);
        libros.add(libro1);
        
        Libro libro2 = new Libro();
        libro2.setIsbn("978-84-9759-327-8");
        libro2.setTitulo("El Quijote");
        libro2.setAutor("Miguel de Cervantes");
        libro2.setAnio(1605);
        libros.add(libro2);
        
        Libro libro3 = new Libro();
        libro3.setIsbn("978-84-206-7209-8");
        libro3.setTitulo("1984");
        libro3.setAutor("George Orwell");
        libro3.setAnio(1949);
        libros.add(libro3);
        
        biblioteca.setLibros(libros);
        return biblioteca;
    }
    
    /**
     * Mostrar información de la biblioteca
     */
    private static void displayBiblioteca(Biblioteca biblioteca) {
        System.out.println("Biblioteca: " + biblioteca.getNombre());
        System.out.println("Ciudad: " + biblioteca.getCiudad());
        System.out.println("\nLibros disponibles:");
        
        for (Libro libro : biblioteca.getLibros()) {
            System.out.println("- " + libro.getTitulo() + " (" + libro.getAutor() + 
                             ", " + libro.getAnio() + ") - ISBN: " + libro.getIsbn());
        }
    }
}

// Clases anotadas para JAXB

@javax.xml.bind.annotation.XmlRootElement
class Biblioteca {
    private String nombre;
    private String ciudad;
    private ArrayList<Libro> libros;
    
    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    
    @javax.xml.bind.annotation.XmlElementWrapper(name = "libros")
    @javax.xml.bind.annotation.XmlElement(name = "libro")
    public ArrayList<Libro> getLibros() { return libros; }
    public void setLibros(ArrayList<Libro> libros) { this.libros = libros; }
}

@javax.xml.bind.annotation.XmlType(propOrder = {"isbn", "titulo", "autor", "anio"})
class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anio;
    
    // Getters y setters
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    
    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }
}