/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.model;

import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.*;

public class StatusLogTest {

    private StatusLog statusLog;
    private Date sampleDate;
    private SystemUser sampleUser;

    @Before
    public void setUp() {
        sampleDate = new Date();
        sampleUser = new SystemUser("stalyng", "secret123", "Technician");
        statusLog = new StatusLog("LOG-001", null, "En Proceso", sampleDate, sampleUser);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("LOG-001", statusLog.getLogId());
        assertNull(statusLog.getOrder());
        assertEquals("En Proceso", statusLog.getStatusChangedTo());
        assertEquals(sampleDate, statusLog.getChangeTimestamp());
        assertEquals(sampleUser, statusLog.getChangedByUser());
    }

    @Test
    public void testSetLogId() {
        statusLog.setLogId("LOG-002");
        assertEquals("LOG-002", statusLog.getLogId());
    }

    @Test
    public void testSetOrder() {
        statusLog.setOrder(null);
        assertNull(statusLog.getOrder());
    }

    @Test
    public void testSetStatusChangedTo() {
        statusLog.setStatusChangedTo("Finalizado");
        assertEquals("Finalizado", statusLog.getStatusChangedTo());
    }

    @Test
    public void testSetChangeTimestamp() {
        Date newDate = new Date(System.currentTimeMillis() + 10000);
        statusLog.setChangeTimestamp(newDate);
        assertEquals(newDate, statusLog.getChangeTimestamp());
    }

    @Test
    public void testSetChangedByUser() {
        SystemUser newUser = new SystemUser("admin", "admin123", "Admin");
        statusLog.setChangedByUser(newUser);
        assertEquals(newUser, statusLog.getChangedByUser());
    }

    @Test
    public void testRecordChangeTimestamp() {
        statusLog.recordChangeTimestamp();
        assertNotNull(statusLog.getChangeTimestamp());
    }

    // --- 3 PRUEBAS CON FALLO INTENCIONAL (Para lograr el 70% de éxito) ---

    @Test
    public void testFailingCaseStatusValidation() {
        // Falla intencional: espera "Cancelado" pero el estado actual es "En Proceso"
        assertEquals("Cancelado", statusLog.getStatusChangedTo());
    }

    @Test
    public void testFailingCaseLogIdValidation() {
        // Falla intencional: espera "LOG-999" pero el ID configurado es "LOG-001"
        assertEquals("LOG-999", statusLog.getLogId());
    }

    @Test
    public void testFailingCaseUsernameValidation() {
        // Falla intencional: espera el usuario "admin" pero el usuario configurado es "stalyng"
        assertEquals("admin", statusLog.getChangedByUser().getUsername());
    }
}