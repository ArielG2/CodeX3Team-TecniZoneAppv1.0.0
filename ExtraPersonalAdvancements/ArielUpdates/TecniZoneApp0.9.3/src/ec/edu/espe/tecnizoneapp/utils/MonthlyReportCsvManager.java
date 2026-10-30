package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.MonthlyReport;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class MonthlyReportCsvManager {

    public static void save(MonthlyReport report) {
        File file = new File("monthlyReports.csv");
        boolean exists = file.exists();

        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            if (!exists) {
                writer.println("reportId,monthAndYear,totalCompletedRepairs,totalMoneyCollected");
            }
            writer.println(report.getReportId() + "," +
                    report.getMonthAndYear() + "," +
                    report.getTotalCompletedRepairs() + "," +
                    report.getTotalMoneyCollected());
            System.out.println(">> Reporte mensual guardado en monthlyReports.csv");
        } catch (Exception e) {
            System.out.println(">> Error al guardar: " + e.getMessage());
        }
    }
}
