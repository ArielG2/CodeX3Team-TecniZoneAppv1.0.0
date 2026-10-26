package ec.edu.espe.tecnizoneapp.model;

import ec.edu.espe.tecnizoneapp.model.SystemUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */

public class SystemUserTest {

    private SystemUser user01;
    private SystemUser user02;
    private SystemUser user03;


    @Test
    public void USR01_loginConPasswordCorrecta() {
        assertTrue(user01.login("Admin123"));
    }

    @Test
    public void USR02_loginConPasswordIncorrecta() {
        assertFalse(user01.login("Incorrecta"));
    }

    @Test
    public void USR03_loginConPasswordVacia() {
        assertFalse(user01.login(""));
    }

    @Test
    public void USR04_loginConPasswordNull() {
        assertDoesNotThrow(() -> user01.login(null));
        assertFalse(user01.login(null));
    }

    @Test
    public void USR05_loginDistingueMayusculas() {
        assertFalse(user01.login("admin123"));
    }

    @Test
    public void USR06_loginConPasswordNuevaTrasActualizar() {
        user01.updatePassword("Nueva123");
        assertTrue(user01.login("Nueva123"));
    }

    @Test
    public void USR07_loginConPasswordAnteriorTrasActualizar() {
        user01.updatePassword("Nueva123");
        assertFalse(user01.login("Admin123"));
    }

    @Test
    public void USR08_updatePasswordVaciaSeGuardaTalCual() {
        user01.updatePassword("");
        assertTrue(user01.login(""));
    }

    @Test
    public void USR09_creacionDeUser02() {
        assertEquals("user02ReceptionCashier", user02.getUsername());
        assertEquals("Reception Cashier", user02.getUserRole());
    }

    @Test
    public void USR10_rolesDistintosEntreUsuarios() {
        assertNotEquals(user01.getUserRole(), user03.getUserRole());
    }
}
