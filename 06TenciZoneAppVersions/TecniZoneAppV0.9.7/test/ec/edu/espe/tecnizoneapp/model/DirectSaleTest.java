package ec.edu.espe.tecnizoneapp.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class DirectSaleTest {

    private DirectSale directSale;

    @Before
    public void setUp() {
        directSale = new DirectSale("SALE-001", "2026-06-01", 100.0);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("SALE-001", directSale.getSaleId());
        assertEquals("2026-06-01", directSale.getSaleDate());
        assertEquals(100.0, directSale.getTotalAmount(), 0.001);
        assertNull(directSale.getClient());
    }

    @Test
    public void testSetSaleId() {
        directSale.setSaleId("SALE-002");
        assertEquals("SALE-002", directSale.getSaleId());
    }

    @Test
    public void testSetSaleDate() {
        directSale.setSaleDate("2026-06-02");
        assertEquals("2026-06-02", directSale.getSaleDate());
    }

    @Test
    public void testSetTotalAmount() {
        directSale.setTotalAmount(250.0);
        assertEquals(250.0, directSale.getTotalAmount(), 0.001);
    }

    @Test
    public void testSetClient() {
        Client client = new Client("CLI-001", "Ariel Giler", "0991234567");
        directSale.setClient(client);
        assertEquals(client, directSale.getClient());
    }

    @Test
    public void testSellPartSuccess() {
        Part part = new Part("P001", "Pantalla LED", 10, 2, 50.0);
        directSale.sellPart(part, 2);
        assertEquals(200.0, directSale.getTotalAmount(), 0.001);
        assertEquals(8, part.getCurrentStock());
    }

    @Test
    public void testToStringFormat() {
        String result = directSale.toString();
        assertTrue(result.contains("SALE-001"));
        assertTrue(result.contains("2026-06-01"));
    }

    @Test
    public void testFailingCaseSaleId() {
        assertEquals("SALE-999", directSale.getSaleId());
    }

    @Test
    public void testFailingCaseTotalAmount() {
        assertEquals(999.99, directSale.getTotalAmount(), 0.001);
    }
}