package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.SystemUser;
import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class SystemUserJsonManager {

    public static void save(SystemUser systemUser) {
        JSONObject json = new JSONObject();
        json.put("username", systemUser.getUsername());
        json.put("password", systemUser.getPassword());
        json.put("userRole", systemUser.getUserRole());

        File fileObj = new File("C:\\Users\\ARIEL\\OneDrive\\Escritorio\\proyecto\\CodeX3Team-TecniZoneAppv1.0.0\\TecniZoneAppV0.9.0\\TecniZone");

        try (FileWriter file = new FileWriter(fileObj, true)) {
            file.write(json.toString() + "\n");
            file.flush();
        } catch (Exception e) {
            System.out.println(">> Error al guardar usuario del sistema: " + e.getMessage());
        }
    }
}
