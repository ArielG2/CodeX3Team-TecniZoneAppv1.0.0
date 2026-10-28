package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.StockAlert;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class StockAlertCsvManager {

    public static void save(StockAlert alert) {
        File file = new File("stockAlerts.csv");
        boolean exists = file.exists();

        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            if (!exists) {
                writer.println("alertId,affectedPartCode,triggerDate,alertMessage,isResolved");
            }
            String partCode = (alert.getAffectedPart() != null) ? alert.getAffectedPart().getCode() : "";

            writer.println(alert.getAlertId() + "," +
                    partCode + "," +
                    alert.getTriggerDate() + "," +
                    alert.getAlertMessage() + "," +
                    alert.isIsResolved());
            System.out.println(">> Alerta de stock guardada en stockAlerts.csv");
        } catch (Exception e) {
            System.out.println(">> Error al guardar: " + e.getMessage());
        }
    }
}
