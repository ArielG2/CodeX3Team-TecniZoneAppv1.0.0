
package ec.edu.espe.tecnizoneapp.view;

import ec.edu.espe.tecnizoneapp.utils.MongoDBConnection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBTest {

    public static void main(String[] args) {

        try {
            MongoDatabase database =
                    MongoDBConnection.getDatabase();

            // Seleccionar la coleccion de clientes
            MongoCollection<Document> clients =
                    database.getCollection("clients");

            // Crear un cliente de prueba
            Document client = new Document()
                    .append("clientId", "TEST001")
                    .append("fullName", "Cliente de Prueba")
                    .append("phoneNumber", "0999999999");

            // Guardar o actualizar el cliente
            clients.replaceOne(
                    new Document("clientId", "TEST001"),
                    client,
                    new com.mongodb.client.model.ReplaceOptions()
                            .upsert(true)
            );

            System.out.println(
                    "Cliente guardado correctamente en MongoDB!"
            );

            // Consultar el cliente guardado
            Document found = clients.find(
                    new Document("clientId", "TEST001")
            ).first();

            System.out.println("Cliente encontrado: " + found);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();

        } finally {
            MongoDBConnection.closeConnection();
        }
    }
}