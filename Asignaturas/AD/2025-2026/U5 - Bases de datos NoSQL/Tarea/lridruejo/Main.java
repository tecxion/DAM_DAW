import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class Main {
    public static void main(String[] args) {
        // Cadena de conexión a MongoDB Atlas
        String uri = "mongodb+srv://root:root@cluster0.qv7c4fv.mongodb.net/?appName=Cluster0";

        // CONEXIÓN a la colección Videojuegos de la base de datos Tienda
        // Creación del cliente de MongoDB con la cadena de conexión usando try-with-resources
        try (MongoClient mongoClient = MongoClients.create(uri)) {

            // Seleccionar la base de datos Tienda (se crea automáticamente si no existe)
            MongoDatabase database = mongoClient.getDatabase("Tienda");

            // Obtener la colección Videojuegos (se crea automáticamente al insertar el primer documento)
            MongoCollection<Document> collection = database.getCollection("Videojuegos");

            System.out.println("Conexión establecida correctamente con MongoDB Atlas");
            
            
            
            // CREATE: Insertar un nuevo videojuego
            // Crear un nuevo documento (clase de MongoDB para representar documentos BSON)
            // Si no se añade un id con "new Document("_id", new ObjectId())", se genera automáticamente
            Document document = new Document("titulo", "The Legend of Zelda")  // Primer par clave-valor del documento
                    .append("genero", "Aventura")  // .append para cada clave-valor que se quiera añadir al documento
                    .append("año_lanzamiento", 2017);

            // Insertar el documento en la colección
            InsertOneResult resultInsert = collection.insertOne(document);

            // Obtener el id del documento insertado para mostrarlo por pantalla
            BsonValue id = resultInsert.getInsertedId();
            System.out.println("Videojuego 'The Legend of Zelda' insertado con ID: " + id);



            // READ: Consultar la base de datos y obtener el videojuego utilizando su id
            String idVideojuegoReadString = "69bc02e5f76000454f178c7b";  // ID del videojuego a obtener
            ObjectId idVideojuegoRead = new ObjectId(idVideojuegoReadString);  // Convertir el ID a ObjectId

            // Buscar el documento que tenga como _id el id del videojuego a obtener
            Document videojuego = collection.find(Filters.eq("_id", idVideojuegoRead)).first();

            // Verificar si se encontró el videojuego (documento)
            if (videojuego != null) {
                // Mostrar los datos
                System.out.println("VIDEOJUEGO:");
                System.out.println("ID: " + videojuego.get("_id"));
                System.out.println("Título: " + videojuego.get("titulo"));
                System.out.println("Género: " + videojuego.get("genero"));
                System.out.println("Año de lanzamiento: " + videojuego.get("año_lanzamiento"));
            } else {
                System.out.println("Videojuego con id " + idVideojuegoReadString + " no encontrado");
            }



            // UPDATE: Modificar el año de lanzamiento de un videojuego
            String idVideojuegoUpdateString = "69bc02e5f76000454f178c7b";  // ID del videojuego a actualizar
            ObjectId idVideojuegoUpdate = new ObjectId(idVideojuegoUpdateString); // Convertir el ID a ObjectId

            // Filtro para localizar el documento por su id
            Bson filtroUpdate = Filters.eq("_id", idVideojuegoUpdate);

            // Actualización a realizar
            Bson actualizacion = Updates.set("año_lanzamiento", 2023);

            // Ejecutar actualización
            UpdateResult resultUpdate = collection.updateOne(filtroUpdate, actualizacion);

            // Verificar actualización
            if (resultUpdate.getModifiedCount() == 1) {
                System.out.println("Videojuego actualizado correctamente");
            } else if (resultUpdate.getMatchedCount() == 0) {
                System.out.println("Videojuego con id " + idVideojuegoUpdateString + " no encontrado");
            } else {
                System.out.println("El videojuego con id " + idVideojuegoUpdateString + " ya tenía el año de " +
                        "lanzamiento 2023 (no se ha modificado)");
            }

            

            // DELETE: Eliminar el videojuego por su id
            String idVideojuegoDeleteString = "69bc02e5f76000454f178c7b";  // ID del videojuego a eliminar
            ObjectId idVideojuegoDelete = new ObjectId(idVideojuegoDeleteString); // Convertir el ID a ObjectId

            // Filtro para localizar el documento por su id
            Bson filtroDelete = Filters.eq("_id", idVideojuegoDelete);

            DeleteResult resultDelete = collection.deleteOne(filtroDelete);

            // Verificar borrado
            if (resultDelete.getDeletedCount() == 1) {
                System.out.println("Videojuego eliminado correctamente");
            } else {
                System.out.println("El videojuego con id " + idVideojuegoDeleteString + " no se ha encontrado por " +
                        "lo que no se ha eliminado");
            }

        } catch (Exception e) {
            System.err.println("Error al conectar con MongoDB" + e.getMessage());
        }
    }
}
