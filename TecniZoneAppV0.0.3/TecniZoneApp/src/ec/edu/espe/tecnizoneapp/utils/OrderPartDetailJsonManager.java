package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.OrderPartDetail;
import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class OrderPartDetailJsonManager {

    public static void save(OrderPartDetail orderPartDetail) {
        JSONObject json = new JSONObject();
        json.put("detailId", orderPartDetail.getDetailId());
        json.put("quantityUsed", orderPartDetail.getQuantityUsed());
        json.put("subtotal", orderPartDetail.getSubtotal());

        if (orderPartDetail.getOrder() != null) {
            json.put("orderNumber", orderPartDetail.getOrder().getOrderNumber());
        }
        
        if (orderPartDetail.getUsedPart() != null) {
            json.put("usedPartInfo", orderPartDetail.getUsedPart().toString());
        }

        File fileObj = new File("C:\\Users\\Mateo\\Documents\\ObjectOrientedProgramming\\CodeX3Team-TecniZoneAppv1.0.0\\StalynUpdates\\TecniZoneApp\\orderPartDetails.json");

        try (FileWriter file = new FileWriter(fileObj, true)) {
            file.write(json.toString() + "\n");
            file.flush();
            System.out.println(">> Detalle de repuesto guardado en: " + fileObj.getAbsolutePath());
        } catch (Exception e) {
            System.out.println(">> Error al guardar detalle de repuesto: " + e.getMessage());
        }
    }
}
