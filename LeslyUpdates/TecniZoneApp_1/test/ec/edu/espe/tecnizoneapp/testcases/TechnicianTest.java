package ec.edu.espe.tecnizoneapp.testcases;

import ec.edu.espe.tecnizoneapp.model.Technician;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class TechnicianTest {
    
    public TechnicianTest() {
    }

    @Test
    public void testTechnicianConstructorAndGetters() {

        Technician tech = new Technician("TECH-001", "Carlos Mendoza", "Laptops y Hardware");
        
        assertEquals("TECH-001", tech.getTechnicianId());
        assertEquals("Carlos Mendoza", tech.getFullName());
        assertEquals("Laptops y Hardware", tech.getSpecialty());
    }

    @Test
    public void testUpdateSpecialty_Success() {

        Technician tech = new Technician("TECH-002", "Ana Torres", "Smartphones");
        tech.updateSpecialty("Redes y Servidores");
        
        assertEquals("Redes y Servidores", tech.getSpecialty());
    }

    @Test
    public void testAssignToOrder_ExecutionSuccess() {

        Technician tech = new Technician("TECH-003", "Luis Andrade", "Impresoras");
        
        try {
            tech.assignToOrder(new Object());
            assertTrue(true);
        } catch (Exception e) {
            fail("El método assignToOrder no debería lanzar excepciones.");
        }
    }

    @Test
    public void testSetFullName_Success() {

        Technician tech = new Technician("TECH-004", "Jose Perez", "Audio");
        tech.setFullName("Jose Luis Perez");
        
        assertEquals("Jose Luis Perez", tech.getFullName());
    }

    @Test
    public void testSetTechnicianId_Success() {

        Technician tech = new Technician("TECH-005", "Maria Gomez", "Consolas");
        tech.setTechnicianId("TECH-999");
        
        assertEquals("TECH-999", tech.getTechnicianId());
    }

    @Test
    public void testTechnician_NotNullInstance() {

        Technician tech = new Technician("TECH-006", "David Vera", "MacBooks");
        
        assertNotNull(tech);
        assertNotNull(tech.getTechnicianId());
    }

    @Test
    public void testTechnician_IdNotEqualsWrong() {

        Technician tech = new Technician("TECH-007", "Sofia Ruiz", "Tablets");
        
        assertNotEquals("TECH-000", tech.getTechnicianId());
    }

    @Test
    public void testToString_ContainsFullName() {

        Technician tech = new Technician("TECH-008", "Esteban Quito", "Monitores");
        String resultString = tech.toString();
        
        assertNotNull(resultString);
        assertTrue(resultString.contains("Esteban Quito"));
    }

    @Test
    public void testTechnician_IntentionalFailureSpecialty() {

        Technician tech = new Technician("TECH-009", "Mateo Silva", "Redes");

        assertEquals("Carpintería", tech.getSpecialty());
    }

    @Test
    public void testTechnician_IntentionalFailureName() {

        Technician tech = new Technician("TECH-010", "Valeria Mora", "Software");

        assertEquals("Albert Einstein", tech.getFullName());
    }
}
