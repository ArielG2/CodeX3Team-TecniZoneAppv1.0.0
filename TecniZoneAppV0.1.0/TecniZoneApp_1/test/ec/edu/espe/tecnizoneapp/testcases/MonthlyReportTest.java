/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class MonthlyReportTest {

    private MonthlyReport report;

    @Before
    public void setUp() {
        report = new MonthlyReport("REP-001", "Octubre 2026", 12, 1500.5);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("REP-001", report.getReportId());
        assertEquals("Octubre 2026", report.getMonthAndYear());
        assertEquals(12, report.getTotalCompletedRepairs());
        assertEquals(1500.5, report.getTotalMoneyCollected(), 0.001);
    }

    @Test
    public void testSetReportId() {
        report.setReportId("REP-002");
        assertEquals("REP-002", report.getReportId());
    }

    @Test
    public void testSetMonthAndYear() {
        report.setMonthAndYear("Noviembre 2026");
        assertEquals("Noviembre 2026", report.getMonthAndYear());
    }

    @Test
    public void testSetTotalCompletedRepairs() {
        report.setTotalCompletedRepairs(20);
        assertEquals(20, report.getTotalCompletedRepairs());
    }

    @Test
    public void testSetTotalMoneyCollected() {
        report.setTotalMoneyCollected(2300.75);
        assertEquals(2300.75, report.getTotalMoneyCollected(), 0.001);
    }

    @Test
    public void testCompileMonthlyDataUpdatesFields() {
        report.compileMonthlyData("Noviembre", 2026);
        assertEquals("Noviembre 2026", report.getMonthAndYear());
        assertEquals(0, report.getTotalCompletedRepairs());
        assertEquals(0.0, report.getTotalMoneyCollected(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompileMonthlyDataInvalidMonthThrowsException() {
        report.compileMonthlyData("   ", 2026);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompileMonthlyDataInvalidYearThrowsException() {
        report.compileMonthlyData("Octubre", 0);
    }

    @Test
    public void testExportToText() {
        String text = report.exportToText();
        assertTrue(text.contains("ID Del Reporte: REP-001"));
        assertTrue(text.contains("Mes y Anio: Octubre 2026"));
        assertTrue(text.contains("Reparaciones Completadas: 12"));
        assertTrue(text.contains("Dinero Recolectado: $1500.5"));
    }

    @Test
    public void testToStringFormat() {
        String result = report.toString();
        assertTrue(result.contains("REP-001"));
        assertTrue(result.contains("Octubre 2026"));
        assertTrue(result.contains("12"));
        assertTrue(result.contains("1500.5"));
    }
}