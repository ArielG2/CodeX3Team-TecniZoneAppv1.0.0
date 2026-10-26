/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */

public class WarrantyChecklistTest {
    
    public WarrantyChecklistTest() {
    }

    @Test
    public void testWarrantyChecklistConstructorAndGetters() {

        WarrantyChecklist checklist = new WarrantyChecklist("CHK-001", null, false, true, true);
        
        assertEquals("CHK-001", checklist.getChecklistId());
        assertFalse(checklist.getHasPhysicalDamage());
        assertTrue(checklist.getIncludesAccessories());
        assertTrue(checklist.getIsWarrantyValid());
    }

    @Test
    public void testValidateWarrantyStatus_ValidWhenNoDamage() {

        WarrantyChecklist checklist = new WarrantyChecklist("CHK-002", null, false, true, true);
        
        assertTrue("La garantía debería ser válida", checklist.validateWarrantyStatus());
    }

    @Test
    public void testValidateWarrantyStatus_InvalidWhenDamageExists() {

        WarrantyChecklist checklist = new WarrantyChecklist("CHK-003", null, true, true, true);
        
        assertFalse("La garantía no debe ser válida si hay daño físico", checklist.validateWarrantyStatus());
    }

    @Test
    public void testMarkPhysicalDamage_Success() {

        WarrantyChecklist checklist = new WarrantyChecklist("CHK-004", null, false, true, true);
        checklist.markPhysicalDamage("Pantalla rayada");
        
        assertTrue(checklist.getHasPhysicalDamage());
        assertFalse(checklist.validateWarrantyStatus());
    }

    @Test
    public void testSetChecklistId_Success() {

        WarrantyChecklist checklist = new WarrantyChecklist("CHK-005", null, false, false, true);
        checklist.setChecklistId("CHK-999");
        
        assertEquals("CHK-999", checklist.getChecklistId());
    }

    @Test
    public void testSetIncludesAccessories_Success() {

        WarrantyChecklist checklist = new WarrantyChecklist("CHK-006", null, false, false, true);
        checklist.setIncludesAccessories(true);
        
        assertTrue(checklist.getIncludesAccessories());
    }

    @Test
    public void testWarrantyChecklist_NotNullInstance() {

        WarrantyChecklist checklist = new WarrantyChecklist("CHK-007", null, false, true, true);
        
        assertNotNull(checklist);
        assertNotNull(checklist.getChecklistId());
    }

    @Test
    public void testToString_ContainsId() {

        WarrantyChecklist checklist = new WarrantyChecklist("CHK-008", null, false, true, true);
        String resultString = checklist.toString();
        
        assertNotNull(resultString);
        assertTrue(resultString.contains("CHK-008"));
    }

    @Test
    public void testWarrantyChecklist_IntentionalFailureWarrantyStatus() {

        WarrantyChecklist checklist = new WarrantyChecklist("CHK-009", null, false, true, true);

        assertFalse(checklist.validateWarrantyStatus());
    }

    @Test
    public void testWarrantyChecklist_IntentionalFailurePhysicalDamage() {

        WarrantyChecklist checklist = new WarrantyChecklist("CHK-010", null, false, true, true);

        assertTrue(checklist.getHasPhysicalDamage());
    }
}
