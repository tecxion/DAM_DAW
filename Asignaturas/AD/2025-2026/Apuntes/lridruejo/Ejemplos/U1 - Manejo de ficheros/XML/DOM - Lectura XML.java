import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

/**
 * Ejemplo de lectura de XML usando DOM
 * Analiza un archivo XML y extrae información estructurada
 */
public class DomParserExample {
    
    public static void main(String[] args) {
        try {
            // 1. Crear el archivo de entrada
            File xmlFile = new File("alumnos.xml");
            
            // 2. Configurar el parser DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // 3. Parsear el documento XML
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            
            // 4. Obtener el elemento raíz
            System.out.println("Elemento raíz: " + document.getDocumentElement().getNodeName());
            
            // 5. Obtener todos los elementos "alumno"
            NodeList alumnosList = document.getElementsByTagName("alumno");
            System.out.println("Número de alumnos: " + alumnosList.getLength());
            
            // 6. Recorrer cada alumno
            for (int i = 0; i < alumnosList.getLength(); i++) {
                Node alumnoNode = alumnosList.item(i);
                
                if (alumnoNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element alumnoElement = (Element) alumnoNode;
                    
                    // Extraer información del alumno
                    String id = alumnoElement.getAttribute("id");
                    String nombre = getElementValue(alumnoElement, "nombre");
                    String apellido = getElementValue(alumnoElement, "apellido");
                    String edad = getElementValue(alumnoElement, "edad");
                    String nota = getElementValue(alumnoElement, "nota");
                    
                    System.out.println("\nAlumno ID: " + id);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Apellido: " + apellido);
                    System.out.println("Edad: " + edad);
                    System.out.println("Nota: " + nota);
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Método auxiliar para obtener el valor de un elemento
     */
    private static String getElementValue(Element parent, String tagName) {
        NodeList nodeList = parent.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            return node.getTextContent();
        }
        return "";
    }
}