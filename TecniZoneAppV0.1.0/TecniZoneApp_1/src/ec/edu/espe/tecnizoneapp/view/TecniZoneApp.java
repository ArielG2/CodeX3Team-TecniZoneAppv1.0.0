package ec.edu.espe.tecnizoneapp.view;

import ec.edu.espe.tecnizoneapp.controller.DataManager;
import ec.edu.espe.tecnizoneapp.model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ariel Giler, Stalyn Guerrero, Lesly Muzo, CodeX3Team, @ESPE
 */
public class TecniZoneApp {

    private static final List<Client> clientsList = new ArrayList<>();
    private static final List<Part> partsList = new ArrayList<>();
    private static final List<RepairOrder> ordersList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        clientsList.addAll(DataManager.loadClientsCSV());
        partsList.addAll(DataManager.loadPartsJSON());

        int option = -1;
        do {
            System.out.println("\n==================================================");
            System.out.println("          TECNIZONE APP - MENU PRINCIPAL          ");
            System.out.println("==================================================");
            System.out.println("1. Registrar Cliente, Equipo y Garantia");
            System.out.println("2. Crear Orden de Reparacion");
            System.out.println("3. Cambiar Estado de Orden (Diagnosis/Repair/Listed)");
            System.out.println("4. Buscar / Filtrar Ordenes por Cliente o Serie");
            System.out.println("5. Gestionar Inventario de Repuestos y Alertas");
            System.out.println("6. Portal del Cliente (Consultar Estado por Numero de Orden)");
            System.out.println("7. Generar y Exportar Reporte Mensual (TXT)");
            System.out.println("8. Listar Clientes y Repuestos guardados");
            System.out.println("0. Salir del Sistema");
            System.out.print("Seleccione una opcion: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        registerClientEquipmentAndWarranty();
                        break;
                    case 2:
                        createRepairOrder();
                        break;
                    case 3:
                        updateOrderStatus();
                        break;
                    case 4:
                        searchOrders();
                        break;
                    case 5:
                        manageInventory();
                        break;
                    case 6:
                        clientPortalLookup();
                        break;
                    case 7:
                        generateMonthlyReport();
                        break;
                    case 8:
                        showStoredData();
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema TecniZoneApp...");
                        break;
                    default:
                        System.out.println("Opcion no valida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un numero entero.");
            }
        } while (option != 0);
    }

    private static void registerClientEquipmentAndWarranty() {
        System.out.println("\n--- REGISTRO DE CLIENTE, EQUIPO Y GARANTIA ---");
        System.out.print("ID del Cliente: ");
        String clientId = scanner.nextLine();
        System.out.print("Nombre del Cliente: ");
        String name = scanner.nextLine();
        System.out.print("Telefono: ");
        String phone = scanner.nextLine();
        System.out.print("Empresa: ");
        String company = scanner.nextLine();

        Client client = new Client(clientId, name, phone, company);
        clientsList.add(client);
        DataManager.saveClientsCSV(clientsList);

        System.out.print("\nNumero de Serie del Equipo: ");
        String serial = scanner.nextLine();
        System.out.print("Tipo de Equipo (Ej. Laptop, PC, Consola): ");
        String type = scanner.nextLine();
        System.out.print("Marca: ");
        String brand = scanner.nextLine();
        System.out.print("Modelo: ");
        String model = scanner.nextLine();
        System.out.print("Falla Reportada: ");
        String fault = scanner.nextLine();

        Equipment equipment = new Equipment(serial, type, brand, model, fault, client);

        System.out.print("Tiene dano fisico previo? (si/no): ");
        boolean damage = scanner.nextLine().equalsIgnoreCase("si");
        System.out.print("Acompana accesorios? (si/no): ");
        boolean accessories = scanner.nextLine().equalsIgnoreCase("si");
        System.out.print("Garantia valida? (si/no): ");
        boolean validWarranty = scanner.nextLine().equalsIgnoreCase("si");

        WarrantyChecklist checklist = new WarrantyChecklist("CHK-" + serial, equipment, damage, accessories, validWarranty);
        System.out.println("Garantia verificada -> Estatus de Cobertura: " + (checklist.validateWarrantyStatus() ? "VALIDA" : "NO VALIDA / CON COSTO"));
    }

    private static void createRepairOrder() {
        System.out.println("\n--- CREACION DE ORDEN DE REPARACION ---");
        if (clientsList.isEmpty()) {
            System.out.println("Primero registre un cliente (Opcion 1).");
            return;
        }

        System.out.print("Numero de Orden (Ej. ORD-001): ");
        String orderNum = scanner.nextLine();

        System.out.print("Costo de Mano de Obra ($): ");
        double laborCost = Double.parseDouble(scanner.nextLine());

        System.out.print("Dias estimados para la entrega: ");
        int days = Integer.parseInt(scanner.nextLine());
        LocalDate deliveryDate = LocalDate.now().plusDays(days);

        Client client = clientsList.get(clientsList.size() - 1);
        Equipment equipment = new Equipment("SN-TEMP", "Equipo Generico", "Marca", "Modelo", "Revision", client);
        Technician tech = new Technician("TECH-01", "Tecnico Principal", "General");

        RepairOrder order = new RepairOrder(orderNum, client, equipment, tech, "Under Diagnosis", deliveryDate, laborCost, 0.0, 0.0);

        if (!partsList.isEmpty()) {
            System.out.print("Desea agregar el repuesto " + partsList.get(0).getPartName() + " ($" + partsList.get(0).getUnitPrice() + ")? (si/no): ");
            if (scanner.nextLine().equalsIgnoreCase("si")) {
                order.addPartToOrder(partsList.get(0), 1);
                partsList.get(0).reduceStock(1);
                DataManager.savePartsJSON(partsList);
            }
        }

        order.calculateTotalCost();
        ordersList.add(order);

        System.out.println("Orden creada con exito.");
        System.out.println("Fecha Estimada de Entrega: " + order.getEstimatedDeliveryDate());
        System.out.println("Mano de Obra: $" + order.getLaborCost() + " | Repuestos: $" + order.getPartsCost());
        System.out.println("MONTO TOTAL CALCULADO AUTOMATICAMENTE: $" + order.getTotalAmount());
    }

    private static void updateOrderStatus() {
        System.out.println("\n--- CAMBIO DE ESTADO DE ORDEN ---");
        if (ordersList.isEmpty()) {
            System.out.println("No hay ordenes registradas en el sistema.");
            return;
        }

        System.out.print("Ingrese Numero de Orden: ");
        String num = scanner.nextLine();
        RepairOrder found = null;
        for (RepairOrder o : ordersList) {
            if (o.getOrderNumber().equalsIgnoreCase(num)) {
                found = o;
                break;
            }
        }

        if (found != null) {
            System.out.println("Estado Actual: " + found.getCurrentStatus());
            System.out.println("Seleccione Nuevo Estado:");
            System.out.println("1. Under Diagnosis");
            System.out.println("2. Under Repair");
            System.out.println("3. Listed (Listo para entrega)");
            System.out.print("Opcion: ");
            int st = Integer.parseInt(scanner.nextLine());

            String newStatus = "Under Diagnosis";
            if (st == 2) newStatus = "Under Repair";
            if (st == 3) newStatus = "Listed";

            SystemUser admin = new SystemUser("admin", "1234", "ADMIN");
            found.changeStatus(newStatus, admin);
            System.out.println("Estado de la orden " + found.getOrderNumber() + " actualizado a: " + found.getCurrentStatus());
        } else {
            System.out.println("Orden no encontrada.");
        }
    }

    private static void searchOrders() {
        System.out.println("\n--- BUSQUEDA Y FILTRADO DE ORDENES ---");
        System.out.print("Ingrese Nombre del Cliente o Serie del Equipo: ");
        String query = scanner.nextLine().toLowerCase();

        boolean foundAny = false;
        for (RepairOrder o : ordersList) {
            if (o.getCustomer().getFullName().toLowerCase().contains(query) ||
                o.getDevice().getSerialNumber().toLowerCase().contains(query)) {
                System.out.println("Orden: " + o.getOrderNumber() + " | Cliente: " + o.getCustomer().getFullName() +
                                   " | Serie: " + o.getDevice().getSerialNumber() + " | Estado: " + o.getCurrentStatus() +
                                   " | Total: $" + o.getTotalAmount());
                foundAny = true;
            }
        }
        if (!foundAny) {
            System.out.println("No se encontraron coincidencias.");
        }
    }

    private static void manageInventory() {
        System.out.println("\n--- GESTION DE INVENTARIO Y ALERTAS DE STOCK ---");
        System.out.print("Ingrese ID de Repuesto: ");
        String id = scanner.nextLine();
        System.out.print("Nombre del Repuesto: ");
        String name = scanner.nextLine();
        System.out.print("Cantidad en Stock: ");
        int stock = Integer.parseInt(scanner.nextLine());
        System.out.print("Precio Unitario: ");
        double price = Double.parseDouble(scanner.nextLine());

        Part part = new Part(id, name, stock, 3, price);
        partsList.add(part);
        DataManager.savePartsJSON(partsList);

        // Verificacion de Alerta (PB-06: Stock menor a 3 unidades)
        StockAlert alert = part.checkMinimumStock();
        if (alert != null) {
            System.out.println("!!! ADVERTENCIA / ALERTA DE STOCK !!!");
            System.out.println(alert.getAlertMessage() + " (Stock actual: " + part.getStockQuantity() + ")");
        } else {
            System.out.println("Repuesto registrado. Nivel de stock adecuado.");
        }
    }

    private static void clientPortalLookup() {
        System.out.println("\n--- PORTAL EXTERNO DE CONSULTA DE CLIENTES ---");
        System.out.print("Ingrese su Numero de Orden: ");
        String num = scanner.nextLine();

        RepairOrder found = null;
        for (RepairOrder o : ordersList) {
            if (o.getOrderNumber().equalsIgnoreCase(num)) {
                found = o;
                break;
            }
        }

        if (found != null) {
            System.out.println("\n----------------------------------------");
            System.out.println("ORDEN: " + found.getOrderNumber());
            System.out.println("Cliente: " + found.getCustomer().getFullName());
            System.out.println("Estado de Reparacion: " + found.getCurrentStatus());
            System.out.println("Fecha Estimada de Entrega: " + found.getEstimatedDeliveryDate());
            System.out.println("Monto a Pagar: $" + found.getTotalAmount());
            System.out.println("----------------------------------------");
        } else {
            System.out.println("La orden ingresada no existe en nuestro sistema.");
        }
    }

    private static void generateMonthlyReport() {
        System.out.println("\n--- GENERACION DE REPORTE MENSUAL CONSOLIDADO ---");
        int completedRepairs = 0;
        double totalRevenue = 0.0;

        for (RepairOrder o : ordersList) {
            totalRevenue += o.getTotalAmount();
            completedRepairs++;
        }

        MonthlyReport report = new MonthlyReport("REP-2026-10", "Octubre 2026", completedRepairs, totalRevenue);
        System.out.println(report.exportToText());

        DataManager.exportReportTXT(report);
    }

    private static void showStoredData() {
        System.out.println("\n--- CLIENTES CARGADOS (" + clientsList.size() + ") ---");
        for (Client c : clientsList) System.out.println(c);

        System.out.println("\n--- REPUESTOS CARGADOS (" + partsList.size() + ") ---");
        for (Part p : partsList) System.out.println(p);
    }
}
