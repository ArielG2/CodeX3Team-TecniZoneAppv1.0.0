package ec.edu.espe.tecnizoneapp.testcases;

import ec.edu.espe.tecnizoneapp.model.Client;
import ec.edu.espe.tecnizoneapp.model.Equipment;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */

public class ClientTest {
    
    public ClientTest() {
    }

    @Test
    public void testClientConstructorAndGetters() {
        Client client = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        
        assertEquals("C001", client.getClientId());
        assertEquals("Stalyn Guerrero", client.getFullName());
        assertEquals("0911111111", client.getPhoneNumber());
        assertEquals("TecniZone", client.getCompanyName());
    }

    @Test
    public void testUpdateContactInfo_Success() {
        Client client = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        
        client.updateContactInfo("0998887766");
        
        assertEquals("0998887766", client.getPhoneNumber());
    }

    @Test
    public void testRegisterEquipment_Success() {
        Client client = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        
        Equipment equipment = client.registerEquipment("Laptop HP Pavilion");
        
        assertNotNull(equipment);
        assertEquals("Laptop HP Pavilion", equipment.getDeviceType());
        assertEquals(client, equipment.getOwnerClient());
    }

    @Test
    public void testSetters_Success() {
        Client client = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        
        client.setFullName("Stalyn G.");
        client.setCompanyName("TecniZone S.A.");
        
        assertEquals("Stalyn G.", client.getFullName());
        assertEquals("TecniZone S.A.", client.getCompanyName());
    }


    

    @Test
    public void testUpdateContactInfo_WithEmptyString() {
        Client client = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        
        client.updateContactInfo("");
        
        
        assertEquals("", client.getPhoneNumber());
    }

    @Test
    public void testRegisterEquipment_WithBlankDetails() {
        Client client = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        
        Equipment equipment = client.registerEquipment("   ");
        
        assertNotNull(equipment);
        assertEquals("   ", equipment.getDeviceType());
    }

    @Test
    public void testClientData_NotEqualsWrongData() {
        Client client = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        
        
        assertNotEquals("0900000000", client.getPhoneNumber());
        assertNotEquals("Empresa Falsa", client.getCompanyName());
    }

    @Test
    public void testRegisterMultipleEquipments_Exigente1() {
        Client client = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        
        Equipment eq1 = client.registerEquipment("Impresora Epson");
        Equipment eq2 = client.registerEquipment("Laptop Dell");
        
        assertNotNull(eq1);
        assertNotNull(eq2);
        
        assertEquals(client, eq1.getOwnerClient());
        assertEquals(client, eq2.getOwnerClient());
    }

    @Test
    public void testClientStatePersistence_Exigente2() {
        Client client = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        
        client.updateContactInfo("0987654321");
        client.setFullName("Stalyn David Guerrero");
        
        assertEquals("C001", client.getClientId());
        assertEquals("Stalyn David Guerrero", client.getFullName());
        assertEquals("0987654321", client.getPhoneNumber());
    }

    @Test
    public void testEquipmentReferenceEquality_Exigente3() {
        Client client = new Client("C001", "Stalyn Guerrero", "0922222222", "TecniZone");
        
        Equipment equipment = client.registerEquipment("PC de Escritorio");
        assertSame(client, equipment.getOwnerClient());
    }
}
