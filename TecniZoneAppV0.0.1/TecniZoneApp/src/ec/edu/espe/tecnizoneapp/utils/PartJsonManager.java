package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.Part;
import org.json.JSONObject;
import java.io.FileWriter;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class PartJsonManager {

    public static void save(Part part) {

        JSONObject json = new JSONObject(part);

        try (FileWriter file = new FileWriter("parts.json", true)) {
            file.write(json.toString() + "\n");
            System.out.println(">> Repuesto guardado en parts.json");
        } catch (Exception e) {
            System.out.println(">> Error al guardar: " + e.getMessage());
        }
    }
}