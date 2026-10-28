/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.testcases;

import ec.edu.espe.tecnizoneapp.model.Client;
import ec.edu.espe.tecnizoneapp.model.DirectSale;
import ec.edu.espe.tecnizoneapp.model.Invoice;
import ec.edu.espe.tecnizoneapp.model.Part;
import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class DirectSaleTest {

    private DirectSale sale;
    private Part samplePart;
    private LocalDateTime sampleDate;

    @Before
    public void setUp() {
        sampleDate = LocalDateTime.of(2026, 6, 1, 10, 30);
        sale = new DirectSale("SALE-001", sampleDate, 100.0);
        samplePart = new Part("P001", "Pantalla LED", 10, 2, 50.0);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("SALE-001", sale.getSaleId());
        assertEquals(sampleDate, sale.getSaleDate());
        assertEquals(100.0, sale.getTotalAmount(), 0.001);
        assertNull(sale.getClient());
    }

    @Test
    public void testSetSaleId() {
        sale.setSaleId("SALE-002");
        assertEquals("SALE-002", sale.getSaleId());
    }

    @Test
    public void testSetSaleDate() {
        LocalDateTime newDate = LocalDateTime.of(2026, 6, 2, 12, 0);
        sale.setSaleDate(newDate);
        assertEquals(newDate, sale.getSaleDate());
    }

    @Test
    public void testSetTotalAmount() {
        sale.setTotalAmount(275.50);
        assertEquals(275.50, sale.getTotalAmount(), 0.001);
    }

    @Test
    public void testSetAndGetClient() {
        Client client = new Client("CLI-001", "Ariel Giler", "0991234567");
        sale.setClient(client);
        assertEquals(client, sale.getClient());
    }

    @Test
    public void testSellPartUpdatesTotalAndDate() {
        sale.sellPart(samplePart, 2);
        assertEquals(200.0, sale.getTotalAmount(), 0.001);
        assertFalse(sampleDate.equals(sale.getSaleDate()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellPartNullPartThrowsException() {
        sale.sellPart(null, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellPartInvalidQuantityThrowsException() {
        sale.sellPart(samplePart, 0);
    }

    @Test
    public void testGenerateInvoice() {
        Invoice invoice = sale.generateInvoice();
        assertNotNull(invoice);
        assertNotNull(invoice.getInvoiceNumber());
        assertNull(invoice.getRepairOrder());
        assertEquals(100.0, invoice.getFinalTotal(), 0.001);
        assertEquals("Pending", invoice.getPaymentMethod());
    }

    @Test
    public void testFailingCaseTotalAmount() {
        assertEquals(500.0, sale.getTotalAmount(), 0.001);
    }
}