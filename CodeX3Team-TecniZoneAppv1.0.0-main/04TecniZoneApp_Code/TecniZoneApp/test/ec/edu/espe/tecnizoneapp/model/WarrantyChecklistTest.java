package ec.edu.espe.tecnizoneapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WarrantyChecklistTest {

    private Equipment hpLaptop;
    private WarrantyChecklist checklist;

    @BeforeEach
    public void setUp() {
        Client juan = new Client("client01", "Juan Perez", "0991111111", "");
        hpLaptop = new Equipment("SN001", "Laptop", "HP", "Pavilion", "No enciende", juan);
        checklist = new WarrantyChecklist("checklist01", hpLaptop, false, false, true);
    }

    @Test
    public void WCL01_creacionConAtributosCorrectos() {
        assertEquals("checklist01", checklist.getChecklistId());
        assertSame(hpLaptop, checklist.getRelatedEquipment());
        assertFalse(checklist.getHasPhysicalDamage());
        assertTrue(checklist.getIsWarrantyValid());
    }

    @Test
    public void WCL02_markPhysicalDamagePonerDanoEnTrue() {
        checklist.markPhysicalDamage("Pantalla rota");
        assertTrue(checklist.getHasPhysicalDamage());
    }

    @Test
    public void WCL03_markPhysicalDamageConDescripcionVaciaIgualMarcaDano() {
        checklist.markPhysicalDamage("");
        assertTrue(checklist.getHasPhysicalDamage());
    }

    @Test
    public void WCL04_validateWarrantySinDanoEsValida() {
        assertTrue(checklist.validateWarrantyStatus());
    }

    @Test
    public void WCL05_validateWarrantyConDanoNoEsValida() {
        checklist.markPhysicalDamage("Pantalla rota");
        assertFalse(checklist.validateWarrantyStatus());
    }

    @Test
    public void WCL06_sinAccesoriosSeGuardaFalso() {
        assertFalse(checklist.getIncludesAccessories());
    }

    @Test
    public void WCL07_conDanoYAccesoriosNoEsValida() {
        checklist.setIncludesAccessories(true);
        checklist.markPhysicalDamage("Bisagra rota");
        assertFalse(checklist.validateWarrantyStatus());
    }

    @Test
    public void WCL08_validateWarrantyDosVecesDaMismoResultado() {
        assertEquals(checklist.validateWarrantyStatus(), checklist.validateWarrantyStatus());
    }

    @Test
    public void WCL09_validarAntesYDespuesDeMarcarDano() {
        assertTrue(checklist.validateWarrantyStatus());
        checklist.markPhysicalDamage("Pantalla rota");
        assertFalse(checklist.validateWarrantyStatus());
    }

    @Test
    public void WCL10_relatedEquipmentNullSeGuarda() {
        checklist.setRelatedEquipment(null);
        assertNull(checklist.getRelatedEquipment());
    }
}