package ec.edu.espe.tecnizoneapp.controller;

import ec.edu.espe.tecnizoneapp.model.*;
import java.util.ArrayList;
import java.util.Scanner;

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
    private final Scanner scanner = new Scanner(System.in);

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

    public void viewAllSystemFilesMenu() {
        int opt;
        do {
            System.out.println("\n===== CONSULTA GLOBAL DE ARCHIVOS DE DATOS (JSON / CSV) =====");
            System.out.println("1. Clientes registrados (clients.json)");
            System.out.println("2. Repuestos de Inventario (parts.json)");
            System.out.println("3. Equipos registrados (equipments.json)");
            System.out.println("4. Órdenes de Reparación (repairOrders.json)");
            System.out.println("5. Facturas emitidas (invoices.json)");
            System.out.println("6. Logs de Estado (statusLogs.csv)");
            System.out.println("7. Alertas de Stock (stockAlerts.csv)");
            System.out.println("8. Visualizar TODOS los archivos de una sola vez");
            System.out.println("9. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            try {
                opt = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                opt = -1;
            }

            switch (opt) {
                case 1 -> persistController.displayRawFileContent("clients.json");
                case 2 -> persistController.displayRawFileContent("parts.json");
                case 3 -> persistController.displayRawFileContent("equipments.json");
                case 4 -> persistController.displayRawFileContent("repairOrders.json");
                case 5 -> persistController.displayRawFileContent("invoices.json");
                case 6 -> persistController.displayRawFileContent("statusLogs.csv");
                case 7 -> persistController.displayRawFileContent("stockAlerts.csv");
                case 8 -> displayAllFiles();
                case 9 -> System.out.println(">> Regresando al menú principal...");
                default -> System.out.println(">> Opción no válida.");
            }
        } while (opt != 9);
    }

    private void displayAllFiles() {
        String[] files = {"clients.json", "parts.json", "equipments.json", "repairOrders.json", "invoices.json", "statusLogs.csv", "stockAlerts.csv"};
        for (String f : files) {
            persistController.displayRawFileContent(f);
        }
    }

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