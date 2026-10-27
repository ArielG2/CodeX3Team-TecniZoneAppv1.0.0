package ec.edu.espe.tecnizoneapp.testcases;

import ec.edu.espe.tecnizoneapp.model.Invoice;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */

public class InvoiceTest {
    
    public InvoiceTest() {
    }

    @Test
    public void testInvoiceConstructorAndGetters() {
        System.out.println("Buena 1: Constructor y Getters de Factura");
        LocalDateTime now = LocalDateTime.now();
        Invoice invoice = new Invoice("INV-001", null, now, 150.00, "Cash");
        
        assertEquals("INV-001", invoice.getInvoiceNumber());
        assertEquals(150.00, invoice.getFinalTotal(), 0.01);
        assertEquals("Cash", invoice.getPaymentMethod());
        assertEquals(now, invoice.getIssueDate());
    }

    @Test
    public void testSetInvoiceNumber_Success() {

        Invoice invoice = new Invoice("INV-002", null, LocalDateTime.now(), 100.00, "Card");
        invoice.setInvoiceNumber("INV-999");
        
        assertEquals("INV-999", invoice.getInvoiceNumber());
    }

    @Test
    public void testSetFinalTotal_Success() {

        Invoice invoice = new Invoice("INV-003", null, LocalDateTime.now(), 50.00, "Cash");
        invoice.setFinalTotal(250.50);
        
        assertEquals(250.50, invoice.getFinalTotal(), 0.01);
    }

    @Test
    public void testProcessPayment_Success() {

        Invoice invoice = new Invoice("INV-004", null, null, 200.00, "Pending");
        invoice.processPayment("Credit Card");
        
        assertEquals("Credit Card", invoice.getPaymentMethod());
        assertNotNull(invoice.getIssueDate());
    }

    @Test
    public void testSetPaymentMethod_Success() {

        Invoice invoice = new Invoice("INV-005", null, LocalDateTime.now(), 75.00, "Cash");
        invoice.setPaymentMethod("Transfer");
        
        assertEquals("Transfer", invoice.getPaymentMethod());
    }

    @Test
    public void testInvoice_ObjectNotNull() {

        Invoice invoice = new Invoice("INV-006", null, LocalDateTime.now(), 300.00, "Cash");
        
        assertNotNull(invoice);
        assertNotNull(invoice.getInvoiceNumber());
    }

    @Test
    public void testInvoice_NumberNotEqualsWrong() {

        Invoice invoice = new Invoice("INV-007", null, LocalDateTime.now(), 120.00, "Cash");
        
        assertNotEquals("INV-000", invoice.getInvoiceNumber());
    }



    @Test
    public void testInvoice_IntentionalFailureTotal() {
        Invoice invoice = new Invoice("INV-008", null, LocalDateTime.now(), 400.00, "Cash");
        
        assertEquals(999.00, invoice.getFinalTotal(), 0.01);
    }

    @Test
    public void testInvoice_IntentionalFailureNumber() {
        Invoice invoice = new Invoice("INV-009", null, LocalDateTime.now(), 50.00, "Cash");
        
        assertEquals("INV-WRONG", invoice.getInvoiceNumber());
    }

    @Test
    public void testInvoice_IntentionalFailurePayment() {
        Invoice invoice = new Invoice("INV-010", null, LocalDateTime.now(), 100.00, "Cash");
        
        assertEquals("Bitcoin", invoice.getPaymentMethod());
    }
}