package ec.edu.espe.tecnizoneapp.testcases;

import ec.edu.espe.tecnizoneapp.model.MonthlyReport;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */

public class MonthlyReportTest {
    
    public MonthlyReportTest() {
    }


    @Test
    public void testMonthlyReportConstructorAndGetters() {

        MonthlyReport report = new MonthlyReport("REP-001", "October 2026", 15, 1250.50);
        
        assertEquals("REP-001", report.getReportId());
        assertEquals("October 2026", report.getMonthAndYear());
        assertEquals(15, report.getTotalCompletedRepairs());
        assertEquals(1250.50, report.getTotalMoneyCollected(), 0.01);
    }

    @Test
    public void testSetReportId_Success() {

        MonthlyReport report = new MonthlyReport("REP-002", "October 2026", 10, 800.0);
        report.setReportId("REP-999");
        
        assertEquals("REP-999", report.getReportId());
    }

    @Test
    public void testSetMonthAndYear_Success() {

        MonthlyReport report = new MonthlyReport("REP-003", "September 2026", 20, 1500.0);
        report.setMonthAndYear("October 2026");
        
        assertEquals("October 2026", report.getMonthAndYear());
    }

    @Test
    public void testCompileMonthlyData_Success() {

        MonthlyReport report = new MonthlyReport("REP-004", "Old", 5, 300.0);
        report.compileMonthlyData("November", 2026);
        
        assertEquals("November 2026", report.getMonthAndYear());
        assertEquals(0, report.getTotalCompletedRepairs());
        assertEquals(0.0, report.getTotalMoneyCollected(), 0.01);
    }

    @Test
    public void testExportToText_Success() {

        MonthlyReport report = new MonthlyReport("REP-005", "October 2026", 8, 950.0);
        String exportedText = report.exportToText();
        
        assertNotNull(exportedText);
        assertTrue(exportedText.contains("REP-005"));
    }

    @Test
    public void testSetTotals_Success() {

        MonthlyReport report = new MonthlyReport("REP-006", "October 2026", 1, 100.0);
        report.setTotalCompletedRepairs(25);
        report.setTotalMoneyCollected(3400.0);
        
        assertEquals(25, report.getTotalCompletedRepairs());
        assertEquals(3400.0, report.getTotalMoneyCollected(), 0.01);
    }

    @Test
    public void testMonthlyReport_ObjectNotNull() {

        MonthlyReport report = new MonthlyReport("REP-007", "October 2026", 12, 1100.0);
        
        assertNotNull(report);
        assertNotNull(report.getReportId());
    }

    @Test
    public void testMonthlyReport_IdNotEqualsWrong() {

        MonthlyReport report = new MonthlyReport("REP-008", "October 2026", 5, 450.0);
        
        assertNotEquals("REP-000", report.getReportId());
    }

    @Test
    public void testMonthlyReport_IntentionalFailureMoney() {

        MonthlyReport report = new MonthlyReport("REP-009", "October 2026", 10, 2000.0);
        

        assertEquals(9999.0, report.getTotalMoneyCollected(), 0.01);
    }

    @Test
    public void testMonthlyReport_IntentionalFailureRepairs() {
        System.out.println("Falla 2: Esperar una cantidad de reparaciones incorrecta para forzar error");
        MonthlyReport report = new MonthlyReport("REP-010", "October 2026", 14, 1400.0);

        assertEquals(50, report.getTotalCompletedRepairs());
    }
}