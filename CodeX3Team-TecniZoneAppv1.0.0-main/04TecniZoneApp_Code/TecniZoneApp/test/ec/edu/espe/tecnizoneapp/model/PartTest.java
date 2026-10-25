package ec.edu.espe.tecnizoneapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PartTest {

    private Part ram;

    @BeforeEach
    public void setUp() {
        ram = new Part("part02", "Ram8gb", 10, 3, 25.0);
    }

    @Test
    public void PRT01_creacionConAtributosCorrectos() {
        assertEquals("part02", ram.getPartId());
        assertEquals("Ram8gb", ram.getPartName());
        assertEquals(10, ram.getStockQuantity());
        assertEquals(3, ram.getMinimumStock());
        assertEquals(25.0, ram.getUnitPrice());
    }

    @Test
    public void PRT02_reduceStockDescuentaCantidad() {
        ram.reduceStock(2);
        assertEquals(8, ram.getStockQuantity());
    }

    @Test
    public void PRT03_reduceStockHastaCero() {
        ram.reduceStock(10);
        assertEquals(0, ram.getStockQuantity());
    }

    @Test
    public void PRT04_reduceStockMayorAlStockNoCambia() {
        ram.reduceStock(15);
        assertEquals(10, ram.getStockQuantity());
    }

    @Test
    public void PRT05_reduceStockCeroONegativoNoCambia() {
        ram.reduceStock(0);
        ram.reduceStock(-1);
        assertEquals(10, ram.getStockQuantity());
    }

    @Test
    public void PRT06_addStockSumaCantidad() {
        ram.addStock(5);
        assertEquals(15, ram.getStockQuantity());
    }

    @Test
    public void PRT07_addStockNegativoSeResta() {
        ram.addStock(-3);
        assertEquals(7, ram.getStockQuantity());
    }

    @Test
    public void PRT08_stockBajoGeneraAlerta() {
        ram.reduceStock(8);
        assertNotNull(ram.checkMinimumStock());
    }

    @Test
    public void PRT09_stockIgualAlMinimoGeneraAlerta() {
        ram.reduceStock(7);
        assertEquals(3, ram.getStockQuantity());
        assertNotNull(ram.checkMinimumStock());
    }

    @Test
    public void PRT10_stockSuficienteNoGeneraAlerta() {
        assertNull(ram.checkMinimumStock());
    }
}