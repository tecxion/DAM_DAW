import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.IESParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.spec.ECGenParameterSpec;

public class CifradoAsimetricoEC {
    static void main() {

        System.out.println("Paso 1.- Creación e inicialización del generador de claves EC:");

        // 1. Registrar proveedor
        Security.addProvider(new BouncyCastleProvider());
        System.out.println("\tEl proveedor 'Bouncy Castle' " +
                "('https://mvnrepository.com/artifact/org.bouncycastle/bcprov-jdk18on') ha sido agregado");

        try {
            // 2. Obtener el generador de pares de claves para el algoritmo especificado (EC)
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC", "BC");

            // 3. Especificar la curva (brainpoolP512t1)
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("brainpoolP512t1");

            // 4. Configurar el KeyPairGenerator
            keyPairGenerator.initialize(ecSpec);  // EC brainpoolP512t1

            // 5. Obtener la instancia de Cipher con el algoritmo especificado
            Cipher cipher = Cipher.getInstance("ECIESwithAES-CBC", "BC");

            // 6. Configurar los parámetros específicos del cifrador
            byte[] nonce = new byte[16];  // inicializar el nonce como array de 16 bytes
            SecureRandom random = new SecureRandom();
            random.nextBytes(nonce);  // generar el valor del nonce

            System.out.println("\tLas propiedades del algoritmo ('EC') " +
                    "así como la curva de funcionamiento ('brainpoolP512t1') " +
                    "y el cifrado ('ECIESwithAES-CBC') han sido agregados");

            // 7. Crear el IESParameterSpec con los valores especificados
            IESParameterSpec iesParams = new IESParameterSpec(
                    null,       // derivation
                    null,       // encoding
                    512,        // macKeySize
                    256,        // cipherKeySize
                    nonce,      // nonce
                    false       // usePointCompression
            );

            System.out.println("\tLos parámetros específicos del algoritmo ('EC') han sido agregados");

            System.out.println("\nPaso 2.- Mostrar las claves generadas:");

            // 8. Generar el par de claves
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            System.out.println("\tClave pública: " + keyPair.getPublic());
            System.out.println("\tClave privada: " + keyPair.getPrivate());

            System.out.println("Paso 3.- Activación de 'modo ENCRIPTACIÓN' en cifrador utilizando la clave pública " +
                    "así como los parámetros específicos para el algoritmo 'EC'");

            // 9. Inicializar el Cipher en modo ENCRIPTACIÓN utilizando la clave pública y los parámetros IES
            cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic(), iesParams);

            System.out.println("\nPaso 4.- Cifrado de archivo con la clave pública creada:");

            // 10. Rutas de los archivos
            String archivoOriginal = "archivo";
            String archivoCifrado = "archivo.cifrado";

            // 11. Establecer el buffer para la lectura (5000 bytes)
            byte[] buffer = new byte[5000];
            int bytesLeidos;

            // 12. Leer el archivo y cifrarlo con CipherOutputStream (más cómodo que update y doFinal de Cipher)
            try (FileInputStream fis = new FileInputStream(archivoOriginal);
                 FileOutputStream fos = new FileOutputStream(archivoCifrado);
                 CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {

                System.out.println("\tSe realiza la operación de ENCRIPTACIÓN del archivo fuente '" + archivoOriginal +
                        "' en el archivo destino '" + archivoCifrado + "'");

                while ((bytesLeidos = fis.read(buffer)) != -1) {  // mientras no llegue al final del archivo
                    cos.write(buffer, 0, bytesLeidos); // cifrar
                }

            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }

            System.out.println("\nPaso 5.- Activación de 'modo DESENCRIPTACIÓN' en cifrador utilizando la clave " +
                    "privada así como los parámetros específicos para el algoritmo 'EC'");

            // 13. Inicializar el Cipher en modo DESENCRIPTACIÓN utilizando la clave privada y los parámetros IES
            cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate(), iesParams);

            System.out.println("\nPaso 6.- Descifrado de archivo con la clave privada creada:");

            // 14. Ruta del archivo descifrado
            String archivoDescifrado = "archivo.descifrado";

            // 15. Leer el archivo y descifrarlo con CipherInputStream (más cómodo que update y doFinal de Cipher)
            try (FileInputStream fis = new FileInputStream(archivoCifrado);
                 CipherInputStream cis = new CipherInputStream(fis, cipher);
                 FileOutputStream fos = new FileOutputStream(archivoDescifrado)) {

                System.out.println("\tSe realiza la operación de DESENCRIPTACIÓN del archivo fuente '" +
                        archivoCifrado + "' en el archivo destino '" + archivoDescifrado + "'");

                while ((bytesLeidos = cis.read(buffer)) != -1) {  // mientras no llegue al final del archivo
                    fos.write(buffer, 0, bytesLeidos); // descifrar
                }

            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }

        } catch (GeneralSecurityException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
