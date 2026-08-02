import java.io.BufferedWriter;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;

public class Main {

    // Directorio raíz del proyecto para guardar el log
    private static final String raiz = System.getProperty("user.dir");

    // Directorio C:\Descargas
    private static final String descargas = "C:" + File.separator + "Descargas";

    // BufferedWriter para el log
    private static BufferedWriter logEsc;

    public static void main(String[] args) {

        // Variable para el seguimiento de errores
        int paso = 1;

        try {
            crearDirectorios();
            paso = 2;
            inicializarLog();
            paso = 3;
            moverArchivos();
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
                System.out.println("No se han podido mover los archivos.");
                break;
        }
        System.err.println("Error: " + e.getMessage());

    }

    /**
     * Crea la estructura de directorios
     * @throws IOException Si no se pueden crear los directorios
     */
    private static void crearDirectorios() throws IOException {

        // Rutas directorios
        Path documentos = Paths.get(descargas, "Documentos");
        Path imagenes = Paths.get(descargas, "Imagenes");

        // Array con las rutas de los directorios a crear
        Path[] directorios = {
                documentos,
                imagenes
        };

        // Crear directorios si no existen
        for (Path directorio : directorios) {
            if (!Files.exists(directorio)) {
                Files.createDirectory(directorio);
            }
        }

    }

    /**
     * Inicializa el archivo log_movimientos.log para registrar las acciones
     * @throws IOException Si no se puede crear el archivo de log
     */
    private static void inicializarLog() throws IOException {

        Path log = Paths.get(raiz, "log_movimientos.txt");
        logEsc = Files.newBufferedWriter(log);

    }

    /**
     * Escribe una entrada en el archivo de log
     * @param registro Mensaje a registrar
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
            }
        }

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
            }
        }
    }

    /**
     * Mueve todos los archivos .txt y .pdf que hay en Descargas a Documentos
     * y todos los archivos .jpg que hay en Descargas a Imagenes
     * @throws IOException Si no se puede mover algún archivo
     */
    private static void moverArchivos() throws IOException {
        /**
         * Filtro para seleccionar solo archivos con una extensión concreta
         */
        class Filtro implements FilenameFilter {

            final String extension;

            public Filtro(String extension) {
                this.extension = extension;
            }

            @Override
            public boolean accept(File dir, String nombre) {
                File archivo = new File(dir, nombre);
                return archivo.isFile() && nombre.endsWith(extension);
            };

        }

        File origen = new File(descargas);
        File documentos = new File(descargas, "Documentos");
        File imagenes = new File(descargas, "Imagenes");

        // Uso de FilenameFilter para obtener los archivos .txt, .pdf y .jpg
        File[] archivosTxt = origen.listFiles(new Filtro(".txt"));
        File[] archivosPdf = origen.listFiles(new Filtro(".pdf"));
        File[] archivosJpg = origen.listFiles(new Filtro(".jpg"));

        // Mover los archivos .txt a Documentos y registro en el log
        if (archivosTxt != null) {
            for (File archivo : archivosTxt) {

                File archivoDestino = new File(documentos, archivo.getName());

                Files.move(archivo.toPath(), archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Escribir log
                if (archivoDestino.exists()) {
                    escribirLog(LocalDateTime.now() + ":" +
                            "Archivo .txt movido (sobreescrito): " + archivo.getName());
                } else {
                    escribirLog(LocalDateTime.now() + ":" +
                            "Archivo .txt movido: " + archivo.getName());
                }
            }
        }

        // Mover los archivos .pdf a Documentos y registro en el log
        if (archivosPdf != null) {
            for (File archivo : archivosPdf) {

                File archivoDestino = new File(documentos, archivo.getName());

                Files.move(archivo.toPath(), archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Escribir log
                if (archivoDestino.exists()) {
                    escribirLog(LocalDateTime.now() + ":" +
                            "Archivo .pdf movido (sobreescrito): " + archivo.getName());
                } else {
                    escribirLog(LocalDateTime.now() + ":" +
                            "Archivo .pdf movido: " + archivo.getName());
                }
            }
        }

        // Mover los archivos .jpg a Documentos y registro en el log
        if (archivosJpg != null) {
            for (File archivo : archivosJpg) {

                File archivoDestino = new File(imagenes, archivo.getName());

                Files.move(archivo.toPath(), archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Escribir log
                if (archivoDestino.exists()) {
                    escribirLog(LocalDateTime.now() + ":" +
                            "Archivo .jpg movido (sobreescrito): " + archivo.getName());
                } else {
                    escribirLog(LocalDateTime.now() + ":" +
                            "Archivo .jpg movido: " + archivo.getName());
                }
            }
        }

    }


}