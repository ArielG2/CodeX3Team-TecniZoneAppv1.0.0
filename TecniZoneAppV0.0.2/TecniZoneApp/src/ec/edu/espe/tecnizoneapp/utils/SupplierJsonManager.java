package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.Supplier;
import org.json.JSONObject;
import java.io.FileWriter;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class SupplierJsonManager {

    public static void save(Supplier supplier) {

        JSONObject json = new JSONObject(supplier);

        try (FileWriter file = new FileWriter("suppliers.json", true)) {
            file.write(json.toString() + "\n");
            System.out.println(">> Proveedor guardado en suppliers.json");
        } catch (Exception e) {
            System.out.println(">> Error al guardar: " + e.getMessage());
        }
    }
}
