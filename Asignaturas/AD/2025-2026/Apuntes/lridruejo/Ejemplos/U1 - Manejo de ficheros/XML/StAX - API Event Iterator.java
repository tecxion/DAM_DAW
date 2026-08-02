import javax.xml.stream.*;
import javax.xml.stream.events.*;
import java.io.*;
import java.util.Iterator;

/**
 * Ejemplo de StAX usando API Event Iterator (XMLEventReader)
 * Procesa el XML como una secuencia de eventos discretos
 */
public class StaxEventIteratorExample {
    
    public static void main(String[] args) {
        XMLEventReader eventReader = null;
        
        try {
            // 1. Crear XMLInputFactory
            XMLInputFactory factory = XMLInputFactory.newInstance();
            
            // 2. Crear XMLEventReader
            eventReader = factory.createXMLEventReader(new FileReader("alumnos.xml"));
            
            // 3. Variables para almacenar datos del alumno actual
            String currentAlumnoId = "";
            String currentNombre = "";
            String currentApellido = "";
            String currentEdad = "";
            String currentNota = "";
            
            // 4. Procesar cada evento
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    String elementName = startElement.getName().getLocalPart();
                    
                    switch (elementName) {
                        case "alumno":
                            // Obtener atributo ID
                            Iterator<Attribute> attributes = startElement.getAttributes();
                            while (attributes.hasNext()) {
                                Attribute attribute = attributes.next();
                                if ("id".equals(attribute.getName().getLocalPart())) {
                                    currentAlumnoId = attribute.getValue();
                                }
                            }
                            break;
                            
                        case "nombre":
                            event = eventReader.nextEvent();
                            currentNombre = event.asCharacters().getData();
                            break;
                            
                        case "apellido":
                            event = eventReader.nextEvent();
                            currentApellido = event.asCharacters().getData();
                            break;
                            
                        case "edad":
                            event = eventReader.nextEvent();
                            currentEdad = event.asCharacters().getData();
                            break;
                            
                        case "nota":
                            event = eventReader.nextEvent();
                            currentNota = event.asCharacters().getData();
                            break;
                    }
                }
                
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if ("alumno".equals(endElement.getName().getLocalPart())) {
                        // Mostrar información del alumno completo
                        System.out.println("--- ALUMNO ---");
                        System.out.println("ID: " + currentAlumnoId);
                        System.out.println("Nombre: " + currentNombre);
                        System.out.println("Apellido: " + currentApellido);
                        System.out.println("Edad: " + currentEdad);
                        System.out.println("Nota: " + currentNota);
                        System.out.println();
                        
                        // Resetear valores para el próximo alumno
                        currentAlumnoId = "";
                        currentNombre = "";
                        currentApellido = "";
                        currentEdad = "";
                        currentNota = "";
                    }
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. Cerrar eventReader
            if (eventReader != null) {
                try {
                    eventReader.close();
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}