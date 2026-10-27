package ec.edu.espe.tecnizoneapp.testcases;

import ec.edu.espe.tecnizoneapp.model.Invoice;
import ec.edu.espe.tecnizoneapp.model.RepairOrder;
import ec.edu.espe.tecnizoneapp.model.Technician;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class RepairOrderTest {
    
    public RepairOrderTest() {
    }

    @Test
    public void testRepairOrderConstructorAndGetters() {
        LocalDate date = LocalDate.now();
        RepairOrder order = new RepairOrder("ORD-001", null, null, null, "Pending", date, 50.0, 30.0, 80.0);
        
        assertEquals("ORD-001", order.getOrderNumber());
        assertEquals("Pending", order.getCurrentStatus());
        assertEquals(50.0, order.getLaborCost(), 0.01);
        assertEquals(30.0, order.getPartsCost(), 0.01);
        assertEquals(80.0, order.getTotalAmount(), 0.01);
    }

    @Test
    public void testCalculateTotalCost_Success() {
        LocalDate date = LocalDate.now();
        RepairOrder order = new RepairOrder("ORD-002", null, null, null, "In Progress", date, 100.0, 50.0, 0.0);
        order.calculateTotalCost();
        
        assertEquals(150.0, order.getTotalAmount(), 0.01);
    }

    @Test
    public void testAssignTechnician_Success() {
        LocalDate date = LocalDate.now();
        RepairOrder order = new RepairOrder("ORD-003", null, null, null, "Pending", date, 40.0, 10.0, 50.0);
        Technician tech = new Technician("TECH-001", "Carlos Andrade", "Hardware");
        order.assignTechnician(tech);
        
        assertEquals(tech, order.getAssignedTech());
    }

    @Test
    public void testGenerateInvoice_Success() {
        LocalDate date = LocalDate.now();
        RepairOrder order = new RepairOrder("ORD-004", null, null, null, "Completed", date, 60.0, 40.0, 100.0);
        Invoice invoice = order.generateInvoice();
        
        assertNotNull(invoice);
        assertEquals(100.0, invoice.getFinalTotal(), 0.01);
    }

    @Test
    public void testSetCurrentStatus_Success() {
        LocalDate date = LocalDate.now();
        RepairOrder order = new RepairOrder("ORD-005", null, null, null, "Pending", date, 30.0, 20.0, 50.0);
        order.setCurrentStatus("Finished");
        
        assertEquals("Finished", order.getCurrentStatus());
    }

    @Test
    public void testSetLaborCost_TriggersRecalculation() {
        LocalDate date = LocalDate.now();
        RepairOrder order = new RepairOrder("ORD-006", null, null, null, "Pending", date, 20.0, 20.0, 40.0);
        order.setLaborCost(80.0);
        
        assertEquals(100.0, order.getTotalAmount(), 0.01);
    }

    @Test
    public void testRepairOrder_ObjectNotNull() {
        LocalDate date = LocalDate.now();
        RepairOrder order = new RepairOrder("ORD-007", null, null, null, "Pending", date, 10.0, 10.0, 20.0);
        
        assertNotNull(order);
        assertNotNull(order.getOrderNumber());
    }

    @Test
    public void testRepairOrder_NumberNotEqualsWrong() {
        LocalDate date = LocalDate.now();
        RepairOrder order = new RepairOrder("ORD-008", null, null, null, "Pending", date, 25.0, 25.0, 50.0);
        
        assertNotEquals("ORD-999", order.getOrderNumber());
    }

    @Test
    public void testRepairOrder_IntentionalFailureTotalAmount() {
        LocalDate date = LocalDate.now();
        RepairOrder order = new RepairOrder("ORD-009", null, null, null, "Pending", date, 50.0, 50.0, 100.0);
        
        assertEquals(500.0, order.getTotalAmount(), 0.01);
    }

    @Test
    public void testRepairOrder_IntentionalFailureStatus() {
        LocalDate date = LocalDate.now();
        RepairOrder order = new RepairOrder("ORD-010", null, null, null, "In Progress", date, 30.0, 30.0, 60.0);

        assertEquals("Cancelled", order.getCurrentStatus());
    }
}
