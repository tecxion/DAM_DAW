import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.IOException;
import java.util.Set;

public class EjemploAtributos {
    
    public void leerAtributosBasicos() throws IOException {
        Path archivo = Paths.get("archivo.txt");
        
        // Atributos básicos
        long tamaño = Files.size(archivo);
        FileTime ultimaModificacion = Files.getLastModifiedTime(archivo);
        boolean esEjecutable = Files.isExecutable(archivo);
        boolean estaOculto = Files.isHidden(archivo);
        
        // Todos los atributos básicos
        BasicFileAttributes attrs = Files.readAttributes(archivo, BasicFileAttributes.class);
        System.out.println("Creación: " + attrs.creationTime());
        System.out.println("Último acceso: " + attrs.lastAccessTime());
        System.out.println("Es directorio: " + attrs.isDirectory());
    }
    
    public void atributosPOSIX() throws IOException {
        Path archivo = Paths.get("archivo.txt");
        
        try {
            PosixFileAttributes posixAttrs = Files.readAttributes(archivo, PosixFileAttributes.class);
            Set<PosixFilePermission> permisos = posixAttrs.permissions();
            String grupo = posixAttrs.group().getName();
            
            // Cambiar permisos
            Files.setPosixFilePermissions(archivo, 
                Set.of(PosixFilePermission.OWNER_READ,
                       PosixFilePermission.OWNER_WRITE));
                       
        } catch (UnsupportedOperationException e) {
            System.out.println("Sistema no POSIX");
        }
    }
}