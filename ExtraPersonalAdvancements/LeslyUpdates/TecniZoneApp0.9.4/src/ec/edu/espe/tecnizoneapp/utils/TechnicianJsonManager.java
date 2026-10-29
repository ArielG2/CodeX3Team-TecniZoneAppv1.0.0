package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.Technician;
import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class TechnicianJsonManager {

    public static void save(Technician technician) {
        JSONObject json = new JSONObject();
        json.put("technicianId", technician.getTechnicianId());
        json.put("fullName", technician.getFullName());
        json.put("specialty", technician.getSpecialty());

        File fileObj = new File("technicians.json");

        try (FileWriter file = new FileWriter(fileObj, true)) {
            file.write(json.toString() + "\n");
            file.flush();
        } catch (Exception e) {
            System.out.println(">> Error al guardar técnico: " + e.getMessage());
        }
    }
}
