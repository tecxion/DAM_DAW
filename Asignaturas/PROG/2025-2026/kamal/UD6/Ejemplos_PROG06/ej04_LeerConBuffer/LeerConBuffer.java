package ej04_LeerConBuffer;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author 
 */
public class LeerConBuffer {

     public static void main(String[] args) {
           int tama ;
    
    try{
      // Creamos un nuevo objeto File, que es la ruta hasta el fichero desde
    	//File f = new File("C:\\ficherosJava\\img_destino.png");
    	//File f = new File("C:\\ficherosJava\\ej01_Token.zip");
    	File f = new File("C:\\ficherosJava\\test.bin");

      // Construimos un flujo de tipo FileInputStream (un flujo de entrada desde
      // fichero) sobre el objeto File. Estamos conectando nuestra aplicaciÃ³n
      // a un extremo del flujo, por donde van a salir los datos, y "pidiendo"
      // al Sistema Operativo que conecte el otro extremo al fichero que indica
      // la ruta establecida por el objeto File f que habÃ­amos creado antes. De
      FileInputStream flujoEntrada = new FileInputStream(f);
      BufferedInputStream fEntradaConBuffer = new BufferedInputStream(flujoEntrada);

      // Escribimos el tamaÃ±o del fichero en bytes.
      tama = fEntradaConBuffer.available();
      System.out.println("Bytes disponibles: " + tama);

      // Indicamos que vamos a intentar leer 50 bytes del fichero.
      System.out.println("Leyendo 50 bytes....");

      // Creamos un array de 50 bytes para llenarlo con los 50 bytes
      // que leamos del flujo (realmente del fichero)*/
      byte bytearray[] = new byte[50];

      // El mÃ©todo read() de la clase FileInputStream recibe como parÃ¡metro un
      // array de byte, y lo llena leyendo bytes desde el flujo.
      // Devuelve un nÃºmero entero, que es el nÃºmero de bytes que realmente se
      // han leÃ­do desde el flujo. Si el fichero tiene menos de 50 bytes, no
      // podrÃ¡ leer los 50 bytes, y escribirÃ¡ un mensaje indicÃ¡ndolo.
      if (fEntradaConBuffer.read(bytearray) != 50) 
          System.out.println("No se pudieron leer 50 bytes");
      
      // Usamos un constructor adecuado de la clase String, que crea un nuevo
      // String a partir de los bytes leÃ­dos desde el flujo, que se almacenaron
      // en el array bytearray, y escribimos ese String.
      System.out.println(new String(bytearray, 0, 50));
        
      // Finalmente cerramos el flujo.Es importante cerrar los flujos
      // para liberar ese recurso. Al cerrar el flujo, se comprueba que no
      // haya quedado ningÃºn dato en el flujo sin que se haya leÃ­do por la aplicaciÃ³n. */
      fEntradaConBuffer.close();

      // Capturamos la excepciÃ³n de Entrada/Salida. El error que puede
      // producirse en este caso es que el fichero no estÃ© accesible, y
      // es el mensaje que enviamos en tal caso.
    }catch (IOException e){
             System.err.println("No se encuentra el fichero");
    }
    }
    
}
