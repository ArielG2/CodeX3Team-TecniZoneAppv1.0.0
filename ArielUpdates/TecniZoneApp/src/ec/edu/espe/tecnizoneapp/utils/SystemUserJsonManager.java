package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.SystemUser;
import org.json.JSONObject;
import java.io.FileWriter;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class SystemUserJsonManager {

    public static void save(SystemUser systemUser) {

        JSONObject json = new JSONObject(systemUser);

        try (FileWriter file = new FileWriter("systemUsers.json", true)) {
            file.write(json.toString() + "\n");
            System.out.println(">> Usuario del sistema guardado en systemUsers.json");
        } catch (Exception e) {
            System.out.println(">> Error al guardar: " + e.getMessage());
        }
    }
}
