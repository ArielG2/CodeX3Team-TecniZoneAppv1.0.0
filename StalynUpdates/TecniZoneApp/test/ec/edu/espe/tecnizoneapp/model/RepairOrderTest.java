/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.model;

import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.*;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class RepairOrderTest {

    private RepairOrder order;
    private Date sampleDate;

    @Before
    public void setUp() {
        sampleDate = new Date();
        order = new RepairOrder("ORD-001", null, null, sampleDate);
    }

    @Test
    public void testConstructorAndInitialValues() {
        assertEquals("ORD-001", order.getOrderNumber());
        assertNull(order.getCustomer());
        assertNull(order.getDevice());
        assertNull(order.getAssignedTech());
        assertEquals("Registrada", order.getCurrentStatus());
        assertEquals(sampleDate, order.getEstimatedDeliveryDate());
        assertEquals(0.0, order.getLaborCost(), 0.001);
        assertEquals(0.0, order.getPartsCost(), 0.001);
        assertEquals(0.0, order.getTotalAmount(), 0.001);
    }

    @Test
    public void testAssignTechnician() {
        Technician tech = new Technician("T001", "Carlos Perez", "Hardware");
        order.assignTechnician(tech);
        assertEquals(tech, order.getAssignedTech());
    }

    @Test
    public void testAddPartToOrder() {
        Part part = new Part("P001", "Disco Duro", 10, 2, 80.0);
        OrderPartDetail detail = order.addPartToOrder(part, 2);
        
        assertNotNull(detail);
        assertEquals(160.0, order.getPartsCost(), 0.001);
        assertEquals(8, part.getCurrentStock());
    }

    @Test
    public void testChangeStatus() {
        SystemUser user = new SystemUser("admin", "password", "Admin");
        StatusLog log = order.changeStatus("En Reparación", user);

        assertEquals("En Reparación", order.getCurrentStatus());
        assertNotNull(log);
        assertEquals("En Reparación", log.getStatusChangedTo());
    }

    @Test
    public void testCalculateTotalCost() {
        order.setLaborCost(50.0);
        order.setPartsCost(100.0);
        double total = order.calculateTotalCost();
        
        assertEquals(150.0, total, 0.001);
        assertEquals(150.0, order.getTotalAmount(), 0.001);
    }

    @Test
    public void testGenerateInvoice() {
        order.setLaborCost(40.0);
        Invoice invoice = order.generateInvoice();

        assertNotNull(invoice);
        assertEquals("INV-ORD-001", invoice.getInvoiceNumber());
        assertEquals(40.0, invoice.getFinalTotal(), 0.001);
    }

    @Test
    public void testSettersAndGetters() {
        order.setOrderNumber("ORD-999");
        assertEquals("ORD-999", order.getOrderNumber());
    }

    @Test
    public void testEstimatedDeliveryDate() {
        Date newDate = new Date(System.currentTimeMillis() + 86400000L);
        order.setEstimatedDeliveryDate(newDate);
        assertEquals(newDate, order.getEstimatedDeliveryDate());
    }

    @Test
    public void testFailingCaseInitialStatus() {
        // Falla intencional: espera "Completada" pero el estado inicial por defecto es "Registrada"
        assertEquals("Completada", order.getCurrentStatus());
    }

    @Test
    public void testFailingCaseLaborCost() {
        // Falla intencional: espera un costo de mano de obra de 200.0 pero por defecto es 0.0
        assertEquals(200.0, order.getLaborCost(), 0.001);
    }
}
