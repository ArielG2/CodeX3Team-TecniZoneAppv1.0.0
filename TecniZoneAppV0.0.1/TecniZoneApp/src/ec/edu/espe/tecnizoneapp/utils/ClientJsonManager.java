package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.Client;
import org.json.JSONObject;
import java.io.FileWriter;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class ClientJsonManager {

    public static void save(Client client) {

        JSONObject json = new JSONObject(client);

        try (FileWriter file = new FileWriter("clients.json", true)) {
            file.write(json.toString() + "\n");
            System.out.println(">> Cliente guardado en clients.json");
        } catch (Exception e) {
            System.out.println(">> Error al guardar: " + e.getMessage());
        }
    }
}
