package ec.edu.espe.tecnizoneapp.model;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class MonthlyReport {

    private String reportId;
    private String monthAndYear;
    private int totalCompletedRepairs;
    private double totalMoneyCollected;

    public MonthlyReport(String reportId, String monthAndYear,
            int totalCompletedRepairs, double totalMoneyCollected) {
        this.reportId = reportId;
        this.monthAndYear = monthAndYear;
        this.totalCompletedRepairs = totalCompletedRepairs;
        this.totalMoneyCollected = totalMoneyCollected;
    }

    public void compileMonthlyData(String month, int year) {
        if (month == null || month.trim().isEmpty()
                || year <= 0) {
            throw new IllegalArgumentException(
                    "A valid month and year are required.");
        }

        this.monthAndYear = month + " " + year;

        // Actualizar los totales al conectar los datos
        // de las ordenes completadas y los pagos recibidos.
        this.totalCompletedRepairs = 0;
        this.totalMoneyCollected = 0.0;
    }

    public String exportToText() {
        return "========== Reporte Mensual ==========\n"
                + "ID Del Reporte: " + reportId + "\n"
                + "Mes y Anio: " + monthAndYear + "\n"
                + "Reparaciones Completadas: " + totalCompletedRepairs + "\n"
                + "Dinero Recolectado: $" + totalMoneyCollected + "\n"
                + "====================================";
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getMonthAndYear() {
        return monthAndYear;
    }

    public void setMonthAndYear(String monthAndYear) {
        this.monthAndYear = monthAndYear;
    }

    public int getTotalCompletedRepairs() {
        return totalCompletedRepairs;
    }

    public void setTotalCompletedRepairs(int totalCompletedRepairs) {
        this.totalCompletedRepairs = totalCompletedRepairs;
    }

    public double getTotalMoneyCollected() {
        return totalMoneyCollected;
    }

    public void setTotalMoneyCollected(double totalMoneyCollected) {
        this.totalMoneyCollected = totalMoneyCollected;
    }

    @Override
    public String toString() {
        return "MonthlyReport{" + "reportId=" + reportId
                + ", monthAndYear=" + monthAndYear
                + ", totalCompletedRepairs=" + totalCompletedRepairs
                + ", totalMoneyCollected=" + totalMoneyCollected + '}';
    }
}
