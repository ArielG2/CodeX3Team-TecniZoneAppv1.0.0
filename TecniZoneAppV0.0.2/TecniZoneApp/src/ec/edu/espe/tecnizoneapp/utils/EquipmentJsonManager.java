package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.Equipment;
import org.json.JSONObject;
import java.io.FileWriter;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class EquipmentJsonManager {

    public static void save(Equipment equipment) {

        JSONObject json = new JSONObject(equipment);

        try (FileWriter file = new FileWriter("equipments.json", true)) {
            file.write(json.toString() + "\n");
            System.out.println(">> Equipo guardado en equipments.json");
        } catch (Exception e) {
            System.out.println(">> Error al guardar: " + e.getMessage());
        }
    }
}
