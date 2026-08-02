package ej01_ConvStringANumero;
import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {
        // Crear una instancia de la clase EjConvStringANumero
        EjConvStringANumero conversor = new EjConvStringANumero();

        // Menú principal
        String[] opciones = {
            "Convertir a Double",
            "Convertir a Float",
            "Convertir a Integer",
            "Convertir a Long",
            "Convertir a Short",
            "Salir"
        };

        boolean continuar = true;
        while (continuar) {
            // Mostrar menú y capturar selección
            String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione una operación:",
                "Menú de Conversión",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            if (seleccion == null || seleccion.equals("Salir")) {
                continuar = false;
                break;
            }

            String titulo = "Conversión de Número";
            String mensaje = "Introduce un número:";

            // Llamar al método correspondiente según la selección
            switch (seleccion) {
                case "Convertir a Double":
                    double resultadoDouble = conversor.PedirNumeroDouble(titulo, mensaje);
                    if (!conversor.isOperacionCancelada()) {
                        JOptionPane.showMessageDialog(null, "Número convertido a Double: " + resultadoDouble, "Conversión Exitosa",JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                case "Convertir a Float":
                    float resultadoFloat = conversor.PedirNumeroFloat(titulo, mensaje);
                    if (!conversor.isOperacionCancelada()) {
                        JOptionPane.showMessageDialog(null, "Número convertido a Float: " + resultadoFloat, "Conversión Exitosa",JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                case "Convertir a Integer":
                    int resultadoInt = conversor.PedirNumeroInteger(titulo, mensaje);
                    if (!conversor.isOperacionCancelada()) {
                        JOptionPane.showMessageDialog(null, "Número convertido a Integer: " + resultadoInt, "Conversión Exitosa",JOptionPane.INFORMATION_MESSAGE );
                    }
                    break;

                case "Convertir a Long":
                    long resultadoLong = conversor.PedirNumeroLong(titulo, mensaje);
                    if (!conversor.isOperacionCancelada()) {
                        JOptionPane.showMessageDialog(null, "Número convertido a Long: " + resultadoLong, "Conversión Exitosa",JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                case "Convertir a Short":
                    short resultadoShort = conversor.PedirNumeroShort(titulo, mensaje);
                    if (!conversor.isOperacionCancelada()) {
                        JOptionPane.showMessageDialog(null, "Número convertido a Short: " + resultadoShort, "Conversión Exitosa",JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }
        }

        JOptionPane.showMessageDialog(null, "Gracias por usar el conversor. ¡Adiós!");
    }
}
