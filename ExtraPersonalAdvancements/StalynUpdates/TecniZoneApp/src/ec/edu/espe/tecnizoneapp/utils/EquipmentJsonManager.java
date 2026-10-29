package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.Equipment;
import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class EquipmentJsonManager {

    public static void save(Equipment equipment) {
        JSONObject json = new JSONObject();
        json.put("serialNumber", equipment.getSerialNumber());
        json.put("deviceType", equipment.getDeviceType());
        json.put("brand", equipment.getBrand());
        json.put("model", equipment.getModel());
        json.put("reportedFaults", equipment.getReportedFaults());

        if (equipment.getOwnerClient() != null) {
            json.put("ownerClientId", equipment.getOwnerClient().getClientId());
        }

        File fileObj = new File("C:\\Users\\ARIEL\\OneDrive\\Escritorio\\proyecto\\CodeX3Team-TecniZoneAppv1.0.0\\TecniZoneAppV0.9.0\\TecniZone");

        try (FileWriter file = new FileWriter(fileObj, true)) {
            file.write(json.toString() + "\n");
            file.flush(); 
            System.out.println(">> Equipo guardado en: " + fileObj.getAbsolutePath());
        } catch (Exception e) {
            System.out.println(">> Error al guardar equipo: " + e.getMessage());
        }
    }
}
