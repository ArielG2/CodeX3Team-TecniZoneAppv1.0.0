package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.WarrantyChecklist;
import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class WarrantyChecklistJsonManager {

    public static void save(WarrantyChecklist warrantyChecklist) {
        JSONObject json = new JSONObject();
        json.put("checklistId", warrantyChecklist.getChecklistId());
        json.put("hasPhysicalDamage", warrantyChecklist.isHasPhysicalDamage());
        json.put("includesAccessories", warrantyChecklist.isIncludesAccessories());
        json.put("isWarrantyValid", warrantyChecklist.isIsWarrantyValid());

        if (warrantyChecklist.getRelatedEquipment() != null) {
            json.put("serialNumber", warrantyChecklist.getRelatedEquipment().getSerialNumber());
        }

        File fileObj = new File("warrantyChecklists.json");

        try (FileWriter file = new FileWriter(fileObj, true)) {
            file.write(json.toString() + "\n");
            file.flush();
        } catch (Exception e) {
            System.out.println(">> Error al guardar checklist de garantía: " + e.getMessage());
        }
    }
}
