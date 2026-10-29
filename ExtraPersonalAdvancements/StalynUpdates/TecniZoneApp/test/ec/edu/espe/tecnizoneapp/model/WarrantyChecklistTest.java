/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WarrantyChecklistTest {

    private WarrantyChecklist checklist;
    private Equipment sampleEquipment;

    @Before
    public void setUp() {
        sampleEquipment = new Equipment("SN-123", "Laptop", "HP", "Pavilion", "Ninguna", null);
        checklist = new WarrantyChecklist("CHK-001", sampleEquipment, false, true, true);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("CHK-001", checklist.getChecklistId());
        assertEquals(sampleEquipment, checklist.getRelatedEquipment());
        assertFalse(checklist.isHasPhysicalDamage());
        assertTrue(checklist.isIncludesAccessories());
        assertTrue(checklist.isIsWarrantyValid());
    }

    @Test
    public void testSetChecklistId() {
        checklist.setChecklistId("CHK-002");
        assertEquals("CHK-002", checklist.getChecklistId());
    }

    @Test
    public void testSetRelatedEquipment() {
        checklist.setRelatedEquipment(null);
        assertNull(checklist.getRelatedEquipment());
    }

    @Test
    public void testSetHasPhysicalDamage() {
        checklist.setHasPhysicalDamage(true);
        assertTrue(checklist.isHasPhysicalDamage());
    }

    @Test
    public void testSetIncludesAccessories() {
        checklist.setIncludesAccessories(false);
        assertFalse(checklist.isIncludesAccessories());
    }

    @Test
    public void testSetIsWarrantyValid() {
        checklist.setIsWarrantyValid(false);
        assertFalse(checklist.isIsWarrantyValid());
    }

    @Test
    public void testMarkPhysicalDamage() {
        checklist.markPhysicalDamage("Pantalla partida");
        assertTrue(checklist.isHasPhysicalDamage());
        assertEquals("Pantalla partida", sampleEquipment.getReportedFaults());
    }

    @Test
    public void testValidateWarrantyStatus() {
        checklist.setHasPhysicalDamage(true);
        boolean isValid = checklist.validateWarrantyStatus();
        assertFalse(isValid);
        assertFalse(checklist.isIsWarrantyValid());
    }

    @Test
    public void testFailingCaseChecklistId() {
        assertEquals("CHK-999", checklist.getChecklistId());
    }

    @Test
    public void testFailingCaseWarrantyValid() {
        assertFalse(checklist.isIsWarrantyValid());
    }
}
