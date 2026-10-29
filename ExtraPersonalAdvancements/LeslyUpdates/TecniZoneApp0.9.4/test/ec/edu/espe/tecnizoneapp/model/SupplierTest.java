package ec.edu.espe.tecnizoneapp.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class SupplierTest {

    private Supplier supplier;

    @Before
    public void setUp() {
        supplier = new Supplier("SUP-001", "Tech Parts Ecuador", "0998887766");
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("SUP-001", supplier.getSupplierId());
        assertEquals("Tech Parts Ecuador", supplier.getCompanyName());
        assertEquals("0998887766", supplier.getContactPhone());
    }

    @Test
    public void testSetSupplierId() {
        supplier.setSupplierId("SUP-002");
        assertEquals("SUP-002", supplier.getSupplierId());
    }

    @Test
    public void testSetCompanyName() {
        supplier.setCompanyName("Importadora Global");
        assertEquals("Importadora Global", supplier.getCompanyName());
    }

    @Test
    public void testSetContactPhone() {
        supplier.setContactPhone("022334455");
        assertEquals("022334455", supplier.getContactPhone());
    }

    @Test
    public void testOrderParts() {
        Part part = new Part("P001", "Pantalla LED", 10, 2, 50.0);
        supplier.orderParts(part, 5);
        assertNotNull(part);
    }

    @Test
    public void testToStringFormat() {
        String result = supplier.toString();
        assertTrue(result.contains("SUP-001"));
        assertTrue(result.contains("Tech Parts Ecuador"));
        assertTrue(result.contains("0998887766"));
    }

    @Test
    public void testFailingCaseSupplierId() {
        assertEquals("SUP-999", supplier.getSupplierId());
    }

    @Test
    public void testFailingCaseCompanyName() {
        assertEquals("Empresa Inexistente", supplier.getCompanyName());
    }
}