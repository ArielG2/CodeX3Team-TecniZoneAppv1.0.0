package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.RepairOrder;
import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class RepairOrderJsonManager {

    public static void save(RepairOrder repairOrder) {
        JSONObject json = new JSONObject();
        json.put("orderNumber", repairOrder.getOrderNumber());
        json.put("currentStatus", repairOrder.getCurrentStatus());
        json.put("laborCost", repairOrder.getLaborCost());
        json.put("partsCost", repairOrder.getPartsCost());
        json.put("totalAmount", repairOrder.getTotalAmount());
        
        if (repairOrder.getCustomer() != null) {
            json.put("clientId", repairOrder.getCustomer().getClientId());
        }
        
        if (repairOrder.getDevice() != null) {
            json.put("serialNumber", repairOrder.getDevice().getSerialNumber());
        }

        File fileObj = new File("repairOrders.json");

        try (FileWriter file = new FileWriter(fileObj, true)) {
            file.write(json.toString() + "\n");
            file.flush();
        } catch (Exception e) {
            System.out.println(">> Error al guardar orden de reparación: " + e.getMessage());
        }
    }
}
