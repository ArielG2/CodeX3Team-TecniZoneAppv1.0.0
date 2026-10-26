package ec.edu.espe.tecnizoneapp.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */

public class SystemUserTest {
    
    public SystemUserTest() {
    }


    @Test
    public void testSystemUserConstructorAndGetters() {

        SystemUser user = new SystemUser("admin01", "SecurePass123", "Administrator");
        
        assertEquals("admin01", user.getUsername());
        assertEquals("SecurePass123", user.getPassword());
        assertEquals("Administrator", user.getUserRole());
    }

    @Test
    public void testLogin_Success() {

        SystemUser user = new SystemUser("tech_juan", "12345", "Technician");
        
        boolean loginResult = user.login("12345");
        assertTrue("El login debería ser exitoso con la contraseña correcta", loginResult);
    }

    @Test
    public void testLogin_FailureWrongPassword() {

        SystemUser user = new SystemUser("tech_juan", "12345", "Technician");
        
        boolean loginResult = user.login("wrongpassword");
        assertFalse("El login debe fallar si la contraseña es errónea", loginResult);
    }

    @Test
    public void testUpdatePassword_Success() {

        SystemUser user = new SystemUser("sguerrero", "oldpass", "Manager");
        user.updatePassword("newpass456");
        
        assertEquals("newpass456", user.getPassword());
        assertTrue(user.login("newpass456"));
    }

    @Test
    public void testSetUsername_Success() {

        SystemUser user = new SystemUser("user_temp", "pass", "Staff");
        user.setUsername("user_final");
        
        assertEquals("user_final", user.getUsername());
    }

    @Test
    public void testSetUserRole_Success() {

        SystemUser user = new SystemUser("lmuzo", "pass", "Assistant");
        user.setUserRole("Administrator");
        
        assertEquals("Administrator", user.getUserRole());
    }

    @Test
    public void testSystemUser_NotNullInstance() {

        SystemUser user = new SystemUser("agiler", "pass", "Technician");
        
        assertNotNull(user);
        assertNotNull(user.getUsername());
    }

    @Test
    public void testToString_ContainsUsername() {

        SystemUser user = new SystemUser("test_user", "pass", "Viewer");
        String resultString = user.toString();
        
        assertNotNull(resultString);
        assertTrue(resultString.contains("test_user"));
    }

    @Test
    public void testSystemUser_IntentionalFailureRole() {

        SystemUser user = new SystemUser("operator1", "pass", "Technician");

        assertEquals("Administrator", user.getUserRole());
    }

    @Test
    public void testSystemUser_IntentionalFailureLogin() {

        SystemUser user = new SystemUser("operator2", "mypass", "Staff");

        assertTrue(user.login("password_equivocado"));
    }
}
