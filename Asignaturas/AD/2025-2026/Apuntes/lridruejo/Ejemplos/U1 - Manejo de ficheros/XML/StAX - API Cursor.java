import javax.xml.stream.*;
import java.io.*;

/**
 * Ejemplo de StAX usando API Cursor (XMLStreamReader)
 * Lee el XML secuencialmente con control de cursor
 */
public class StaxCursorExample {
    
    public static void main(String[] args) {
        XMLStreamReader reader = null;
        
        try {
            // 1. Crear XMLInputFactory
            XMLInputFactory factory = XMLInputFactory.newInstance();
            
            // 2. Crear XMLStreamReader
            reader = factory.createXMLStreamReader(new FileReader("alumnos.xml"));
            
            String currentElement = "";
            StringBuilder alumnoInfo = new StringBuilder();
            
            // 3. Procesar eventos secuencialmente
            while (reader.hasNext()) {
                int eventType = reader.next();
                
                switch (eventType) {
                    case XMLStreamConstants.START_ELEMENT:
                        currentElement = reader.getLocalName();
                        if ("alumno".equals(currentElement)) {
                            alumnoInfo.setLength(0);
                            String id = reader.getAttributeValue(null, "id");
                            if (id != null) {
                                alumnoInfo.append("ID: ").append(id).append("\n");
                            }
                        }
                        break;
                        
                    case XMLStreamConstants.CHARACTERS:
                        String text = reader.getText().trim();
                        if (!text.isEmpty()) {
                            switch (currentElement) {
                                case "nombre":
                                    alumnoInfo.append("Nombre: ").append(text).append("\n");
                                    break;
                                case "apellido":
                                    alumnoInfo.append("Apellido: ").append(text).append("\n");
                                    break;
                                case "edad":
                                    alumnoInfo.append("Edad: ").append(text).append("\n");
                                    break;
                                case "nota":
                                    alumnoInfo.append("Nota: ").append(text).append("\n");
                                    break;
                            }
                        }
                        break;
                        
                    case XMLStreamConstants.END_ELEMENT:
                        if ("alumno".equals(reader.getLocalName())) {
                            System.out.println("--- ALUMNO ---");
                            System.out.println(alumnoInfo.toString());
                        }
                        break;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4. Cerrar reader
            if (reader != null) {
                try {
                    reader.close();
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}