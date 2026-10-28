package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.Client;
import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class ClientJsonManager {

    public static void save(Client client) {
        JSONObject json = new JSONObject();
        json.put("clientId", client.getClientId());
        json.put("fullName", client.getFullName());
        json.put("phoneNumber", client.getPhoneNumber());

        File fileObj = new File("C:\\Users\\Mateo\\Documents\\ObjectOrientedProgramming\\CodeX3Team-TecniZoneAppv1.0.0\\StalynUpdates\\TecniZoneApp\\clients.json");

        try (FileWriter file = new FileWriter(fileObj, true)) {
            file.write(json.toString() + "\n");
            file.flush();
            System.out.println(">> Cliente guardado en: " + fileObj.getAbsolutePath());
        } catch (Exception e) {
            System.out.println(">> Error al guardar cliente: " + e.getMessage());
        }
    }
}
