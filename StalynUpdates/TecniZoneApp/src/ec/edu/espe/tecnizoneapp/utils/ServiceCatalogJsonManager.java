package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.ServiceCatalog;
import org.json.JSONObject;
import java.io.FileWriter;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class ServiceCatalogJsonManager {

    public static void save(ServiceCatalog serviceCatalog) {

        JSONObject json = new JSONObject(serviceCatalog);

        try (FileWriter file = new FileWriter("serviceCatalog.json", true)) {
            file.write(json.toString() + "\n");
            System.out.println(">> Servicio del catálogo guardado en serviceCatalog.json");
        } catch (Exception e) {
            System.out.println(">> Error al guardar: " + e.getMessage());
        }
    }
}
