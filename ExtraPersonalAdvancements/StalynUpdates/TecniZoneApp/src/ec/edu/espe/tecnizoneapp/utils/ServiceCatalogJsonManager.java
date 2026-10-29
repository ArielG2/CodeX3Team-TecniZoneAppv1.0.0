package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.ServiceCatalog;
import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class ServiceCatalogJsonManager {

    public static void save(ServiceCatalog serviceCatalog) {
        JSONObject json = new JSONObject();
        json.put("serviceCode", serviceCatalog.getServiceCode());
        json.put("serviceName", serviceCatalog.getServiceName());
        json.put("fixedLaborCost", serviceCatalog.getFixedLaborCost());

        File fileObj = new File("C:\\Users\\ARIEL\\OneDrive\\Escritorio\\proyecto\\CodeX3Team-TecniZoneAppv1.0.0\\TecniZoneAppV0.9.0\\TecniZone");

        try (FileWriter file = new FileWriter(fileObj, true)) {
            file.write(json.toString() + "\n");
            file.flush();
        } catch (Exception e) {
            System.out.println(">> Error al guardar servicio: " + e.getMessage());
        }
    }
}