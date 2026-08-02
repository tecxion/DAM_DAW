import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        String[][] coches = {
                {"6666FFF", "Nissan", "Leaf", "150", "Eléctrico"},
                {"3456JKL", "Ferrari", "F8 Tributo", "720", "Gasolina"},
                {"8901QRS", "Peugeot", "208", "75", "Gasolina"},
                {"0123VWX", "Toyota", "Prius", "122", "Gasolina"},
                {"6789STU", "Mercedes", "Clase C", "170", "Diésel"},
                {"4567CDE", "Mazda", "CX-5", "165", "Diésel"},
                {"2345TUV", "Citroën", "C3", "83", "Gasolina"},
                {"9012GHI", "Volkswagen", "Golf", "150", "Diésel"},
                {"8888HHH", "Mazda", "3", "130", "Gasolina"},
                {"7070PPP", "Skoda", "Octavia", "140", "Diésel"},
                {"5678DEF", "Tesla", "Model S", "670", "Eléctrico"},
                {"1111AAA", "BMW", "Serie 3", "180", "Gasolina"},
                {"0123ZAB", "Volvo", "XC60", "250", "Gasolina"},
                {"4567NOP", "Kia", "Sportage", "141", "Diésel"},
                {"6789WXY", "Fiat", "500", "69", "Gasolina"},
                {"2345EFG", "Seat", "León", "150", "Gasolina"},
                {"9876XYZ", "Ford", "Focus", "120", "Gasolina"},
                {"4040MMM", "Ford", "Fiesta", "100", "Gasolina"},
                {"5555EEE", "Peugeot", "308", "110", "Gasolina"},
                {"0123KLM", "Hyundai", "Tucson", "136", "Diésel"},
                {"1234ABC", "Ferrari", "458 Italia", "570", "Gasolina"},
                {"3030LLL", "Hyundai", "i30", "120", "Gasolina"},
                {"9999III", "Renault", "Megane", "140", "Gasolina"},
                {"6789HIJ", "Renault", "Clio", "100", "Gasolina"},
                {"2222BBB", "Audi", "A4", "150", "Diésel"},
                {"7890MNO", "BMW", "Serie 3", "184", "Gasolina"},
                {"4567YZA", "Nissan", "Leaf", "150", "Eléctrico"},
                {"7777GGG", "Honda", "Civic", "160", "Gasolina"},
                {"2345PQR", "Audi", "A4", "190", "Diésel"},
                {"3333CCC", "Volkswagen", "Golf", "130", "Gasolina"},
                {"5050NNN", "Fiat", "500", "95", "Gasolina"},
                {"2020KKK", "Kia", "Ceed", "130", "Gasolina"},
                {"6060OOO", "Citroën", "C3", "110", "Gasolina"},
                {"4444DDD", "Mercedes", "Clase C", "200", "Gasolina"},
                {"1010JJJ", "Seat", "Leon", "150", "Diésel"},
                {"8901FGH", "Subaru", "Forester", "156", "Gasolina"},
                {"8901BCD", "Ford", "Focus", "125", "Gasolina"}
        };

        // Probar la conexión
        System.out.println("=== PROBANDO CONEXIÓN ===");
        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            System.out.println("Conexión a la base de datos correcta.");
            DatabaseConnection.closeConnection(connection);
        } else {
            System.out.println("Conexión erronea.");
        }


        // INSERT - Insertar coches
        System.out.println("\n=== INSERTANDO COCHES ===");
        for (String[] coche : coches) {
            String matricula = coche[0];
            String marca = coche[1];
            String modelo = coche[2];
            String potencia = coche[3];
            String combustible = coche[4];

            InsertCoche.insertarCoche(matricula, marca, modelo, potencia, combustible);
        }

        // SELECT - Mostrar todos los coches
        System.out.println("\n=== MOSTRANDO TODOS LOS COCHES ===");
        SelectCoches.mostrarCoches();

        // UPDATE - Aumentar potencia de Ferrari en 10 CV
        System.out.println("\n=== ACTUALIZANDO POTENCIA ===");
        UpdateCoche.aumentarPotencia("Ferrari", 10);

        // SELECT - Mostrar coches después del UPDATE
        System.out.println("\n=== COCHES DESPUÉS DEL UPDATE ===");
        SelectCoches.mostrarCoches();

        // DELETE - Eliminar un coche por matrícula
        System.out.println("\n=== ELIMINANDO COCHE ===");
        DeleteCoche.eliminarCoche("9012GHI");

        // SELECT - Mostrar coches después del DELETE
        System.out.println("\n=== COCHES DESPUÉS DEL DELETE ===");
        SelectCoches.mostrarCoches();
    }
}