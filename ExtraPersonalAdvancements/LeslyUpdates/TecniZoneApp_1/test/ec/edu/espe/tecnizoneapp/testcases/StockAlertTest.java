/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.testcases;

import ec.edu.espe.tecnizoneapp.model.Part;
import ec.edu.espe.tecnizoneapp.model.StockAlert;
import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class StockAlertTest {

    private StockAlert alert;
    private Part samplePart;
    private LocalDateTime sampleDate;

    @Before
    public void setUp() {
        samplePart = new Part("P001", "Pantalla LED", 10, 2, 50.0);
        sampleDate = LocalDateTime.of(2026, 6, 1, 10, 30);
        alert = new StockAlert("ALERT-001", samplePart, sampleDate,
                "Stock bajo para la pieza: Pantalla LED", false);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("ALERT-001", alert.getAlertId());
        assertEquals(samplePart, alert.getAffectedPart());
        assertEquals(sampleDate, alert.getTriggerDate());
        assertEquals("Stock bajo para la pieza: Pantalla LED", alert.getAlertMessage());
        assertFalse(alert.getIsResolved());
    }

    @Test
    public void testSetAlertId() {
        alert.setAlertId("ALERT-002");
        assertEquals("ALERT-002", alert.getAlertId());
    }

    @Test
    public void testSetAffectedPart() {
        Part newPart = new Part("P002", "Bateria", 5, 1, 30.0);
        alert.setAffectedPart(newPart);
        assertEquals(newPart, alert.getAffectedPart());
    }

    @Test
    public void testSetTriggerDate() {
        LocalDateTime newDate = LocalDateTime.of(2026, 6, 2, 12, 0);
        alert.setTriggerDate(newDate);
        assertEquals(newDate, alert.getTriggerDate());
    }

    @Test
    public void testSetAlertMessage() {
        alert.setAlertMessage("Stock critico");
        assertEquals("Stock critico", alert.getAlertMessage());
    }

    @Test
    public void testSetIsResolved() {
        alert.setIsResolved(true);
        assertTrue(alert.getIsResolved());
    }

    @Test
    public void testMarkAsResolvedSetsTrue() {
        alert.markAsResolved(null);
        assertTrue(alert.getIsResolved());
    }

    @Test
    public void testMarkAsResolvedKeepsOtherFields() {
        alert.markAsResolved(null);
        assertEquals("ALERT-001", alert.getAlertId());
        assertEquals(samplePart, alert.getAffectedPart());
        assertEquals("Stock bajo para la pieza: Pantalla LED", alert.getAlertMessage());
    }

    @Test
    public void testToStringFormat() {
        String result = alert.toString();
        assertTrue(result.contains("ALERT-001"));
        assertTrue(result.contains("Pantalla LED"));
        assertTrue(result.contains("isResolved=false"));
    }

    @Test
    public void testAlertGeneratedByPartCheckMinimumStock() {
        samplePart.setStockQuantity(2);
        StockAlert generated = samplePart.checkMinimumStock();
        assertNotNull(generated);
        assertEquals("ALERT-P001", generated.getAlertId());
        assertEquals(samplePart, generated.getAffectedPart());
        assertFalse(generated.getIsResolved());
        assertTrue(generated.getAlertMessage().contains("Pantalla LED"));
    }
}