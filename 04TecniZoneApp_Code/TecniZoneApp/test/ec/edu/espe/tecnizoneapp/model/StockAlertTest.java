/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.model;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class StockAlertTest {
    
    public StockAlertTest() {
    }

    @Test
    public void testStockAlertConstructorAndGetters() {

        LocalDateTime now = LocalDateTime.now();
        StockAlert alert = new StockAlert("ALT-001", null, now, "Stock bajo", false);
        
        assertEquals("ALT-001", alert.getAlertId());
        assertEquals("Stock bajo", alert.getAlertMessage());
        assertFalse(alert.getIsResolved());
        assertEquals(now, alert.getTriggerDate());
    }

    @Test
    public void testSetAlertId_Success() {

        StockAlert alert = new StockAlert("ALT-002", null, LocalDateTime.now(), "Alerta", false);
        alert.setAlertId("ALT-999");
        
        assertEquals("ALT-999", alert.getAlertId());
    }

    @Test
    public void testMarkAsResolved_Success() {

        StockAlert alert = new StockAlert("ALT-003", null, LocalDateTime.now(), "Stock crítico", false);
        alert.markAsResolved(null);
        
        assertTrue(alert.getIsResolved());
    }

    @Test
    public void testSetIsResolved_Success() {

        StockAlert alert = new StockAlert("ALT-004", null, LocalDateTime.now(), "Aviso", false);
        alert.setIsResolved(true);
        
        assertTrue(alert.getIsResolved());
    }

    @Test
    public void testSetAlertMessage_Success() {

        StockAlert alert = new StockAlert("ALT-005", null, LocalDateTime.now(), "Mensaje antiguo", false);
        alert.setAlertMessage("Mensaje actualizado");
        
        assertEquals("Mensaje actualizado", alert.getAlertMessage());
    }

    @Test
    public void testStockAlert_ObjectNotNull() {

        StockAlert alert = new StockAlert("ALT-006", null, LocalDateTime.now(), "Prueba", false);
        
        assertNotNull(alert);
        assertNotNull(alert.getAlertId());
    }

    @Test
    public void testStockAlert_IdNotEqualsWrong() {

        StockAlert alert = new StockAlert("ALT-007", null, LocalDateTime.now(), "Prueba", false);
        
        assertNotEquals("ALT-000", alert.getAlertId());
    }

    @Test
    public void testToString_NotNull() {

        StockAlert alert = new StockAlert("ALT-008", null, LocalDateTime.now(), "Prueba", false);
        
        assertNotNull(alert.toString());
    }

    @Test
    public void testStockAlert_IntentionalFailureResolved() {

        StockAlert alert = new StockAlert("ALT-009", null, LocalDateTime.now(), "Stock bajo", false);

        assertTrue(alert.getIsResolved());
    }

    @Test
    public void testStockAlert_IntentionalFailureMessage() {

        StockAlert alert = new StockAlert("ALT-010", null, LocalDateTime.now(), "Pieza agotada", false);

        assertEquals("Todo en orden", alert.getAlertMessage());
    }
}
