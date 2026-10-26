/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */

public class ServiceCatalogTest {
    
    public ServiceCatalogTest() {
    }



    @Test
    public void testServiceCatalogConstructorAndGetters() {

        ServiceCatalog service = new ServiceCatalog("SRV-001", "Mantenimiento Preventivo", 45.00);
        
        assertEquals("SRV-001", service.getServiceCode());
        assertEquals("Mantenimiento Preventivo", service.getServiceName());
        assertEquals(45.00, service.getFixedLaborCost(), 0.01);
    }

    @Test
    public void testSetServiceCode_Success() {

        ServiceCatalog service = new ServiceCatalog("SRV-002", "Formateo", 25.00);
        service.setServiceCode("SRV-999");
        
        assertEquals("SRV-999", service.getServiceCode());
    }

    @Test
    public void testSetServiceName_Success() {

        ServiceCatalog service = new ServiceCatalog("SRV-003", "Limpieza", 20.00);
        service.setServiceName("Limpieza Profunda");
        
        assertEquals("Limpieza Profunda", service.getServiceName());
    }

    @Test
    public void testSetFixedLaborCost_Success() {

        ServiceCatalog service = new ServiceCatalog("SRV-004", "Diagnóstico", 15.00);
        service.setFixedLaborCost(30.00);
        
        assertEquals(30.00, service.getFixedLaborCost(), 0.01);
    }

    @Test
    public void testUpdateCost_Success() {

        ServiceCatalog service = new ServiceCatalog("SRV-005", "Cambio de Pantalla", 50.00);
        service.updateCost(65.00);
        
        assertEquals(65.00, service.getFixedLaborCost(), 0.01);
    }

    @Test
    public void testServiceCatalog_ObjectNotNull() {

        ServiceCatalog service = new ServiceCatalog("SRV-006", "Recuperación de Datos", 100.00);
        
        assertNotNull(service);
        assertNotNull(service.getServiceCode());
    }

    @Test
    public void testServiceCatalog_CodeNotEqualsWrong() {

        ServiceCatalog service = new ServiceCatalog("SRV-007", "Instalación de Software", 35.00);
        
        assertNotEquals("SRV-000", service.getServiceCode());
    }

    @Test
    public void testToString_NotNull() {

        ServiceCatalog service = new ServiceCatalog("SRV-008", "Backup", 40.00);
        
        assertNotNull(service.toString());
    }




    @Test
    public void testServiceCatalog_IntentionalFailureCost() {

        ServiceCatalog service = new ServiceCatalog("SRV-009", "Reparación de Bisagras", 55.00);

        assertEquals(500.00, service.getFixedLaborCost(), 0.01);
    }

    @Test
    public void testServiceCatalog_IntentionalFailureName() {

        ServiceCatalog service = new ServiceCatalog("SRV-010", "Cambio de Teclado", 30.00);

        assertEquals("Cambio de Batería", service.getServiceName());
    }
}
