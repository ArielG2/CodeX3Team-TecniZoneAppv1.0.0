package ec.edu.espe.tecnizoneapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    private Client juan;
    private Client graphic;

    @BeforeEach
    public void setUp() {
        juan = new Client("client01", "Juan Perez", "0991111111", "");
        graphic = new Client("client04", "Ana Torres", "0992222222", "GraphicDesignCo");
    }

    @Test
    public void CLI01_creacionConAtributosCorrectos() {
        assertEquals("client01", juan.getClientId());
        assertEquals("Juan Perez", juan.getFullName());
        assertEquals("0991111111", juan.getPhoneNumber());
    }

    @Test
    public void CLI02_updateContactInfoActualizaTelefono() {
        juan.updateContactInfo("0993333333");
        assertEquals("0993333333", juan.getPhoneNumber());
    }

    @Test
    public void CLI03_updateContactInfoAceptaVacio() {
        juan.updateContactInfo("");
        assertEquals("", juan.getPhoneNumber());
    }

    @Test
    public void CLI04_updateContactInfoAceptaTextoNoNumerico() {
        juan.updateContactInfo("abc");
        assertEquals("abc", juan.getPhoneNumber());
    }

    @Test
    public void CLI05_companyNameConValor() {
        assertEquals("GraphicDesignCo", graphic.getCompanyName());
    }

    @Test
    public void CLI06_companyNameVacioPermitido() {
        assertEquals("", juan.getCompanyName());
    }

    @Test
    public void CLI07_registerEquipmentRetornaEquipoNoNulo() {
        Equipment eq = juan.registerEquipment("HP Pavilion");
        assertNotNull(eq);
    }

    @Test
    public void CLI08_equipoRegistradoTieneMismoDueno() {
        Equipment eq = juan.registerEquipment("HP Pavilion");
        assertSame(juan, eq.getOwnerClient());
    }

    @Test
    public void CLI09_registerEquipmentConNullNoLanzaError() {
        assertDoesNotThrow(() -> juan.registerEquipment(null));
    }

    @Test
    public void CLI10_dosEquiposTienenMismoDueno() {
        Equipment eq1 = juan.registerEquipment("HP Pavilion");
        Equipment eq2 = juan.registerEquipment("Dell Inspiron");
        assertNotSame(eq1, eq2);
        assertSame(eq1.getOwnerClient(), eq2.getOwnerClient());
    }
}