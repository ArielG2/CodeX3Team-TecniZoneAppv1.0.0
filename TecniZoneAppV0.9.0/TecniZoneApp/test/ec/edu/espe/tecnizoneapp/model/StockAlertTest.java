package ec.edu.espe.tecnizoneapp.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class StockAlertTest {

    private StockAlert stockAlert;
    private Part samplePart;

    @Before
    public void setUp() {
        samplePart = new Part("P001", "Pantalla LED", 2, 5, 45.0);
        stockAlert = new StockAlert("ALT-001", samplePart, "2026-06-01", "Stock por debajo del minimo", false);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("ALT-001", stockAlert.getAlertId());
        assertEquals(samplePart, stockAlert.getAffectedPart());
        assertEquals("2026-06-01", stockAlert.getTriggerDate());
        assertEquals("Stock por debajo del minimo", stockAlert.getAlertMessage());
        assertFalse(stockAlert.isIsResolved());
    }

    @Test
    public void testSetAlertId() {
        stockAlert.setAlertId("ALT-002");
        assertEquals("ALT-002", stockAlert.getAlertId());
    }

    @Test
    public void testSetAffectedPart() {
        Part newPart = new Part("P002", "Bateria HP", 1, 3, 30.0);
        stockAlert.setAffectedPart(newPart);
        assertEquals(newPart, stockAlert.getAffectedPart());
    }

    @Test
    public void testSetTriggerDate() {
        stockAlert.setTriggerDate("2026-06-02");
        assertEquals("2026-06-02", stockAlert.getTriggerDate());
    }

    @Test
    public void testSetAlertMessage() {
        stockAlert.setAlertMessage("Alerta critica de inventario");
        assertEquals("Alerta critica de inventario", stockAlert.getAlertMessage());
    }

    @Test
    public void testSetIsResolved() {
        stockAlert.setIsResolved(true);
        assertTrue(stockAlert.isIsResolved());
    }

    @Test
    public void testToStringFormat() {
        String result = stockAlert.toString();
        assertTrue(result.contains("ALT-001"));
        assertTrue(result.contains("2026-06-01"));
        assertTrue(result.contains("Stock por debajo del minimo"));
    }

    @Test
    public void testFailingCaseAlertId() {
        assertEquals("ALT-999", stockAlert.getAlertId());
    }

    @Test
    public void testFailingCaseAlertMessage() {
        assertEquals("Mensaje Incorrecto", stockAlert.getAlertMessage());
    }
}