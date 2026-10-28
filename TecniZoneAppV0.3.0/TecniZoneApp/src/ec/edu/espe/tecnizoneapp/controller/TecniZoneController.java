package ec.edu.espe.tecnizoneapp.controller;

import ec.edu.espe.tecnizoneapp.model.*;
import java.util.ArrayList;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class TecniZoneController {

    private final ArrayList<Client> clients = new ArrayList<>();
    private final ArrayList<Part> parts = new ArrayList<>();
    private final ArrayList<RepairOrder> orders = new ArrayList<>();
    private final ArrayList<Technician> technicians = new ArrayList<>();
    private final ArrayList<SystemUser> users = new ArrayList<>();

    private final DataPersistController persistController;
    private final ServiceOrderController serviceController;
    private final InventoryController inventoryController;
    private final BillingController billingController;

    public TecniZoneController() {
        this.persistController = new DataPersistController();
        this.serviceController = new ServiceOrderController(persistController);
        this.inventoryController = new InventoryController(persistController);
        this.billingController = new BillingController(serviceController);
    }

    public void init() {
        persistController.loadClients(clients);
        persistController.loadParts(parts);
        if (users.isEmpty()) users.add(new SystemUser("admin", "1234", "ADMIN"));
        if (technicians.isEmpty()) technicians.add(new Technician("TECH-01", "David Oquendo", "Hardware"));
        System.out.println(">> Datos cargados correctamente.");
    }

    public void registerClientAndEquipment() { serviceController.registerClientAndEquipment(clients); }
    public void createRepairOrder() { serviceController.createRepairOrder(clients, technicians, orders); }
    public void updateOrderStatus() { serviceController.updateOrderStatus(orders, users.get(0)); }
    public void searchOrders() { serviceController.searchOrders(orders); }
    public void manageInventory() { inventoryController.manageInventory(parts); }
    public void customerPortal() { serviceController.customerPortal(orders); }
    public void generateInvoice() { billingController.generateInvoice(orders); }
    
    public void deleteSingleClient() { serviceController.deleteSingleClient(clients); }
    public void deleteSinglePart() { inventoryController.deleteSinglePart(parts); }
    public void deleteSingleOrder() { serviceController.deleteSingleOrder(orders); }

    public void purgeAllData() {
        persistController.clearFileContent("clients.json"); clients.clear();
        persistController.clearFileContent("parts.json"); parts.clear();
        persistController.clearFileContent("equipments.json");
        persistController.clearFileContent("repairOrders.json"); orders.clear();
        persistController.clearFileContent("invoices.json");
        persistController.clearFileContent("statusLogs.csv");
        persistController.clearFileContent("stockAlerts.csv");
        System.out.println(">> Todos los archivos y listas en memoria han sido limpiados.");
    }
}
