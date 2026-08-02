import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

/**
 * Ejemplo de creación de XML usando DOM
 * Crea un documento XML desde cero y lo guarda en archivo
 */
public class DomXmlCreator {
    
    public static void main(String[] args) {
        try {
            // 1. Crear DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // 2. Crear documento vacío
            Document document = builder.newDocument();
            
            // 3. Crear elemento raíz
            Element escuela = document.createElement("escuela");
            document.appendChild(escuela);
            
            // 4. Crear primer alumno
            Element alumno1 = createAlumno(document, "1", "Juan", "Pérez", "18", "8.5");
            escuela.appendChild(alumno1);
            
            // 5. Crear segundo alumno
            Element alumno2 = createAlumno(document, "2", "María", "Gómez", "17", "9.2");
            escuela.appendChild(alumno2);
            
            // 6. Crear tercer alumno
            Element alumno3 = createAlumno(document, "3", "Carlos", "López", "19", "7.8");
            escuela.appendChild(alumno3);
            
            // 7. Guardar documento en archivo
            saveDocumentToFile(document, "escuela_nueva.xml");
            
            System.out.println("Archivo XML creado exitosamente");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Método para crear la estructura de un alumno
     */
    private static Element createAlumno(Document doc, String id, String nombre, 
                                      String apellido, String edad, String nota) {
        Element alumno = doc.createElement("alumno");
        alumno.setAttribute("id", id);
        
        alumno.appendChild(createElement(doc, "nombre", nombre));
        alumno.appendChild(createElement(doc, "apellido", apellido));
        alumno.appendChild(createElement(doc, "edad", edad));
        alumno.appendChild(createElement(doc, "nota", nota));
        
        return alumno;
    }
    
    /**
     * Método para crear un elemento con texto
     */
    private static Element createElement(Document doc, String tagName, String textContent) {
        Element element = doc.createElement(tagName);
        element.appendChild(doc.createTextNode(textContent));
        return element;
    }
    
    /**
     * Método para guardar el documento en archivo
     */
    private static void saveDocumentToFile(Document doc, String filename) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        
        // Configurar formato de salida
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        
        // Crear fuente y resultado
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filename));
        
        // Transformar y guardar
        transformer.transform(source, result);
    }
}