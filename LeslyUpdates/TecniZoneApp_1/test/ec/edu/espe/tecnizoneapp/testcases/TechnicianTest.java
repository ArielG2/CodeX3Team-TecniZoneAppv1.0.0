/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.testcases;

import ec.edu.espe.tecnizoneapp.model.Technician;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class TechnicianTest {

    private Technician technician;

    @Before
    public void setUp() {
        technician = new Technician("TEC-001", "Carlos Mena", "Laptops");
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("TEC-001", technician.getTechnicianId());
        assertEquals("Carlos Mena", technician.getFullName());
        assertEquals("Laptops", technician.getSpecialty());
    }

    @Test
    public void testSetTechnicianId() {
        technician.setTechnicianId("TEC-002");
        assertEquals("TEC-002", technician.getTechnicianId());
    }

    @Test
    public void testSetFullName() {
        technician.setFullName("Luis Andrade");
        assertEquals("Luis Andrade", technician.getFullName());
    }

    @Test
    public void testSetSpecialty() {
        technician.setSpecialty("Smartphones");
        assertEquals("Smartphones", technician.getSpecialty());
    }

    @Test
    public void testUpdateSpecialty() {
        technician.updateSpecialty("Impresoras");
        assertEquals("Impresoras", technician.getSpecialty());
    }

    @Test
    public void testUpdateSpecialtyKeepsOtherFields() {
        technician.updateSpecialty("Impresoras");
        assertEquals("TEC-001", technician.getTechnicianId());
        assertEquals("Carlos Mena", technician.getFullName());
    }

    @Test
    public void testAssignToOrderWithNullDoesNotThrow() {
        try {
            technician.assignToOrder(null);
        } catch (Exception e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }

    @Test
    public void testAssignToOrderKeepsTechnicianData() {
        technician.assignToOrder(new Object());
        assertEquals("TEC-001", technician.getTechnicianId());
        assertEquals("Carlos Mena", technician.getFullName());
        assertEquals("Laptops", technician.getSpecialty());
    }

    @Test
    public void testToStringFormat() {
        String result = technician.toString();
        assertTrue(result.contains("TEC-001"));
        assertTrue(result.contains("Carlos Mena"));
        assertTrue(result.contains("Laptops"));
    }

    @Test
    public void testFailingCaseSpecialty() {
        assertEquals("Smartphones", technician.getSpecialty());
    }
}