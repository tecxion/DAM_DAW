import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;

/**
 * Ejemplo de parser SAX para análisis secuencial de XML
 * Procesa el XML evento por evento sin cargar todo en memoria
 */
public class SaxParserExample extends DefaultHandler {
    
    private StringBuilder currentValue = new StringBuilder();
    private String currentElement = "";
    
    public static void main(String[] args) {
        try {
            // 1. Crear factory SAX
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            
            // 2. Crear handler personalizado
            SaxParserExample handler = new SaxParserExample();
            
            // 3. Parsear archivo XML
            File xmlFile = new File("alumnos.xml");
            saxParser.parse(xmlFile, handler);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Evento: Inicio del documento
    @Override
    public void startDocument() throws SAXException {
        System.out.println("=== INICIO DEL DOCUMENTO XML ===");
    }
    
    // Evento: Fin del documento
    @Override
    public void endDocument() throws SAXException {
        System.out.println("=== FIN DEL DOCUMENTO XML ===");
    }
    
    // Evento: Elemento de inicio
    @Override
    public void startElement(String uri, String localName, 
                           String qName, Attributes attributes) throws SAXException {
        
        currentValue.setLength(0);
        currentElement = qName;
        
        if ("alumno".equals(qName)) {
            System.out.println("\n--- NUEVO ALUMNO ---");
            String id = attributes.getValue("id");
            if (id != null) {
                System.out.println("ID: " + id);
            }
        }
    }
    
    // Evento: Elemento de fin
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        
        if ("nombre".equals(qName)) {
            System.out.println("Nombre: " + currentValue.toString());
        } else if ("apellido".equals(qName)) {
            System.out.println("Apellido: " + currentValue.toString());
        } else if ("edad".equals(qName)) {
            System.out.println("Edad: " + currentValue.toString());
        } else if ("nota".equals(qName)) {
            System.out.println("Nota: " + currentValue.toString());
        }
        
        currentElement = "";
    }
    
    // Evento: Contenido de caracteres
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue.append(ch, start, length);
    }
}