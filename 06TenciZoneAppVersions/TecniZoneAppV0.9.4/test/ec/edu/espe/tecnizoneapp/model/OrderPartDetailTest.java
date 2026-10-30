/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class OrderPartDetailTest {

    private OrderPartDetail detail;
    private Part samplePart;

    @Before
    public void setUp() {

        samplePart = new Part("P001", "Pantalla LED", 10, 2, 50.0);
        detail = new OrderPartDetail("DET-001", null, samplePart, 3);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("DET-001", detail.getDetailId());
        assertNull(detail.getOrder());
        assertEquals(samplePart, detail.getUsedPart());
        assertEquals(3, detail.getQuantityUsed());
        assertEquals(150.0, detail.getSubtotal(), 0.001);
    }

    @Test
    public void testSetDetailId() {
        detail.setDetailId("DET-002");
        assertEquals("DET-002", detail.getDetailId());
    }

    @Test
    public void testSetOrder() {
        detail.setOrder(null);
        assertNull(detail.getOrder());
    }

    @Test
    public void testSetUsedPart() {
        Part newPart = new Part("P002", "Batería", 5, 1, 30.0);
        detail.setUsedPart(newPart);
        assertEquals(newPart, detail.getUsedPart());
    }

    @Test
    public void testSetQuantityUsed() {
        detail.setQuantityUsed(5);
        assertEquals(5, detail.getQuantityUsed());
    }

    @Test
    public void testSetSubtotal() {
        detail.setSubtotal(250.0);
        assertEquals(250.0, detail.getSubtotal(), 0.001);
    }

    @Test
    public void testCalculateSubtotalWithPart() {
        double calculated = detail.calculateSubtotal();
        assertEquals(150.0, calculated, 0.001);
    }

    @Test
    public void testCalculateSubtotalWithNullPart() {
        OrderPartDetail emptyDetail = new OrderPartDetail("DET-002", null, null, 2);
        assertEquals(0.0, emptyDetail.calculateSubtotal(), 0.001);
    }

    @Test
    public void testFailingCaseQuantityValidation() {
        assertEquals(10, detail.getQuantityUsed());
    }

    @Test
    public void testFailingCaseSubtotalValidation() {
        assertEquals(500.0, detail.getSubtotal(), 0.001);
    }
}