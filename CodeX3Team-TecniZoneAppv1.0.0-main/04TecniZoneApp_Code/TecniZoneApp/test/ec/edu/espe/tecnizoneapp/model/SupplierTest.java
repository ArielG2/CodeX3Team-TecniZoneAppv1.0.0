package ec.edu.espe.tecnizoneapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */


public class SupplierTest {

    private Supplier techCorp;
    private Supplier globalAcc;

    @BeforeEach
    public void setUp() {
        techCorp = new Supplier("supplier01", "TechCorpImports", "0998887777");
        globalAcc = new Supplier("supplier02", "GlobalAccessories", "0997776666");
    }

    @Test
    public void PRV01_creacionConAtributosCorrectos() {
        assertEquals("supplier01", techCorp.getSupplierId());
        assertEquals("TechCorpImports", techCorp.getCompanyName());
        assertEquals("0998887777", techCorp.getContactPhone());
    }

    @Test
    public void PRV02_orderPartsNoLanzaError() {
        Part ram = new Part("part02", "Ram8gb", 10, 3, 25.0);
        assertDoesNotThrow(() -> techCorp.orderParts(ram, 10));
    }

    @Test
    public void PRV03_orderPartsCantidadCeroNoLanzaError() {
        Part ram = new Part("part02", "Ram8gb", 10, 3, 25.0);
        assertDoesNotThrow(() -> techCorp.orderParts(ram, 0));
    }

    @Test
    public void PRV04_orderPartsCantidadNegativaNoLanzaError() {
        Part ram = new Part("part02", "Ram8gb", 10, 3, 25.0);
        assertDoesNotThrow(() -> techCorp.orderParts(ram, -5));
    }

    @Test
    public void PRV05_orderPartsConNullLanzaExcepcion() {
        assertThrows(NullPointerException.class, () -> techCorp.orderParts(null, 5));
    }

    @Test
    public void PRV06_orderPartsCantidadUnoNoLanzaError() {
        Part ram = new Part("part02", "Ram8gb", 10, 3, 25.0);
        assertDoesNotThrow(() -> techCorp.orderParts(ram, 1));
    }

    @Test
    public void PRV07_orderPartsCantidadGrandeNoLanzaError() {
        Part ram = new Part("part02", "Ram8gb", 10, 3, 25.0);
        assertDoesNotThrow(() -> techCorp.orderParts(ram, 1000));
    }

    @Test
    public void PRV08_orderPartsNoCambiaDatosDelProveedor() {
        Part ram = new Part("part02", "Ram8gb", 10, 3, 25.0);
        techCorp.orderParts(ram, 10);
        assertEquals("TechCorpImports", techCorp.getCompanyName());
    }

    @Test
    public void PRV09_setContactPhoneCambiaTelefono() {
        techCorp.setContactPhone("0995554444");
        assertEquals("0995554444", techCorp.getContactPhone());
    }

    @Test
    public void PRV10_proveedoresTienenIdDistintos() {
        assertNotEquals(techCorp.getSupplierId(), globalAcc.getSupplierId());
    }
}