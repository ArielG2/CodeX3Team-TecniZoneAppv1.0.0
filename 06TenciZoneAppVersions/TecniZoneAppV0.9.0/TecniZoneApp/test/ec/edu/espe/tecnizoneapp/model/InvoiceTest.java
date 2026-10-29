/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.model;

import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class InvoiceTest {

    private Invoice invoice;
    private LocalDateTime sampleDate;

    @Before
    public void setUp() {
        sampleDate = LocalDateTime.of(2026, 6, 1, 10, 30);
        invoice = new Invoice("INV-001", null, sampleDate, 150.00, "Cash");
    }

    @Test
    public void testInvoiceConstructorAndGetters() {
        assertEquals("INV-001", invoice.getInvoiceNumber());
        assertNull(invoice.getRepairOrder());
        assertEquals(sampleDate, invoice.getIssueDate());
        assertEquals(150.00, invoice.getFinalTotal(), 0.001);
        assertEquals("Cash", invoice.getPaymentMethod());
    }

    @Test
    public void testSetInvoiceNumber() {
        invoice.setInvoiceNumber("INV-002");

        assertEquals("INV-999", invoice.getInvoiceNumber());
    }

    @Test
    public void testSetRepairOrder() {
        invoice.setRepairOrder(null);
        assertNull(invoice.getRepairOrder());
    }

    @Test
    public void testSetIssueDate() {
        LocalDateTime newDate = LocalDateTime.of(2026, 6, 2, 12, 0);
        invoice.setIssueDate(newDate);
        assertEquals(newDate, invoice.getIssueDate());
    }

    @Test
    public void testSetFinalTotal() {
        invoice.setFinalTotal(275.50);

        assertEquals(300.00, invoice.getFinalTotal(), 0.001);
    }

    @Test
    public void testSetPaymentMethod() {
        invoice.setPaymentMethod("Credit Card");
        assertEquals("Credit Card", invoice.getPaymentMethod());
    }

    @Test
    public void testProcessPaymentUpdatesMethod() {
        invoice.processPayment("Transferencia Bancaria");
        assertEquals("Transferencia Bancaria", invoice.getPaymentMethod());
    }

    @Test
    public void testProcessPaymentWithDifferentMethod() {
        invoice.processPayment("PayPal");
        assertEquals("PayPal", invoice.getPaymentMethod());
    }

    @Test
    public void testPrintReceiptExecution() {
        try {
            invoice.printReceipt();
        } catch (Exception e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }

    @Test
    public void testSaveToJsonExecution() {
        try {
            invoice.saveToJson();
        } catch (Exception e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }
}
