/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.testcases;

import ec.edu.espe.tecnizoneapp.model.ServiceCatalog;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class ServiceCatalogTest {

    private ServiceCatalog service;

    @Before
    public void setUp() {
        service = new ServiceCatalog("SRV-001", "Mantenimiento Preventivo", 25.0);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("SRV-001", service.getServiceCode());
        assertEquals("Mantenimiento Preventivo", service.getServiceName());
        assertEquals(25.0, service.getFixedLaborCost(), 0.001);
    }

    @Test
    public void testSetServiceCode() {
        service.setServiceCode("SRV-002");
        assertEquals("SRV-002", service.getServiceCode());
    }

    @Test
    public void testSetServiceName() {
        service.setServiceName("Cambio de Pantalla");
        assertEquals("Cambio de Pantalla", service.getServiceName());
    }

    @Test
    public void testSetFixedLaborCost() {
        service.setFixedLaborCost(60.5);
        assertEquals(60.5, service.getFixedLaborCost(), 0.001);
    }

    @Test
    public void testUpdateCost() {
        service.updateCost(45.5);
        assertEquals(45.5, service.getFixedLaborCost(), 0.001);
    }

    @Test
    public void testUpdateCostToZero() {
        service.updateCost(0.0);
        assertEquals(0.0, service.getFixedLaborCost(), 0.001);
    }

    @Test
    public void testUpdateCostKeepsOtherFields() {
        service.updateCost(80.0);
        assertEquals("SRV-001", service.getServiceCode());
        assertEquals("Mantenimiento Preventivo", service.getServiceName());
    }

    @Test
    public void testToStringFormat() {
        String result = service.toString();
        assertTrue(result.contains("SRV-001"));
        assertTrue(result.contains("Mantenimiento Preventivo"));
        assertTrue(result.contains("25.0"));
    }

    @Test
    public void testToStringAfterUpdateCost() {
        service.updateCost(45.5);
        assertTrue(service.toString().contains("45.5"));
    }

    @Test
    public void testFailingCaseServiceName() {
        assertEquals("Cambio de Pantalla", service.getServiceName());
    }
}