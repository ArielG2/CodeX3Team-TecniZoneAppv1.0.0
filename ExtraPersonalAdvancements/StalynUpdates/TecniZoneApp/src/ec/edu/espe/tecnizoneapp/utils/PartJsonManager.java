package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.Part;
import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class PartJsonManager {

    public static void save(Part part) {
        JSONObject json = new JSONObject();
        json.put("code", part.getCode());
        json.put("name", part.getName());
        json.put("currentStock", part.getCurrentStock());
        json.put("minStock", part.getMinStock());
        json.put("price", part.getPrice());

        File fileObj = new File("C:\\Users\\ARIEL\\OneDrive\\Escritorio\\proyecto\\CodeX3Team-TecniZoneAppv1.0.0\\TecniZoneAppV0.9.0\\TecniZone");

        try (FileWriter file = new FileWriter(fileObj, true)) {
            file.write(json.toString() + "\n");
            file.flush();
            System.out.println(">> Repuesto guardado en: " + fileObj.getAbsolutePath());
        } catch (Exception e) {
            System.out.println(">> Error al guardar repuesto: " + e.getMessage());
        }
    }
}