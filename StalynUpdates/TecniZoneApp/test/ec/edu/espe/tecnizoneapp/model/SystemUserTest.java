/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SystemUserTest {

    private SystemUser user;

    @Before
    public void setUp() {
        user = new SystemUser("stalyng", "secret123", "Admin");
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("stalyng", user.getUsername());
        assertEquals("secret123", user.getPassword());
        assertEquals("Admin", user.getUserRole());
    }

    @Test
    public void testSetUsername() {
        user.setUsername("mateo");
        assertEquals("mateo", user.getUsername());
    }

    @Test
    public void testSetPassword() {
        user.setPassword("newPass456");
        assertEquals("newPass456", user.getPassword());
    }

    @Test
    public void testSetUserRole() {
        user.setUserRole("Technician");
        assertEquals("Technician", user.getUserRole());
    }

    @Test
    public void testLoginSuccess() {
        boolean result = user.login("secret123");
        assertTrue(result);
    }

    @Test
    public void testLoginFailure() {
        boolean result = user.login("wrongpassword");
        assertFalse(result);
    }

    @Test
    public void testUpdatePassword() {
        user.updatePassword("updatedPass789");
        assertEquals("updatedPass789", user.getPassword());
    }

    @Test
    public void testLoginAfterPasswordUpdate() {
        user.updatePassword("newSecret");
        assertTrue(user.login("newSecret"));
    }

    @Test
    public void testRoleValidation() {
        assertEquals("Admin", user.getUserRole());
    }

    @Test
    public void testFailingCaseUsernameValidation() {
        assertEquals("root", user.getUsername());
    }
}
