package ec.edu.espe.tecnizoneapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */


public class TechnicianTest {

    private Technician stalyn;
    private Technician ariel;

    @BeforeEach
    public void setUp() {
        stalyn = new Technician("technician01", "Stalyn Guerrero", "Reballing");
        ariel = new Technician("technician02", "Ariel", "Formatting");
    }

    @Test
    public void TEC01_creacionConAtributosCorrectos() {
        assertEquals("technician01", stalyn.getTechnicianId());
        assertEquals("Stalyn Guerrero", stalyn.getFullName());
        assertEquals("Reballing", stalyn.getSpecialty());
    }

    @Test
    public void TEC02_updateSpecialtyActualizaEspecialidad() {
        stalyn.updateSpecialty("Preventive Maintenance");
        assertEquals("Preventive Maintenance", stalyn.getSpecialty());
    }

    @Test
    public void TEC03_updateSpecialtyAceptaVacio() {
        stalyn.updateSpecialty("");
        assertEquals("", stalyn.getSpecialty());
    }

    @Test
    public void TEC04_updateSpecialtyAceptaNull() {
        stalyn.updateSpecialty(null);
        assertNull(stalyn.getSpecialty());
    }

    @Test
    public void TEC05_assignToOrderNoLanzaError() {
        assertDoesNotThrow(() -> stalyn.assignToOrder("order001"));
    }

    @Test
    public void TEC06_assignToOrderConNullNoLanzaError() {
        assertDoesNotThrow(() -> stalyn.assignToOrder(null));
    }

    @Test
    public void TEC07_assignToOrderVariasOrdenes() {
        assertDoesNotThrow(() -> {
            stalyn.assignToOrder("order001");
            stalyn.assignToOrder("order002");
        });
    }

    @Test
    public void TEC08_setFullNameCambiaNombre() {
        stalyn.setFullName("Stalyn G.");
        assertEquals("Stalyn G.", stalyn.getFullName());
    }

    @Test
    public void TEC09_tecnicosTienenIdDistintos() {
        assertNotEquals(stalyn.getTechnicianId(), ariel.getTechnicianId());
    }

    @Test
    public void TEC10_toStringContieneEspecialidad() {
        assertTrue(stalyn.toString().contains("Reballing"));
    }
}