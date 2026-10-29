package ec.edu.espe.tecnizoneapp.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CodeX3Team, @ESPE
 */
public class PartTest {

    private Part part;

    @Before
    public void setUp() {
        part = new Part("P001", "Pantalla LED", 10, 2, 50.0);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("P001", part.getCode());
        assertEquals("Pantalla LED", part.getName());
        assertEquals(10, part.getCurrentStock());
        assertEquals(2, part.getMinStock());
        assertEquals(50.0, part.getPrice(), 0.001);
    }

    @Test
    public void testIncreaseStock() {
        part.increaseStock(5);
        assertEquals(15, part.getCurrentStock());
    }

    @Test
    public void testDecreaseStock() {
        part.decreaseStock(3);
        assertEquals(7, part.getCurrentStock());
    }

    @Test
    public void testVerifyLowStockTriggersAlert() {
        part.setCurrentStock(1);
        StockAlert alert = part.verifyLowStock();
        assertNotNull(alert);
    }

    @Test
    public void testVerifyLowStockNoAlert() {
        part.setCurrentStock(10);
        StockAlert alert = part.verifyLowStock();
        assertNull(alert);
    }
}