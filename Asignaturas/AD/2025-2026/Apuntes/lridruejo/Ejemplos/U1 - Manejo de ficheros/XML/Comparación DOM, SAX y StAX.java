import org.w3c.dom.*;
import javax.xml.parsers.*;
import org.xml.sax.helpers.*;
import javax.xml.stream.*;
import java.io.*;

/**
 * Ejemplo comparativo que muestra las diferencias entre DOM, SAX y StAX
 * Realiza la misma tarea con los tres métodos
 */
public class XmlParserComparison {
    
    private static final String XML_FILE = "alumnos.xml";
    
    public static void main(String[] args) {
        System.out.println("=== COMPARACIÓN DE PARSERS XML ===\n");
        
        System.out.println("1. USANDO DOM (Document Object Model):");
        parseWithDOM();
        
        System.out.println("\n2. USANDO SAX (Simple API for XML):");
        parseWithSAX();
        
        System.out.println("\n3. USANDO StAX (Streaming API for XML):");
        parseWithStAX();
    }
    
    /**
     * Método DOM: Carga todo el documento en memoria
     */
    private static void parseWithDOM() {
        try {
            long startTime = System.currentTimeMillis();
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(XML_FILE));
            
            document.getDocumentElement().normalize();
            NodeList alumnos = document.getElementsByTagName("alumno");
            
            System.out.println("Alumnos encontrados: " + alumnos.getLength());
            
            for (int i = 0; i < alumnos.getLength(); i++) {
                Element alumno = (Element) alumnos.item(i);
                String nombre = alumno.getElementsByTagName("nombre").item(0).getTextContent();
                System.out.println("  - " + nombre);
            }
            
            long endTime = System.currentTimeMillis();
            System.out.println("Tiempo DOM: " + (endTime - startTime) + "ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Método SAX: Procesa evento por evento
     */
    private static void parseWithSAX() {
        try {
            long startTime = System.currentTimeMillis();
            
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            
            DefaultHandler handler = new DefaultHandler() {
                private int alumnoCount = 0;
                private StringBuilder currentValue = new StringBuilder();
                private boolean inNombre = false;
                
                @Override
                public void startElement(String uri, String localName, 
                                      String qName, Attributes attributes) {
                    currentValue.setLength(0);
                    if ("alumno".equals(qName)) {
                        alumnoCount++;
                    } else if ("nombre".equals(qName)) {
                        inNombre = true;
                    }
                }
                
                @Override
                public void characters(char[] ch, int start, int length) {
                    if (inNombre) {
                        currentValue.append(ch, start, length);
                    }
                }
                
                @Override
                public void endElement(String uri, String localName, String qName) {
                    if ("nombre".equals(qName)) {
                        System.out.println("  - " + currentValue.toString().trim());
                        inNombre = false;
                    } else if ("alumnos".equals(qName)) {
                        System.out.println("Alumnos encontrados: " + alumnoCount);
                    }
                }
            };
            
            saxParser.parse(new File(XML_FILE), handler);
            
            long endTime = System.currentTimeMillis();
            System.out.println("Tiempo SAX: " + (endTime - startTime) + "ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Método StAX: Control de cursor sobre el stream
     */
    private static void parseWithStAX() {
        try {
            long startTime = System.currentTimeMillis();
            
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileReader(XML_FILE));
            
            int alumnoCount = 0;
            boolean inNombre = false;
            StringBuilder nombre = new StringBuilder();
            
            while (reader.hasNext()) {
                int eventType = reader.next();
                
                switch (eventType) {
                    case XMLStreamConstants.START_ELEMENT:
                        if ("alumno".equals(reader.getLocalName())) {
                            alumnoCount++;
                        } else if ("nombre".equals(reader.getLocalName())) {
                            inNombre = true;
                        }
                        break;
                        
                    case XMLStreamConstants.CHARACTERS:
                        if (inNombre) {
                            nombre.append(reader.getText());
                        }
                        break;
                        
                    case XMLStreamConstants.END_ELEMENT:
                        if ("nombre".equals(reader.getLocalName())) {
                            System.out.println("  - " + nombre.toString().trim());
                            nombre.setLength(0);
                            inNombre = false;
                        }
                        break;
                }
            }
            
            reader.close();
            System.out.println("Alumnos encontrados: " + alumnoCount);
            
            long endTime = System.currentTimeMillis();
            System.out.println("Tiempo StAX: " + (endTime - startTime) + "ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}