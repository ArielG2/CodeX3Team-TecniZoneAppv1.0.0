/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */

public class PartTest {
    
    public PartTest() {
    }



    @Test
    public void testPartConstructorAndGetters() {

        Part part = new Part("PRT-001", "Pantalla LED", 20, 5, 120.00);
        
        assertEquals("PRT-001", part.getPartId());
        assertEquals("Pantalla LED", part.getPartName());
        assertEquals(20, part.getStockQuantity());
        assertEquals(5, part.getMinimumStock());
        assertEquals(120.00, part.getUnitPrice(), 0.01);
    }

    @Test
    public void testSetPartName_Success() {

        Part part = new Part("PRT-002", "Batería", 10, 2, 45.00);
        part.setPartName("Batería de Litio");
        
        assertEquals("Batería de Litio", part.getPartName());
    }

    @Test
    public void testAddStock_Success() {

        Part part = new Part("PRT-003", "Teclado", 15, 3, 25.00);
        part.addStock(10);
        
        assertEquals(25, part.getStockQuantity());
    }

    @Test
    public void testReduceStock_Success() {

        Part part = new Part("PRT-004", "Mouse", 30, 5, 15.00);
        part.reduceStock(10);
        
        assertEquals(20, part.getStockQuantity());
    }

    @Test
    public void testCheckMinimumStock_AlertGenerated() {

        Part part = new Part("PRT-005", "Disco Duro", 3, 5, 80.00);
        StockAlert alert = part.checkMinimumStock();
        
        assertNotNull(alert);
    }

    @Test
    public void testSetUnitPrice_Success() {

        Part part = new Part("PRT-006", "Cable HDMI", 50, 10, 10.00);
        part.setUnitPrice(12.50);
        
        assertEquals(12.50, part.getUnitPrice(), 0.01);
    }

    @Test
    public void testPart_ObjectNotNull() {

        Part part = new Part("PRT-007", "Cargador", 12, 4, 30.00);
        
        assertNotNull(part);
        assertNotNull(part.getPartId());
    }

    @Test
    public void testPart_IdNotEqualsWrong() {

        Part part = new Part("PRT-008", "Parlante", 8, 2, 20.00);
        
        assertNotEquals("PRT-000", part.getPartId());
    }



    @Test
    public void testPart_IntentionalFailureUnitPrice() {

        Part part = new Part("PRT-009", "Memoria RAM", 10, 2, 60.00);
        
        // Forzamos el fallo esperando 999.0 cuando el real es 60.0
        assertEquals(999.00, part.getUnitPrice(), 0.01);
    }

    @Test
    public void testPart_IntentionalFailureStock() {

        Part part = new Part("PRT-010", "Tarjeta Madre", 5, 1, 150.00);
        
        assertEquals(500, part.getStockQuantity());
    }
}