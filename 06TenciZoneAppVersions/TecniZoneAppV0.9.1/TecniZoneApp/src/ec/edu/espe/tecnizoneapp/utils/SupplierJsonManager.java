package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.Supplier;
import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class SupplierJsonManager {

    public static void save(Supplier supplier) {
        JSONObject json = new JSONObject();
        json.put("supplierId", supplier.getSupplierId());
        json.put("companyName", supplier.getCompanyName());
        json.put("contactPhone", supplier.getContactPhone());

        File fileObj = new File("suppliers.json");

        try (FileWriter file = new FileWriter(fileObj, true)) {
            file.write(json.toString() + "\n");
            file.flush();
        } catch (Exception e) {
            System.out.println(">> Error al guardar proveedor: " + e.getMessage());
        }
    }
}
