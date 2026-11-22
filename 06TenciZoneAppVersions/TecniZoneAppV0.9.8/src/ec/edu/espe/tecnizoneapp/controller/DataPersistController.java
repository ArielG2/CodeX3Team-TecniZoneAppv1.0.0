
package ec.edu.espe.tecnizoneapp.controller;

import ec.edu.espe.tecnizoneapp.model.*;
import ec.edu.espe.tecnizoneapp.utils.CsvManager;
import ec.edu.espe.tecnizoneapp.utils.JsonManager;
import ec.edu.espe.tecnizoneapp.utils.MongoDBConnection;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.ReplaceOptions;
import org.bson.Document;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static com.mongodb.client.model.Filters.eq;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class DataPersistController {

    private final JsonManager<Client> clientManager = new JsonManager<>("clients.json", json ->
        new Client(
            json.optString("clientId", "N/A"),
            json.optString("fullName", "N/A"),
            json.optString("phoneNumber", "N/A")
        )
    );

    private final JsonManager<Part> partManager = new JsonManager<>("parts.json", json ->
        new Part(
            json.optString("code", "P00"),
            json.optString("name", "Sin Nombre"),
            json.optInt("currentStock", 0),
            json.optInt("minStock", 0),
            json.optDouble("price", 0.0)
        )
    );

    private final JsonManager<Equipment> equipmentManager = new JsonManager<>("equipments.json");
    private final JsonManager<RepairOrder> repairOrderManager = new JsonManager<>("repairOrders.json");
    private final JsonManager<Invoice> invoiceManager = new JsonManager<>("invoices.json");
    private final JsonManager<DirectSale> directSaleManager = new JsonManager<>("directSales.json");
    private final JsonManager<OrderPartDetail> orderPartDetailManager = new JsonManager<>("orderPartDetails.json");
    private final JsonManager<ServiceCatalog> serviceCatalogManager = new JsonManager<>("serviceCatalog.json");
    private final JsonManager<Supplier> supplierManager = new JsonManager<>("suppliers.json");
    private final JsonManager<SystemUser> systemUserManager = new JsonManager<>("systemUsers.json");
    private final JsonManager<Technician> technicianManager = new JsonManager<>("technicians.json");
    private final JsonManager<WarrantyChecklist> warrantyChecklistManager = new JsonManager<>("warrantyChecklists.json");

    private final CsvManager<MonthlyReport> monthlyReportCsvManager = new CsvManager<>("monthlyReports.csv");
    private final CsvManager<StatusLog> statusLogCsvManager = new CsvManager<>("statusLogs.csv");
    private final CsvManager<StockAlert> stockAlertCsvManager = new CsvManager<>("stockAlerts.csv");

    public void loadClients(ArrayList<Client> clients) {
        MongoCollection<Document> collection = MongoDBConnection.getDatabase()
                .getCollection("clients");

        for (Document doc : collection.find()) {
            Client client = new Client(
                    doc.getString("clientId"),
                    doc.getString("fullName"),
                    doc.getString("phoneNumber")
            );

            clients.add(client);
        }

        System.out.println(">> Clientes cargados desde MongoDB.");
    }

    public void loadParts(ArrayList<Part> parts) {
        parts.addAll(partManager.loadAll());
    }

    public void loadRepairOrders(ArrayList<RepairOrder> orders, List<Client> clients) {
        JsonManager<RepairOrder> loader = new JsonManager<>("repairOrders.json", json -> {
            String orderNumber = json.optString("orderNumber", "ORD-000");
            String clientId = json.optString("clientId", "");
            String serialNumber = json.optString("serialNumber", "EQ-" + orderNumber);

            Client owner = clients.stream()
                    .filter(c -> c.getClientId().equalsIgnoreCase(clientId))
                    .findFirst()
                    .orElse(clientId.isEmpty() ? null : new Client(clientId, "Cliente Registrado", "N/A"));

            Equipment device = new Equipment(serialNumber, "Equipo General", "Generico", "Estandar", "N/A", owner);
            RepairOrder order = new RepairOrder(orderNumber, owner, device, new Date());
            order.setCurrentStatus(json.optString("currentStatus", "Registrada"));
            order.setLaborCost(json.optDouble("laborCost", 0.0));
            order.setPartsCost(json.optDouble("partsCost", 0.0));
            order.setTotalAmount(json.optDouble("totalAmount", 0.0));
            return order;
        });

        orders.addAll(loader.loadAll());
    }

    public void saveClient(Client client) {
        clientManager.save(client);

        MongoDatabase database = MongoDBConnection.getDatabase();
        MongoCollection<Document> collection = database.getCollection("clients");

        Document document = new Document()
                .append("clientId", client.getClientId())
                .append("fullName", client.getFullName())
                .append("phoneNumber", client.getPhoneNumber());

        collection.replaceOne(
                eq("clientId", client.getClientId()),
                document,
                new ReplaceOptions().upsert(true)
        );

        System.out.println(">> Cliente guardado en MongoDB correctamente.");
    }

    public void overwriteClients(List<Client> clients) {
        clientManager.saveAll(clients);

        MongoCollection<Document> collection = MongoDBConnection.getDatabase()
                .getCollection("clients");

        List<String> clientIds = new ArrayList<>();

        for (Client client : clients) {
            clientIds.add(client.getClientId());
        }

        if (clientIds.isEmpty()) {
            collection.deleteMany(new Document());
        } else {
            collection.deleteMany(
                    new Document("clientId", new Document("$nin", clientIds))
            );
        }

        System.out.println(">> Clientes actualizados en MongoDB correctamente.");
    }

    public void savePart(Part part) { partManager.save(part); }
    public void overwriteParts(List<Part> parts) { partManager.saveAll(parts); }

    public void saveEquipment(Equipment equipment) { equipmentManager.save(equipment); }

    public void saveRepairOrder(RepairOrder order) { repairOrderManager.save(order); }
    public void overwriteRepairOrders(List<RepairOrder> orders) { repairOrderManager.saveAll(orders); }

    public void saveInvoice(Invoice invoice) { invoiceManager.save(invoice); }
    public void saveDirectSale(DirectSale sale) { directSaleManager.save(sale); }
    public void saveOrderPartDetail(OrderPartDetail detail) { orderPartDetailManager.save(detail); }
    public void saveServiceCatalog(ServiceCatalog service) { serviceCatalogManager.save(service); }
    public void saveSupplier(Supplier supplier) { supplierManager.save(supplier); }
    public void saveSystemUser(SystemUser user) { systemUserManager.save(user); }
    public void saveTechnician(Technician technician) { technicianManager.save(technician); }
    public void saveWarrantyChecklist(WarrantyChecklist checklist) { warrantyChecklistManager.save(checklist); }

    public void saveMonthlyReport(MonthlyReport report) { monthlyReportCsvManager.save(report); }
    public void saveStatusLog(StatusLog log) { statusLogCsvManager.save(log); }
    public void saveStockAlert(StockAlert alert) { stockAlertCsvManager.save(alert); }

    public void clearFileContent(String filename) {
        try {
            File file = new File(filename);
            if (file.exists()) {
                new PrintWriter(filename).close();
            }
        } catch (Exception e) {
            System.out.println(">> Error al limpiar " + filename + ": " + e.getMessage());
        }
    }

    public void displayRawFileContent(String filename) {
        File file = new File(filename);
        System.out.println("\n===== CONTENIDO DEL ARCHIVO: " + filename + " =====");
        if (!file.exists() || file.length() == 0) {
            System.out.println("(El archivo no existe o esta vacio)");
            return;
        }

        try (Scanner reader = new Scanner(file)) {
            int lineNum = 1;
            while (reader.hasNextLine()) {
                System.out.println("[" + lineNum++ + "] " + reader.nextLine());
            }
        } catch (Exception e) {
            System.out.println(">> Error al leer el archivo " + filename + ": " + e.getMessage());
        }
    }
}
