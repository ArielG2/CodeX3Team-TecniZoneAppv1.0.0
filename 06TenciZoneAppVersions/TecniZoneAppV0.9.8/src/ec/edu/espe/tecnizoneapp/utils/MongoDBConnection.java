
package ec.edu.espe.tecnizoneapp.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */

public class MongoDBConnection {

    private static MongoClient mongoClient;

    public static MongoDatabase getDatabase() {

        if (mongoClient == null) {
            String uri = System.getenv("MONGODB_URI");

            if (uri == null || uri.isBlank()) {
                throw new IllegalStateException(
                    "MONGODB has not been configured"
                );
            }

            mongoClient = MongoClients.create(uri);
        }

        return mongoClient.getDatabase("TecniZoneApp");
    }

    public static void testConnection() {
        MongoDatabase db = getDatabase();
        db.runCommand(new Document("ping", 1));
        System.out.println("Successful connection to MongoDB Atlas");
    }

    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }
}