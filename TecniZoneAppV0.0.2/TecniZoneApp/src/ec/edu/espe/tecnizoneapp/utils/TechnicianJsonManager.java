package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.Technician;
import org.json.JSONObject;
import java.io.FileWriter;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class TechnicianJsonManager {

    public static void save(Technician technician) {

        JSONObject json = new JSONObject(technician);

        try (FileWriter file = new FileWriter("technicians.json", true)) {
            file.write(json.toString() + "\n");
            System.out.println(">> Técnico guardado en technicians.json");
        } catch (Exception e) {
            System.out.println(">> Error al guardar: " + e.getMessage());
        }
    }
}
