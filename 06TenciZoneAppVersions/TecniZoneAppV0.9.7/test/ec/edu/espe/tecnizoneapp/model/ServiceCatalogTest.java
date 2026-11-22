package ec.edu.espe.tecnizoneapp.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class ServiceCatalogTest {

    private ServiceCatalog serviceCatalog;

    @Before
    public void setUp() {
        serviceCatalog = new ServiceCatalog("SVC-001", "Mantenimiento Preventivo", 25.0);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("SVC-001", serviceCatalog.getServiceCode());
        assertEquals("Mantenimiento Preventivo", serviceCatalog.getServiceName());
        assertEquals(25.0, serviceCatalog.getFixedLaborCost(), 0.001);
    }

    @Test
    public void testSetServiceCode() {
        serviceCatalog.setServiceCode("SVC-002");
        assertEquals("SVC-002", serviceCatalog.getServiceCode());
    }

    @Test
    public void testSetServiceName() {
        serviceCatalog.setServiceName("Limpieza Completa");
        assertEquals("Limpieza Completa", serviceCatalog.getServiceName());
    }

    @Test
    public void testSetFixedLaborCost() {
        serviceCatalog.setFixedLaborCost(35.0);
        assertEquals(35.0, serviceCatalog.getFixedLaborCost(), 0.001);
    }

    @Test
    public void testUpdateCost() {
        serviceCatalog.updateCost(40.0);
        assertEquals(40.0, serviceCatalog.getFixedLaborCost(), 0.001);
    }

    @Test
    public void testToStringFormat() {
        String result = serviceCatalog.toString();
        assertTrue(result.contains("SVC-001"));
        assertTrue(result.contains("Mantenimiento Preventivo"));
        assertTrue(result.contains("25.0"));
    }

    @Test
    public void testFailingCaseServiceCode() {
        assertEquals("SVC-999", serviceCatalog.getServiceCode());
    }

    @Test
    public void testFailingCaseFixedLaborCost() {
        assertEquals(999.99, serviceCatalog.getFixedLaborCost(), 0.001);
    }
}