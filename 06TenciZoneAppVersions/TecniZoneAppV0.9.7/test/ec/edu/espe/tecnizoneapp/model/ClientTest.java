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
public class ClientTest {

    private Client client;

    @Before
    public void setUp() {
        client = new Client("CLI-001", "Ariel Giler", "0991234567");
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("CLI-001", client.getClientId());
        assertEquals("Ariel Giler", client.getFullName());
        assertEquals("0991234567", client.getPhoneNumber());
    }

    @Test
    public void testSetClientId() {
        client.setClientId("CLI-002");
        assertEquals("CLI-002", client.getClientId());
    }

    @Test
    public void testSetFullName() {
        client.setFullName("Mateo Perez");
        assertEquals("Mateo Perez", client.getFullName());
    }

    @Test
    public void testSetPhoneNumber() {
        client.setPhoneNumber("0987654321");
        assertEquals("0987654321", client.getPhoneNumber());
    }

    @Test
    public void testUpdateContactInfo() {
        client.updateContactInfo("0977777777");
        assertEquals("0977777777", client.getPhoneNumber());
    }

    @Test
    public void testToStringFormat() {
        String result = client.toString();
        assertTrue(result.contains("CLI-001"));
        assertTrue(result.contains("Ariel Giler"));
        assertTrue(result.contains("0991234567"));
    }

    @Test
    public void testRegisterEquipmentNotNull() {
        Equipment eq = client.registerEquipment("Laptop HP");
        assertNotNull(eq);
    }

    @Test
    public void testRegisterEquipmentAttributes() {
        Equipment eq = client.registerEquipment("Smartphone");
        assertEquals("Smartphone", eq.getDeviceType());
        assertEquals(client, eq.getOwnerClient());
    }

    @Test
    public void testFailingCaseClientId() {
        assertEquals("CLI-999", client.getClientId());
    }

    @Test
    public void testFailingCaseFullName() {
        assertEquals("Stalyn Guerrero", client.getFullName());
    }
}
