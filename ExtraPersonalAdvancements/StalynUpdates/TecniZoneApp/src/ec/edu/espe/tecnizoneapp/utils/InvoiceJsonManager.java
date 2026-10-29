package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.Invoice;
import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class InvoiceJsonManager {

    public static void save(Invoice invoice) {
        JSONObject json = new JSONObject();
        json.put("invoiceNumber", invoice.getInvoiceNumber());
        
        // Guardamos el número de orden de reparación asociado si existe
        if (invoice.getRepairOrder() != null) {
            json.put("repairOrderNumber", invoice.getRepairOrder().getOrderNumber());
        }
        
        json.put("issueDate", invoice.getIssueDate() != null ? invoice.getIssueDate().toString() : "");
        json.put("finalTotal", invoice.getFinalTotal());
        json.put("paymentMethod", invoice.getPaymentMethod());

        File fileObj = new File("C:\\Users\\ARIEL\\OneDrive\\Escritorio\\proyecto\\CodeX3Team-TecniZoneAppv1.0.0\\TecniZoneAppV0.9.0\\TecniZone");

        try (FileWriter file = new FileWriter(fileObj, true)) {
            file.write(json.toString() + "\n");
            file.flush();
            System.out.println(">> Factura guardada en: " + fileObj.getAbsolutePath());
        } catch (Exception e) {
            System.out.println(">> Error al guardar factura: " + e.getMessage());
        }
    }
}