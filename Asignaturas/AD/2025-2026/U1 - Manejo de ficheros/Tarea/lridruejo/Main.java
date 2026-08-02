import java.io.BufferedWriter;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Programa para sincronizar archivos .txt desde una carpeta origen a otra destino.
 * Se lleva un registro en sincronizacion.log en la carpeta destino.
 * Se vacía la carpeta origen al finalizar.
 */

public class Main {

    // Directorio raíz del proyecto
    private static final String raiz = System.getProperty("user.dir");

    // Variables para el log
    private static int archivosProcesados = 0;
    private static int archivosCopiados = 0;
    private static BufferedWriter logEsc;

    public static void main(String[] args) {

        // Variable para seguimiento de errores
        int paso = 1;

        try {
            crearDirectorios();
            paso = 2;
            inicializarLog();
            paso = 3;
            copiarArchivos();
            paso = 4;
            vaciarOrigen();
            paso = 5;
            escribirResumenLog();
        } catch (IOException e) {
            // Mensaje de error específico
            manejoError(paso, e);
        } finally {
            cerrarLog();
        }

    }


    /**
     * Maneja los errores mostrando mensajes específicos según la etapa
     * @param paso Etapa del proceso donde ha ocurrido el error
     * @param e Excepción producida
     */
    private static void manejoError(int paso, IOException e) {

        switch (paso) {
            case 1:
                System.out.println("No se han podido crear los directorios.");
                break;
            case 2:
                System.out.println("No se ha podido inicializar el log.");
                break;
            case 3:
                System.out.println("No se han podido copiar los archivos.");
                break;
            case 4:
                System.out.println("No se ha podido vaciar la carpeta origen.");
                break;
            case 5:
                System.out.println("No se ha podido escribir en el log.");
        }
        System.err.println("Error: " + e.getMessage());
        e.printStackTrace();

    }


    /**
     * Crea la estructura de directorios principal para la sincronización
     * @throws IOException Si no se pueden crear los directorios
     */
    private static void crearDirectorios() throws IOException {

        // Rutas directorios
        Path sincronizar = Paths.get(raiz, "sincronizar");
        Path origen = Paths.get(raiz, "sincronizar", "origen");
        Path destino = Paths.get(raiz, "sincronizar", "destino");

        /*
        // Comprobar si la carpeta "sincronizar" existe
        if (!Files.exists(sincronizar)) {
            // Crear carpeta "sincronizar"
            Files.createDirectory(sincronizar);
        }

        // Comprobar si la carpeta "origen" existe
        if (!Files.exists(origen)) {
            // Crear carpeta "origen"
            Files.createDirectory(origen);
        }

        // Comprobar si la carpeta "destino" existe
        if (!Files.exists(destino)) {
            // Crear carpeta "destino"
            Files.createDirectory(destino);
        }
        */

        // Array con las rutas de los directorios a crear
        Path[] directorios = {
                sincronizar,
                origen,
                destino
        };

        // Crear directorios si no existen
        for (Path directorio : directorios) {
            if (!Files.exists(directorio)) {
                Files.createDirectory(directorio);
            }
        }

    }


    /**
     * Inicializa el archivo sincronizacion.log para registrar las acciones
     * @throws IOException Si no se puede crear el archivo de log
     */
    private static void inicializarLog() throws IOException {

        Path log = Paths.get(raiz, "sincronizar", "destino", "sincronizacion.log");
        logEsc = Files.newBufferedWriter(log);

    }


    /**
     * Escribe una entrada en el archivo de log
     * @param registro Mensaje a registrar
     * @throws IOException Si no se puede escribir en el log
     */
    private static void escribirLog(String registro) {

        if (logEsc != null) {
            try {
                logEsc.write(registro);
                logEsc.newLine();
                logEsc.flush();
            } catch (IOException e) {
                System.out.println("No se ha podido escribir en el log.");
                System.err.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }

    }


    /**
     * Escribe el resumen final en el archivo de log
     * @throws IOException Si no se puede escribir en el log
     */
    private static void escribirResumenLog() throws IOException {

        String resumen = "En total se han procesado " + archivosProcesados +
                " archivos y se han copiado " +  archivosCopiados + " archivos.";
        logEsc.write(resumen);

    }


    /**
     * Cierra el archivo de log de forma segura
     */
    private static void cerrarLog() {
        if (logEsc != null) {
            try {
                logEsc.close();
            } catch (IOException e) {
                System.out.println("No se ha podido cerrar el log.");
                System.err.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }


    /**
     * Copia todos los archivos .txt que hay en origen en el destino
     * @throws IOException Si no se puede copiar algún archivo
     */
    private static void copiarArchivos() throws IOException {

        /**
         * Filtro para seleccionar solo archivos con una extensión concreta
         */
        class Filtro implements FilenameFilter {

            String extension;

            public Filtro(String extension) {
                this.extension = extension;
            }

            @Override
            public boolean accept(File dir, String nombre) {
                File archivo = new File(dir, nombre);
                return archivo.isFile() && nombre.endsWith(extension);
            };

        }

        File origen = new File("sincronizar", "origen");
        File destino = new File("sincronizar", "destino");

        // Uso de FilenameFilter para obtener solo archivos .txt
        File[] archivosTxt = origen.listFiles(new Filtro(".txt"));

        // Copiado de los archivos .txt y registro en el log
        if (archivosTxt != null && archivosTxt.length > 0) {
            for (File archivo : archivosTxt) {
                escribirLog("Archivo .txt encontrado: " + archivo.getName());

                File archivoDestino = new File(destino, archivo.getName());

                if (archivoDestino.exists()) {
                    escribirLog("Archivo copiado (sobreescrito): " + archivo.getName());
                } else {
                    escribirLog("Archivo copiado: " + archivo.getName());
                }

                Files.copy(archivo.toPath(), archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                archivosCopiados++;
            }
        }

    }


    /**
     * Elimina todos los archivos de la carpeta origen después de la sincronización
     * @throws IOException Si no se puede vaciar la carpeta origen
     */
    private static void vaciarOrigen() throws IOException {

        File origen = new File("sincronizar", "origen");
        File[] archivos = origen.listFiles();

        if (archivos != null && archivos.length > 0) {
            archivosProcesados = archivos.length;
            for (File archivo : archivos) {
                if (archivo.exists()) {
                    archivo.delete();
                }
            }
        }

    }

}