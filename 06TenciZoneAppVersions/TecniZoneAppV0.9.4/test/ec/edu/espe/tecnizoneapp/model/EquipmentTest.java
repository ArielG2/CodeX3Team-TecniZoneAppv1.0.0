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
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class EquipmentTest {

    private Equipment equipment;
    private Client sampleClient;

    @Before
    public void setUp() {
        sampleClient = new Client("CLI-001", "Ariel Giler", "0991234567");
        equipment = new Equipment("SN-12345", "Laptop", "HP", "Pavilion", "No enciende", sampleClient);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("SN-12345", equipment.getSerialNumber());
        assertEquals("Laptop", equipment.getDeviceType());
        assertEquals("HP", equipment.getBrand());
        assertEquals("Pavilion", equipment.getModel());
        assertEquals("No enciende", equipment.getReportedFaults());
        assertEquals(sampleClient, equipment.getOwnerClient());
    }

    @Test
    public void testSetSerialNumber() {
        equipment.setSerialNumber("SN-99999");
        assertEquals("SN-99999", equipment.getSerialNumber());
    }

    @Test
    public void testSetDeviceType() {
        equipment.setDeviceType("Smartphone");
        assertEquals("Smartphone", equipment.getDeviceType());
    }

    @Test
    public void testSetBrand() {
        equipment.setBrand("Dell");
        assertEquals("Dell", equipment.getBrand());
    }

    @Test
    public void testSetModel() {
        equipment.setModel("Inspiron");
        assertEquals("Inspiron", equipment.getModel());
    }

    @Test
    public void testUpdateReportFault() {
        equipment.updateReportFault("Pantalla rota");
        assertEquals("Pantalla rota", equipment.getReportedFaults());
    }

    @Test
    public void testCreateWarrantyCheckNotNull() {
        WarrantyChecklist checklist = equipment.createWarrantyCheck();
        assertNotNull(checklist);
    }

    @Test
    public void testCreateWarrantyCheckAssociation() {
        WarrantyChecklist checklist = equipment.createWarrantyCheck();
        assertEquals(equipment, checklist.getRelatedEquipment());
    }

    @Test
    public void testFailingCaseSerialNumber() {
        assertEquals("SN-00000", equipment.getSerialNumber());
    }

    @Test
    public void testFailingCaseBrand() {
        assertEquals("Lenovo", equipment.getBrand());
    }
}
