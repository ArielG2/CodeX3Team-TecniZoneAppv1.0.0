package ec.edu.espe.tecnizoneapp.testcases;

import ec.edu.espe.tecnizoneapp.model.Client;
import ec.edu.espe.tecnizoneapp.model.Equipment;
import ec.edu.espe.tecnizoneapp.model.WarrantyChecklist;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */

public class EquipmentTest {
    
    public EquipmentTest() {
    }


    @Test
    public void testEquipmentConstructorAndGetters() {
        Client client = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        Equipment equipment = new Equipment("SN-001", "Laptop", "HP", "Pavilion", "Pantalla rota", client);
        
        assertEquals("SN-001", equipment.getSerialNumber());
        assertEquals("Laptop", equipment.getDeviceType());
        assertEquals("HP", equipment.getBrand());
    }

    @Test
    public void testSetDeviceType_Success() {
        Client client = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        Equipment equipment = new Equipment("SN-002", "Impresora", "Epson", "L3210", "No enciende", client);
        
        equipment.setDeviceType("Impresora Multifunción");
        
        assertEquals("Impresora Multifunción", equipment.getDeviceType());
    }

    @Test
    public void testUpdateReportedFault_Success() {
        Client client = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        Equipment equipment = new Equipment("SN-003", "PC", "Dell", "Optiplex", "Lento", client);
        
        equipment.updateReportedFault("Disco duro dañado");
        
        assertEquals("Disco duro dañado", equipment.getReportedFaults());
    }

    @Test
    public void testCreateWarrantyCheck_Success() {
        Client client = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        Equipment equipment = new Equipment("SN-004", "Consola", "Sony", "PS5", "Ninguna", client);
        
        WarrantyChecklist check = equipment.createWarrantyCheck();
        
        assertNotNull(check);
    }

    @Test
    public void testSetBrandAndModel_Success() {
        Client client = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        Equipment equipment = new Equipment("SN-005", "Tablet", "Lenovo", "Tab M10", "Audio", client);
        
        equipment.setBrand("Samsung");
        equipment.setModel("Galaxy Tab");
        
        assertEquals("Samsung", equipment.getBrand());
        assertEquals("Galaxy Tab", equipment.getModel());
    }

    @Test
    public void testEquipment_ObjectNotNull() {
        Client client = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        Equipment equipment = new Equipment("SN-006", "Monitor", "LG", "24MK430", "Sin señal", client);
        
        assertNotNull(equipment);
        assertNotNull(equipment.getSerialNumber());
    }

    @Test
    public void testEquipment_SerialNumberNotEqualsWrong() {
        Client client = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        Equipment equipment = new Equipment("SN-007", "Teclado", "Redragon", "Kumara", "Tecla suelta", client);
        
        assertNotEquals("SN-999", equipment.getSerialNumber());
    }


    @Test
    public void testEquipment_IntentionalFailureBrand() {
        Client client = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        Equipment equipment = new Equipment("SN-008", "Laptop", "HP", "ProBook", "Ninguna", client);
        
        assertEquals("Apple", equipment.getBrand());
    }

    @Test
    public void testEquipment_IntentionalFailureModel() {
        Client client = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        Equipment equipment = new Equipment("SN-009", "Laptop", "Dell", "Latitude", "Batería", client);
        
        assertEquals("MacBook", equipment.getModel());
    }

    @Test
    public void testEquipment_IntentionalFailureSerialNumber() {
        Client client = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        Equipment equipment = new Equipment("SN-010", "Router", "TP-Link", "Archer", "Sin internet", client);
        
        assertEquals("SN-000", equipment.getSerialNumber());
    }
}