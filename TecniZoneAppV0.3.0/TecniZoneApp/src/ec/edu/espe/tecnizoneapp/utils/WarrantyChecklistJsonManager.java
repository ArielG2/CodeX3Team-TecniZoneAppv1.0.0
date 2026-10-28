package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.WarrantyChecklist;
import org.json.JSONObject;
import java.io.FileWriter;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class WarrantyChecklistJsonManager {

    public static void save(WarrantyChecklist warrantyChecklist) {

        JSONObject json = new JSONObject(warrantyChecklist);

        try (FileWriter file = new FileWriter("warrantyChecklists.json", true)) {
            file.write(json.toString() + "\n");
            System.out.println(">> Checklist de garantía guardado en warrantyChecklists.json");
        } catch (Exception e) {
            System.out.println(">> Error al guardar: " + e.getMessage());
        }
    }
}
