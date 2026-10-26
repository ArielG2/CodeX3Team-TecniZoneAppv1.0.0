package ec.edu.espe.tecnizoneapp.testcases;

import ec.edu.espe.tecnizoneapp.model.Part;
import ec.edu.espe.tecnizoneapp.model.Supplier;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class SupplierTest {
    
    public SupplierTest() {
    }


    @Test
    public void testSupplierConstructorAndGetters() {

        Supplier supplier = new Supplier("SUP-001", "TechParts Ecuador", "0991234567");
        
        assertEquals("SUP-001", supplier.getSupplierId());
        assertEquals("TechParts Ecuador", supplier.getCompanyName());
        assertEquals("0991234567", supplier.getContactPhone());
    }

    @Test
    public void testSetCompanyName_Success() {

        Supplier supplier = new Supplier("SUP-002", "Global Tech", "0987654321");
        supplier.setCompanyName("Global Tech S.A.");
        
        assertEquals("Global Tech S.A.", supplier.getCompanyName());
    }

    @Test
    public void testSetContactPhone_Success() {

        Supplier supplier = new Supplier("SUP-003", "Importadora XYZ", "0955555555");
        supplier.setContactPhone("0999999999");
        
        assertEquals("0999999999", supplier.getContactPhone());
    }

    @Test
    public void testOrderParts_ExecutionSuccess() {

        Supplier supplier = new Supplier("SUP-004", "Distribuidora Central", "0933333333");
        Part samplePart = new Part("PRT-999", "Pantalla OLED", 10, 2, 100.0);

        try {
            supplier.orderParts(samplePart, 5);
            assertTrue(true);
        } catch (Exception e) {
            fail("El método orderParts no debería fallar con datos válidos.");
        }
    }

    @Test
    public void testSupplier_NotNullInstance() {

        Supplier supplier = new Supplier("SUP-005", "ElectroComponentes", "0922222222");
        
        assertNotNull(supplier);
        assertNotNull(supplier.getSupplierId());
    }

    @Test
    public void testSupplier_IdNotEqualsWrong() {

        Supplier supplier = new Supplier("SUP-006", "NetCom", "0911111111");
        
        assertNotEquals("SUP-000", supplier.getSupplierId());
    }

    @Test
    public void testToString_ContainsCompanyName() {

        Supplier supplier = new Supplier("SUP-007", "MegaParts", "0944444444");
        String resultString = supplier.toString();
        
        assertNotNull(resultString);
        assertTrue(resultString.contains("MegaParts"));
    }

    @Test
    public void testSetSupplierId_Success() {

        Supplier supplier = new Supplier("SUP-008", "AlphaTech", "0966666666");
        supplier.setSupplierId("SUP-888");
        
        assertEquals("SUP-888", supplier.getSupplierId());
    }

    @Test
    public void testSupplier_IntentionalFailureCompanyName() {

        Supplier supplier = new Supplier("SUP-009", "Inversiones Tecnológicas", "0977777777");

        assertEquals("Ferretería Industrial", supplier.getCompanyName());
    }

    @Test
    public void testSupplier_IntentionalFailurePhone() {

        Supplier supplier = new Supplier("SUP-010", "Servicios Express", "0988888888");
        
        assertEquals("0900000000", supplier.getContactPhone());
    }
}