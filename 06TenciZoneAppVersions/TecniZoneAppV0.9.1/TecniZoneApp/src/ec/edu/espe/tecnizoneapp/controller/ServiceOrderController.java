package ec.edu.espe.tecnizoneapp.controller;

import ec.edu.espe.tecnizoneapp.model.*;
import ec.edu.espe.tecnizoneapp.utils.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class ServiceOrderController {

    private final Scanner scanner = new Scanner(System.in);
    private final DataPersistController persistController;

    public ServiceOrderController(DataPersistController persistController) {
        this.persistController = persistController;
    }

    public void registerClientAndEquipment(ArrayList<Client> clients) {
        System.out.println("\n--- REGISTRO DE CLIENTE Y EQUIPO ---");
        System.out.print("ID / Cedula del Cliente: ");
        String id = scanner.nextLine();
        System.out.print("Nombre Completo: ");
        String name = scanner.nextLine();
        System.out.print("Telefono: ");
        String phone = scanner.nextLine();

        Client client = new Client(id, name, phone);
        clients.add(client);
        ClientJsonManager.save(client);

        System.out.print("Tipo de Equipo (Ej: Laptop, Desktop): ");
        String deviceType = scanner.nextLine();
        System.out.print("Marca: ");
        String brand = scanner.nextLine();
        System.out.print("Modelo: ");
        String model = scanner.nextLine();
        System.out.print("Falla Detectada: ");
        String reportedFaults = scanner.nextLine();

        Equipment equipment = new Equipment("EQ-" + id, deviceType, brand, model, reportedFaults, client);
        EquipmentJsonManager.save(equipment);

        System.out.println(">> Cliente y Equipo registrados con exito.");
    }

    public void createRepairOrder(ArrayList<Client> clients, ArrayList<Technician> technicians, ArrayList<RepairOrder> orders) {

    if (clients.isEmpty()) {
        System.out.println(">> Error: No hay clientes registrados.");
        return;
    }

    System.out.print("Ingrese la Cedula / ID del cliente: ");
    String clientId = scanner.nextLine();

    Client foundClient = null;
    for (Client c : clients) {
        if (c.getClientId().equalsIgnoreCase(clientId)) {
            foundClient = c;
            break;
        }
    }

    if (foundClient == null) {
        System.out.println(">> Error: Cliente no encontrado con el ID: " + clientId);
        return;
    }

    String num = "ORD-" + (orders.size() + 1);

    Equipment equipment = new Equipment("EQ-" + num, "Equipo General", "Generico", "Estandar", "SN-" + num, foundClient);

    RepairOrder order = new RepairOrder(num, foundClient, equipment, new Date());
    orders.add(order);
    RepairOrderJsonManager.save(order);

    System.out.println(">> Orden " + num + " creada con exito para " + foundClient.getFullName());
}

    public void updateOrderStatus(ArrayList<RepairOrder> orders, SystemUser user) {
        System.out.print("Numero de orden a actualizar: ");
        String num = scanner.nextLine();
        System.out.print("Nuevo Estado: ");
        String status = scanner.nextLine();

        RepairOrder found = findOrder(orders, num);
        if (found != null) {
            found.setCurrentStatus(status);
            StatusLog log = new StatusLog("LOG-" + System.currentTimeMillis(), found, status, new Date(), user);
            StatusLogCsvManager.save(log);
            System.out.println(">> Estado actualizado y registrado en statusLogs.csv.");
        } else {
            System.out.println(">> Orden no encontrada.");
        }
    }

    public void searchOrders(ArrayList<RepairOrder> orders) {
        System.out.println("\n--- ORDENES DE REPARACION REGISTRADAS ---");
        if (orders.isEmpty()) {
            System.out.println("(No hay ordenes registradas)");
            return;
        }
        for (RepairOrder o : orders) {
            System.out.println("- Orden: " + o.getOrderNumber() + " | Estado: " + o.getCurrentStatus());
        }
    }

    public void customerPortal(ArrayList<RepairOrder> orders) {
        System.out.print("Ingrese numero de orden a consultar: ");
        String num = scanner.nextLine();
        RepairOrder o = findOrder(orders, num);
        if (o != null) {
            System.out.println(">> [PORTAL] Estado de la orden " + num + ": " + o.getCurrentStatus());
        } else {
            System.out.println(">> [PORTAL] Orden no encontrada.");
        }
    }

    public void deleteSingleClient(ArrayList<Client> clients) {
        System.out.print("ID del cliente a eliminar: ");
        String id = scanner.nextLine();

        if (clients.removeIf(c -> c.getClientId().equalsIgnoreCase(id))) {
            persistController.clearFileContent("clients.json");
            for (Client c : clients) ClientJsonManager.save(c);
            System.out.println(">> Cliente " + id + " eliminado.");
        } else {
            System.out.println(">> Cliente no encontrado.");
        }
    }

    public void deleteSingleOrder(ArrayList<RepairOrder> orders) {
        System.out.print("Numero de orden a eliminar: ");
        String num = scanner.nextLine();

        if (orders.removeIf(o -> o.getOrderNumber().equalsIgnoreCase(num))) {
            persistController.clearFileContent("repairOrders.json");
            for (RepairOrder o : orders) RepairOrderJsonManager.save(o);
            System.out.println(">> Orden " + num + " eliminada.");
        } else {
            System.out.println(">> Orden no encontrada.");
        }
    }

    public RepairOrder findOrder(ArrayList<RepairOrder> orders, String number) {
        return orders.stream()
                .filter(o -> o.getOrderNumber().equalsIgnoreCase(number))
                .findFirst()
                .orElse(null);
    }
}
