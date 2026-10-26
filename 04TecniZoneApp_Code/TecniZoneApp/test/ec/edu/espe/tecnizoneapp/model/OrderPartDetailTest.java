package ec.edu.espe.tecnizoneapp.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */

public class OrderPartDetailTest {
    
    public OrderPartDetailTest() {
    }

    @Test
    public void testOrderPartDetailConstructorAndGetters() {

        OrderPartDetail detail = new OrderPartDetail("DET-001", null, null, 2, 50.0);
        
        assertEquals("DET-001", detail.getDetailId());
        assertEquals(2, detail.getQuantityUsed());
        assertEquals(50.0, detail.getSubtotal(), 0.01);
    }

    @Test
    public void testSetDetailId_Success() {

        OrderPartDetail detail = new OrderPartDetail("DET-002", null, null, 1, 25.0);
        detail.setDetailId("DET-999");
        
        assertEquals("DET-999", detail.getDetailId());
    }

    @Test
    public void testSetQuantityUsed_Success() {

        OrderPartDetail detail = new OrderPartDetail("DET-003", null, null, 1, 15.0);
        detail.setQuantityUsed(4);
        
        assertEquals(4, detail.getQuantityUsed());
    }

    @Test
    public void testSetOrder_Success() {

        OrderPartDetail detail = new OrderPartDetail("DET-004", null, null, 1, 30.0);
        RepairOrder dummyOrder = new RepairOrder("ORD-001", null, null, null, "Under Diagnosis", java.time.LocalDate.now(), 0.0, 0.0, 0.0);
        detail.setOrder(dummyOrder);
        
        assertNotNull(detail.getOrder());
    }

    @Test
    public void testSetUsedPart_Success() {

        OrderPartDetail detail = new OrderPartDetail("DET-005", null, null, 2, 40.0);
        Part dummyPart = new Part("P-001", "Pantalla LCD", 5, 3, 25.0);
        detail.setUsedPart(dummyPart);
        
        assertNotNull(detail.getUsedPart());
    }

    @Test
    public void testOrderPartDetail_ObjectNotNull() {

        OrderPartDetail detail = new OrderPartDetail("DET-006", null, null, 1, 10.0);
        
        assertNotNull(detail);
        assertNotNull(detail.getDetailId());
    }

    @Test
    public void testOrderPartDetail_IdNotEqualsWrong() {

        OrderPartDetail detail = new OrderPartDetail("DET-007", null, null, 3, 90.0);
        
        assertNotEquals("DET-000", detail.getDetailId());
    }

    @Test
    public void testOrderPartDetail_ToStringNotNull() {

        OrderPartDetail detail = new OrderPartDetail("DET-008", null, null, 1, 20.0);
        
        assertNotNull(detail.toString());
    }

    @Test
    public void testOrderPartDetail_IntentionalFailureQuantity() {

        OrderPartDetail detail = new OrderPartDetail("DET-009", null, null, 5, 100.0);
        assertEquals(50, detail.getQuantityUsed());
    }

    @Test
    public void testOrderPartDetail_IntentionalFailureSubtotal() {

        OrderPartDetail detail = new OrderPartDetail("DET-010", null, null, 2, 75.0);
        
        assertEquals(999.0, detail.getSubtotal(), 0.01);
    }
}
