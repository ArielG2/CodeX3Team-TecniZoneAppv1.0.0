package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.StatusLog;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class StatusLogCsvManager {

    public static void save(StatusLog log) {
        File file = new File("statusLogs.csv");
        boolean exists = file.exists();

        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            if (!exists) {
                writer.println("logId,orderNumber,statusChangedTo,changeTimestamp,changedByUser");
            }
            String orderNum = (log.getOrder() != null) ? log.getOrder().getOrderNumber() : "";
            String username = (log.getChangedByUser() != null) ? log.getChangedByUser().getUsername() : "";

            writer.println(log.getLogId() + "," +
                    orderNum + "," +
                    log.getStatusChangedTo() + "," +
                    log.getChangeTimestamp() + "," +
                    username);
            System.out.println(">> Log de estado guardado en statusLogs.csv");
        } catch (Exception e) {
            System.out.println(">> Error al guardar: " + e.getMessage());
        }
    }
}
