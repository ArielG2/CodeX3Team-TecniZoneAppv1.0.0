/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.testcases;

import ec.edu.espe.tecnizoneapp.model.Part;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class PartTest {

    private Part part;

    @Before
    public void setUp() {
        part = new Part("P001", "Pantalla LED", 10, 2, 50.0);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("P001", part.getPartId());
        assertEquals("Pantalla LED", part.getPartName());
        assertEquals(10, part.getStockQuantity());
        assertEquals(2, part.getMinimumStock());
        assertEquals(50.0, part.getUnitPrice(), 0.001);
    }

    @Test
    public void testSetPartIdAndPartName() {
        part.setPartId("P002");
        part.setPartName("Bateria");
        assertEquals("P002", part.getPartId());
        assertEquals("Bateria", part.getPartName());
    }

    @Test
    public void testSetStockMinimumAndPrice() {
        part.setStockQuantity(20);
        part.setMinimumStock(5);
        part.setUnitPrice(75.5);
        assertEquals(20, part.getStockQuantity());
        assertEquals(5, part.getMinimumStock());
        assertEquals(75.5, part.getUnitPrice(), 0.001);
    }

    @Test
    public void testReduceStockValid() {
        part.reduceStock(3);
        assertEquals(7, part.getStockQuantity());
    }

    @Test
    public void testReduceStockInsufficientKeepsStock() {
        part.reduceStock(15);
        assertEquals(10, part.getStockQuantity());
    }

    @Test
    public void testAddStock() {
        part.addStock(5);
        assertEquals(15, part.getStockQuantity());
    }

    @Test
    public void testCheckMinimumStock() {
        assertNull(part.checkMinimumStock());
        part.setStockQuantity(2);
        assertNotNull(part.checkMinimumStock());
    }

    @Test
    public void testToStringFormat() {
        String result = part.toString();
        assertTrue(result.contains("P001"));
        assertTrue(result.contains("Pantalla LED"));
        assertTrue(result.contains("50.0"));
    }

    @Test
    public void testFailingCaseUnitPrice() {
        assertEquals(100.0, part.getUnitPrice(), 0.001);
    }

    @Test
    public void testFailingCaseReduceStock() {
        part.reduceStock(3);
        assertEquals(10, part.getStockQuantity());
    }
}