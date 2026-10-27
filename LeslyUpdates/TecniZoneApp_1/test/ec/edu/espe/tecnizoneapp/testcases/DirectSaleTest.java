package ec.edu.espe.tecnizoneapp.testcases;

import ec.edu.espe.tecnizoneapp.model.Client;
import ec.edu.espe.tecnizoneapp.model.DirectSale;
import java.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class DirectSaleTest {
    
    public DirectSaleTest() {
    }


    @Test
    public void testDirectSaleConstructorAndGetters() {
        Client client = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        DirectSale sale = new DirectSale("SALE-001", LocalDateTime.now(), 50.0);
        sale.setClient(client);
        
        assertEquals("SALE-001", sale.getSaleId());
        assertEquals(client, sale.getClient());
        assertEquals(50.0, sale.getTotalAmount(), 0.001);
    }

    @Test
    public void testUpdateSaleTotal_Success() {
        
        DirectSale sale = new DirectSale("SALE-001", LocalDateTime.now(), 50.0);
        
        sale.setTotalAmount(75.50);
        
        assertEquals(75.50, sale.getTotalAmount(), 0.001);
    }

    @Test
    public void testAssociateClientToSale() {
        
        Client client = new Client("C002", "Ana Lopez", "0922222222", "Particular");
        DirectSale sale = new DirectSale("SALE-002", LocalDateTime.now(), 120.0);
        sale.setClient(client);
        
        assertNotNull(sale.getClient());
        assertEquals("Ana Lopez", sale.getClient().getFullName());
    }

    @Test
    public void testSaleDateAssignment() {
        
        LocalDateTime today = LocalDateTime.now();
        DirectSale sale = new DirectSale("SALE-003", today, 30.0);
        
        assertEquals(today, sale.getSaleDate());
    }



    @Test
    public void testDirectSale_ZeroAmount() {
        
        DirectSale sale = new DirectSale("SALE-004", LocalDateTime.now(), 0.0);
        
        assertEquals(0.0, sale.getTotalAmount(), 0.001);
    }

    @Test
    public void testDirectSale_NotEqualsWrongAmount() {
        
        DirectSale sale = new DirectSale("SALE-005", LocalDateTime.now(), 150.0);
        
        assertNotEquals(999.99, sale.getTotalAmount(), 0.001);
    }

    @Test
    public void testDirectSale_EmptySaleId() {
        
        DirectSale sale = new DirectSale("", LocalDateTime.now(), 45.0);
        
        assertEquals("", sale.getSaleId());
    }



    @Test
    public void testDirectSale_StateModificationConsistency() {
        
        Client client1 = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        Client client2 = new Client("C002", "Carlos Perez", "0933333333", "Empresa X");
        
        DirectSale sale = new DirectSale("SALE-006", LocalDateTime.now(), 100.0);
        sale.setClient(client1);
        
        sale.setClient(client2);
        sale.setTotalAmount(250.0);
        
        assertEquals("SALE-006", sale.getSaleId());
        assertEquals(client2, sale.getClient());
        assertEquals("Carlos Perez", sale.getClient().getFullName());
        assertEquals(250.0, sale.getTotalAmount(), 0.001);
    }

    @Test
    public void testDirectSale_ReferenceIntegrityWithClient() {
        
        Client client = new Client("C001", "Stalyn Guerrero", "0911111111", "TecniZone");
        DirectSale sale = new DirectSale("SALE-007", LocalDateTime.now(), 80.0);
        sale.setClient(client);
        
        assertSame(client, sale.getClient());
    }

    @Test
    public void testDirectSale_DateAfterModification() {
        
        DirectSale sale = new DirectSale("SALE-008", LocalDateTime.now().minusDays(5), 60.0);
        
        LocalDateTime newDate = LocalDateTime.now();
        sale.setSaleDate(newDate);
        
        assertEquals(newDate, sale.getSaleDate());
        assertNotNull(sale.getSaleDate());
    }
}