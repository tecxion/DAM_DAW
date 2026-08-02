package ej08_ProcesarPedidos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Clase que se encarga de procesar un pedido. 
 * El archivo con el pedido debe estar en codificación UTF8, sino no funciona
 * bien.
 * Tu sistema debe soportar de forma nativa la coficación UTF8, sino no 
 * funcionará del todo bien.
 */

class Articulo {
    public String codArticulo;
    public String descripcion;
    public int cantidad;
}

public class ProcesarPedidos {

    /* Entrada contendrá una instancia de la clase Scanner que permitirá
    leer las teclas pulsadas desde teclado */
    static Scanner entrada = new Scanner(System.in);
    /* Definimos las expresiones regulares que usaremos una y otra vez para
     cada línea del pedido. La expresión regular "seccion" permite detectar
     si hay un comienzo o fin de pedido, y la expresión campo, permite detectar
     si hay un campo con información del pedido. */
    static Pattern seccion = Pattern.compile("^##[ ]*(FIN)?[ ]*(PEDIDO|ARTICULOS)[ ]*##$");
    static Pattern campo = Pattern.compile("^(.+):.*\\{(.*)\\}$");
    static Pattern articulo = Pattern.compile ("^\\{(.*)\\|(.*)\\|[ ]*([0-9]*)[ ]*\\}$");
    
    public static void main(String[] args) {
        BufferedReader lector;
        ArrayList<Articulo> Articulos=new ArrayList<Articulo>();
        HashMap<String,String> DatosPedido=new HashMap<String,String>();
        /* 1er paso: cargamos el archivo para poder procesarlo línea a línea
         * para ello nos apoyamos en la clase BufferedReader, que con el método
         * readLine nos permite recorrer todo el archivo línea a línea.
         */
        if (args.length > 0) {
            lector = cargarArchivo(args[0]);
        } else {
            lector = cargarArchivo();
        }


        if (lector == null) {
            /* Si no se ha podido cargar el archivo, no continúa con el 
             * procesado, simplemente termina la ejecución. */
            System.out.println("No se ha podido cargar el archivo.");
        } else {
            /* Si ha podido cargar el archivo, continúa el procesado de línea 
             * a línea. */
            String linea;
            try {
                linea = lector.readLine();
                while (linea != null) {
                    procesarLinea(linea,DatosPedido,Articulos);
                    linea = lector.readLine();
                }
            } catch (IOException ex) {
                System.out.println("Error de entrada y salida.");
            }
            // Mostramos los datos del pedido para ver si son correctos.
            for (String etiqueta:DatosPedido.keySet())
            {
                System.out.println("Dato pedido-->"+etiqueta+":"+DatosPedido.get(etiqueta));
            }
            // Mostramos los datos de los articulos para ver si son correctos.
            for (Articulo ar:Articulos)
            {
                System.out.print("<articulo codigo='"+ar.codArticulo+"' ");
                System.out.print("descripcion='"+ar.descripcion+"' ");
                System.out.println("cantidad='"+ar.cantidad+"'>");
            }
        }
    }

    /**
     * Procesa una línea del archivo de pedido para detectar que es y 
     * extraer la información que contiene.
     * @param linea 
     * @param datosPedido Mapa en el que irá metiendo la información del pedido.
     * La llave del mapa será el nombre del campo.
     * @param articulos Lista en la que se irán metiendo los artículos del pedido.
     * @return true si la línea contiene información que corresponde al formato
     * esperado, false en caso contrario.
     */
    static boolean procesarLinea(String linea, Map<String,String> datosPedido,
            List<Articulo> articulos) {
           
        Matcher deteccionSeccion = seccion.matcher(linea);
        Matcher deteccionCampo = campo.matcher(linea);
        Matcher deteccionArticulo= articulo.matcher(linea); 
        /* Si el patrón coincide con el de un indicador de comienzo del pedido
         * o de la sección con el listado de artículos, se ejecutará este trozo
         * de código, pues habrá encontrado el patrón. No hace nada,
         * simplemente lo detecta para así no informar de algo raro.
         */
        if (deteccionSeccion.matches()) {
            return true;
        }
        /* Si el patrón coincide con el de un campo con datos del pedido
                 entonces meterá tanto el campo como el valor en el mapa.*/
        else if (deteccionCampo.matches()) {
            datosPedido.put(deteccionCampo.group(1).trim().toLowerCase(),
                    deteccionCampo.group(2).trim());
            return true;
        }
        /* Si el patrón coincide con el de un artículo, entonces 
           guardará los datos del pedido en una clase articulo y lo meterá
                 en la lista de artículos.*/
        else if (deteccionArticulo.matches())
        {
            Articulo n=new Articulo();
            n.codArticulo=deteccionArticulo.group(1).trim();
            n.descripcion=deteccionArticulo.group(2).trim();
            n.cantidad=Integer.parseInt(deteccionArticulo.group(3));
            articulos.add(n);
            return true;
        }
        else { System.out.println("ERROR, línea no procesable: "+linea); return false; }
    }

    /**
     * cargarArchivo creará una instancia de la clase BufferedReader que 
     * permitirá leer línea a línea el archivo de texto. Si no se ha podido 
     * cargar el archivo retornará null.
     * @param name Nombre del archivo a cargar. si el nombre del archivo no 
     * se ha pasado por parámetro (valor null) se pedirá al usuario que lo
     * introduzca.
     * @return null si no ha podido cargar el archivo, o la instancia de la 
     * clase BufferedReader si dicho archivo se ha podido cargar.
     */
    static BufferedReader cargarArchivo(String name) {
    	
        String nombreArchivo = name;
        BufferedReader reader = null;
        if (name == null) {
            System.out.println("Introduce el nombre del archivo:");
            nombreArchivo = entrada.nextLine();
        }
        try {
            FileReader f =new FileReader(nombreArchivo);
            reader = new BufferedReader(f);
        } catch (FileNotFoundException ex) {
           // Logger.getLogger(ProcesarPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reader;
    }

    /**
     * Igual que el método BufferedReader cargarArchivo(String name), pero
     * que siempre le pedirá al usuario que lo introduzca.
     * @return null si no ha podido cargar el archivo, y una instancia de BufferedReader
     * en otro caso.
     */
    static BufferedReader cargarArchivo() {
        return cargarArchivo(null);
    }
}
