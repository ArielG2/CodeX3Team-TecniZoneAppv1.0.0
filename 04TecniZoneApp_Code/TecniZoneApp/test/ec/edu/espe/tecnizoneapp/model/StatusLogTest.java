/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.model;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */

public class StatusLogTest {
    
    public StatusLogTest() {
    }



    @Test
    public void testStatusLogConstructorAndGetters() {
        
        LocalDateTime now = LocalDateTime.now();
        StatusLog log = new StatusLog("LOG-001", null, "In Progress", now, null);
        
        assertEquals("LOG-001", log.getLogId());
        assertEquals("In Progress", log.getStatusChangedTo());
        assertEquals(now, log.getChangeTimestamp());
    }

    @Test
    public void testSetLogId_Success() {

        StatusLog log = new StatusLog("LOG-002", null, "Pending", LocalDateTime.now(), null);
        log.setLogId("LOG-999");
        
        assertEquals("LOG-999", log.getLogId());
    }

    @Test
    public void testSetStatusChangedTo_Success() {

        StatusLog log = new StatusLog("LOG-003", null, "Pending", LocalDateTime.now(), null);
        log.setStatusChangedTo("Completed");
        
        assertEquals("Completed", log.getStatusChangedTo());
    }

    @Test
    public void testRecordChangeTimestamp_Success() {

        StatusLog log = new StatusLog("LOG-004", null, "In Progress", null, null);
        log.recordChangeTimestamp();
        
        assertNotNull(log.getChangeTimestamp());
    }

    @Test
    public void testSetChangeTimestamp_Success() {

        LocalDateTime customTime = LocalDateTime.of(2026, 10, 25, 12, 0);
        StatusLog log = new StatusLog("LOG-005", null, "Waiting", null, null);
        log.setChangeTimestamp(customTime);
        
        assertEquals(customTime, log.getChangeTimestamp());
    }

    @Test
    public void testStatusLog_ObjectNotNull() {

        StatusLog log = new StatusLog("LOG-006", null, "Closed", LocalDateTime.now(), null);
        
        assertNotNull(log);
        assertNotNull(log.getLogId());
    }

    @Test
    public void testStatusLog_IdNotEqualsWrong() {

        StatusLog log = new StatusLog("LOG-007", null, "Approved", LocalDateTime.now(), null);
        
        assertNotEquals("LOG-000", log.getLogId());
    }

    @Test
    public void testToString_NotNull() {

        StatusLog log = new StatusLog("LOG-008", null, "Rejected", LocalDateTime.now(), null);
        
        assertNotNull(log.toString());
    }

    @Test
    public void testStatusLog_IntentionalFailureStatus() {

        StatusLog log = new StatusLog("LOG-009", null, "In Progress", LocalDateTime.now(), null);

        assertEquals("Cancelled", log.getStatusChangedTo());
    }

    @Test
    public void testStatusLog_IntentionalFailureId() {

        StatusLog log = new StatusLog("LOG-010", null, "Completed", LocalDateTime.now(), null);

        assertEquals("LOG-XXX", log.getLogId());
    }
}
