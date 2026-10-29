package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.DirectSale;
import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class DirectSaleJsonManager {

    public static void save(DirectSale directSale) {
        JSONObject json = new JSONObject();
        json.put("saleId", directSale.getSaleId());
        json.put("saleDate", directSale.getSaleDate());
        json.put("totalAmount", directSale.getTotalAmount());
        
        if (directSale.getClient() != null) {
            json.put("clientId", directSale.getClient().getClientId());
        }

        File fileObj = new File("directSales.json");

        try (FileWriter file = new FileWriter(fileObj, true)) {
            file.write(json.toString() + "\n");
            file.flush();
            System.out.println(">> Venta directa guardada en: " + fileObj.getAbsolutePath());
        } catch (Exception e) {
            System.out.println(">> Error al guardar venta directa: " + e.getMessage());
        }
    }
}
