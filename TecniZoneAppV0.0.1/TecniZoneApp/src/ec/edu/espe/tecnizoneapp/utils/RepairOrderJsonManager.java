package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.RepairOrder;
import org.json.JSONObject;
import java.io.FileWriter;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class RepairOrderJsonManager {

    public static void save(RepairOrder repairOrder) {

        JSONObject json = new JSONObject(repairOrder);

        try (FileWriter file = new FileWriter("repairOrders.json", true)) {
            file.write(json.toString() + "\n");
            System.out.println(">> Orden de reparación guardada en repairOrders.json");
        } catch (Exception e) {
            System.out.println(">> Error al guardar: " + e.getMessage());
        }
    }
}
