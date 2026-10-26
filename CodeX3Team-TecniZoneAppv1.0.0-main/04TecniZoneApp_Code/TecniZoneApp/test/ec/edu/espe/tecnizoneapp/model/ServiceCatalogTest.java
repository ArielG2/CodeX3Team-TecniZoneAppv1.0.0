package ec.edu.espe.tecnizoneapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */


public class ServiceCatalogTest {

    private ServiceCatalog preventive;
    private ServiceCatalog formatting;

    @BeforeEach
    public void setUp() {
        preventive = new ServiceCatalog("service01", "PreventiveMaintenance", 20.0);
        formatting = new ServiceCatalog("service02", "Formatting", 15.0);
    }

    @Test
    public void SRV01_creacionConAtributosCorrectos() {
        assertEquals("service01", preventive.getServiceCode());
        assertEquals("PreventiveMaintenance", preventive.getServiceName());
        assertEquals(20.0, preventive.getFixedLaborCost());
    }

    @Test
    public void SRV02_updateCostActualizaCosto() {
        preventive.updateCost(25.50);
        assertEquals(25.50, preventive.getFixedLaborCost());
    }

    @Test
    public void SRV03_updateCostCeroSeGuarda() {
        preventive.updateCost(0);
        assertEquals(0, preventive.getFixedLaborCost());
    }

    @Test
    public void SRV04_updateCostNegativoSeGuarda() {
        preventive.updateCost(-10);
        assertEquals(-10, preventive.getFixedLaborCost());
    }

    @Test
    public void SRV05_updateCostDosVecesQuedaElUltimo() {
        preventive.updateCost(20);
        preventive.updateCost(30);
        assertEquals(30, preventive.getFixedLaborCost());
    }

    @Test
    public void SRV06_updateCostConDecimales() {
        preventive.updateCost(15.999);
        assertEquals(15.999, preventive.getFixedLaborCost());
    }

    @Test
    public void SRV07_codigosDeServiciosDistintos() {
        assertNotEquals(preventive.getServiceCode(), formatting.getServiceCode());
    }

    @Test
    public void SRV08_serviceNameVacioSeGuarda() {
        ServiceCatalog vacio = new ServiceCatalog("service03", "", 10.0);
        assertEquals("", vacio.getServiceName());
    }

    @Test
    public void SRV09_cambiarCostoNoAfectaOtroServicio() {
        preventive.updateCost(50.0);
        assertEquals(15.0, formatting.getFixedLaborCost());
    }

    @Test
    public void SRV10_updateCostGrandeSeGuarda() {
        preventive.updateCost(1000000);
        assertEquals(1000000, preventive.getFixedLaborCost());
    }
}