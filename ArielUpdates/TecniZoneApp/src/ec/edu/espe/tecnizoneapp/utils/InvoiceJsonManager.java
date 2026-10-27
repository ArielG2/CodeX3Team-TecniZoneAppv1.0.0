package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.Invoice;
import org.json.JSONObject;
import java.io.FileWriter;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class InvoiceJsonManager {

    public static void save(Invoice invoice) {
       
        JSONObject json = new JSONObject(invoice);

        try (FileWriter file = new FileWriter("invoices.json", true)) {
            file.write(json.toString() + "\n");
            System.out.println(">> Factura guardada en invoices.json");
        } catch (Exception e) {
            System.out.println(">> Error al guardar: " + e.getMessage());
        }
    }
}
