package ec.edu.espe.tecnizoneapp.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class MonthlyReportTest {

    private MonthlyReport monthlyReport;

    @Before
    public void setUp() {
        monthlyReport = new MonthlyReport("REP-001", "Junio 2026", 15, 1250.50);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("REP-001", monthlyReport.getReportId());
        assertEquals("Junio 2026", monthlyReport.getMonthAndYear());
        assertEquals(15, monthlyReport.getTotalCompletedRepairs());
        assertEquals(1250.50, monthlyReport.getTotalMoneyCollected(), 0.001);
    }

    @Test
    public void testSetReportId() {
        monthlyReport.setReportId("REP-002");
        assertEquals("REP-002", monthlyReport.getReportId());
    }

    @Test
    public void testSetMonthAndYear() {
        monthlyReport.setMonthAndYear("Julio 2026");
        assertEquals("Julio 2026", monthlyReport.getMonthAndYear());
    }

    @Test
    public void testSetTotalCompletedRepairs() {
        monthlyReport.setTotalCompletedRepairs(20);
        assertEquals(20, monthlyReport.getTotalCompletedRepairs());
    }

    @Test
    public void testSetTotalMoneyCollected() {
        monthlyReport.setTotalMoneyCollected(1800.0);
        assertEquals(1800.0, monthlyReport.getTotalMoneyCollected(), 0.001);
    }

    @Test
    public void testCompileMonthlyDataValid() {
        monthlyReport.compileMonthlyData("Agosto", 2026);
        assertEquals("Agosto 2026", monthlyReport.getMonthAndYear());
        assertEquals(0, monthlyReport.getTotalCompletedRepairs());
        assertEquals(0.0, monthlyReport.getTotalMoneyCollected(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompileMonthlyDataInvalidMonthThrowsException() {
        monthlyReport.compileMonthlyData("", 2026);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompileMonthlyDataInvalidYearThrowsException() {
        monthlyReport.compileMonthlyData("Agosto", 0);
    }

    @Test
    public void testExportToText() {
        String exported = monthlyReport.exportToText();
        assertNotNull(exported);
        assertTrue(exported.contains("REP-001"));
        assertTrue(exported.contains("Junio 2026"));
        assertTrue(exported.contains("15"));
    }

    @Test
    public void testToStringFormat() {
        String result = monthlyReport.toString();
        assertTrue(result.contains("REP-001"));
        assertTrue(result.contains("Junio 2026"));
    }

    @Test
    public void testFailingCaseReportId() {
        assertEquals("REP-999", monthlyReport.getReportId());
    }

    @Test
    public void testFailingCaseTotalMoneyCollected() {
        assertEquals(9999.99, monthlyReport.getTotalMoneyCollected(), 0.001);
    }
}