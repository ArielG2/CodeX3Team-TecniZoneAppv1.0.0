package ec.edu.espe.tecnizoneapp.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class TechnicianTest {

    private Technician technician;

    @Before
    public void setUp() {
        technician = new Technician("TECH-001", "Carlos Lopez", "Hardware & Micro-soldering");
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("TECH-001", technician.getTechnicianId());
        assertEquals("Carlos Lopez", technician.getFullName());
        assertEquals("Hardware & Micro-soldering", technician.getSpecialty());
    }

    @Test
    public void testSetTechnicianId() {
        technician.setTechnicianId("TECH-002");
        assertEquals("TECH-002", technician.getTechnicianId());
    }

    @Test
    public void testSetFullName() {
        technician.setFullName("Mateo Perez");
        assertEquals("Mateo Perez", technician.getFullName());
    }

    @Test
    public void testSetSpecialty() {
        technician.setSpecialty("Software Diagnostics");
        assertEquals("Software Diagnostics", technician.getSpecialty());
    }

    @Test
    public void testUpdateSpecialty() {
        technician.updateSpecialty("Motherboard Repair");
        assertEquals("Motherboard Repair", technician.getSpecialty());
    }

    @Test
    public void testToStringFormat() {
        String result = technician.toString();
        assertTrue(result.contains("TECH-001"));
        assertTrue(result.contains("Carlos Lopez"));
        assertTrue(result.contains("Hardware & Micro-soldering"));
    }

    @Test
    public void testFailingCaseTechnicianId() {
        assertEquals("TECH-999", technician.getTechnicianId());
    }

    @Test
    public void testFailingCaseFullName() {
        assertEquals("Nombre Inexistente", technician.getFullName());
    }
}