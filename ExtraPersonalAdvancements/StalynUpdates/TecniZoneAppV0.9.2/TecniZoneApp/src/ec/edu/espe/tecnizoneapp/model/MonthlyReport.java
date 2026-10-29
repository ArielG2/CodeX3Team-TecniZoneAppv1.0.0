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

    public MonthlyReport(String reportId, String monthAndYear, int totalCompletedRepairs, double totalMoneyCollected) {
        this.reportId = reportId;
        this.monthAndYear = monthAndYear;
        this.totalCompletedRepairs = totalCompletedRepairs;
        this.totalMoneyCollected = totalMoneyCollected;
    }

    public void compileMonthlyData(String month, int year) {
        if (month == null || month.trim().isEmpty() || year <= 0) {
            throw new IllegalArgumentException("A valid month and year are required.");
        }

        this.monthAndYear = month + " " + year;

        this.totalCompletedRepairs = 0;
        this.totalMoneyCollected = 0.0;
    }

    public String exportToText() {
        return "========== Reporte Mensual ==========\n"
                + "ID Reporte: " + getReportId() + "\n"
                + "Mes y Año: " + getMonthAndYear() + "\n"
                + "Reparaciones Completas: " + getTotalCompletedRepairs() + "\n"
                + "Dinero: $" + getTotalMoneyCollected() + "\n"
                + "====================================";
    }

    /**
     * @return the reportId
     */
    public String getReportId() {
        return reportId;
    }

    /**
     * @param reportId the reportId to set
     */
    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    /**
     * @return the monthAndYear
     */
    public String getMonthAndYear() {
        return monthAndYear;
    }

    /**
     * @param monthAndYear the monthAndYear to set
     */
    public void setMonthAndYear(String monthAndYear) {
        this.monthAndYear = monthAndYear;
    }

    /**
     * @return the totalCompletedRepairs
     */
    public int getTotalCompletedRepairs() {
        return totalCompletedRepairs;
    }

    /**
     * @param totalCompletedRepairs the totalCompletedRepairs to set
     */
    public void setTotalCompletedRepairs(int totalCompletedRepairs) {
        this.totalCompletedRepairs = totalCompletedRepairs;
    }

    /**
     * @return the totalMoneyCollected
     */
    public double getTotalMoneyCollected() {
        return totalMoneyCollected;
    }

    /**
     * @param totalMoneyCollected the totalMoneyCollected to set
     */
    public void setTotalMoneyCollected(double totalMoneyCollected) {
        this.totalMoneyCollected = totalMoneyCollected;
    }

    @Override
    public String toString() {
        return "MonthlyReport{" + "reportId=" + getReportId() + ", monthAndYear=" + getMonthAndYear() + ", totalCompletedRepairs=" + getTotalCompletedRepairs() + ", totalMoneyCollected=" + getTotalMoneyCollected() + '}';
    }
}