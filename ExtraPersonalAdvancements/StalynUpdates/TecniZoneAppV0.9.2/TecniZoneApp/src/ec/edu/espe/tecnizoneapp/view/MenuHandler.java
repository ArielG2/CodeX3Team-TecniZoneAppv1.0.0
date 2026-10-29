package ec.edu.espe.tecnizoneapp.view;

import ec.edu.espe.tecnizoneapp.controller.TecniZoneController;
import java.util.Scanner;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class MenuHandler {

    private final Scanner scanner = new Scanner(System.in);
    private final TecniZoneController controller;

    public MenuHandler(TecniZoneController controller) {
        this.controller = controller;
    }

    public void start() {
        controller.init();
        int option;
        do {
            showMainMenu();
            option = readInt();
            processOption(option);
        } while (option != 11);
    }

    private void showMainMenu() {
        System.out.println("\n===== TECNIZONE APP - SISTEMA DE GESTION =====");
        System.out.println("1. Registrar Cliente y Equipo (PB-01)");
        System.out.println("2. Crear Orden de Reparacion (PB-01 / PB-03)");
        System.out.println("3. Cambiar Estado de Orden & Log CSV (PB-02)");
        System.out.println("4. Buscar / Listar Ordenes Registradas (PB-08)");
        System.out.println("5. Gestionar Inventario de Repuestos (Ver, Agregar, Modificar Stock)");
        System.out.println("6. Portal del Cliente (PB-08)");
        System.out.println("7. Generar Factura de Reparacion (PB-07)");
        System.out.println("8. Eliminar UN Solo Registro (Cliente / Repuesto / Orden)");
        System.out.println("9. Vaciar Archivos Completos (Limpieza Total)");
        System.out.println("10. Consultar Informacion de Todos los Archivos (JSON / CSV)");
        System.out.println("11. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private void processOption(int option) {
        switch (option) {
            case 1 -> controller.registerClientAndEquipment();
            case 2 -> controller.createRepairOrder();
            case 3 -> controller.updateOrderStatus();
            case 4 -> controller.searchOrders();
            case 5 -> controller.manageInventory();
            case 6 -> controller.customerPortal();
            case 7 -> controller.generateInvoice();
            case 8 -> showDeleteSingleMenu();
            case 9 -> showPurgeMenu();
            case 10 -> controller.viewAllSystemFilesMenu();
            case 11 -> System.out.println("\n>> Saliendo del sistema TecniZone...");
            default -> System.out.println(">> Opcion invalida.");
        }
    }

    private void showDeleteSingleMenu() {
        System.out.println("\n--- BORRADO SELECTIVO ---");
        System.out.println("1. Eliminar Cliente por ID");
        System.out.println("2. Eliminar Repuesto por Código");
        System.out.println("3. Eliminar Orden por Número");
        System.out.print("Opcion: ");
        int opt = readInt();
        switch (opt) {
            case 1 -> controller.deleteSingleClient();
            case 2 -> controller.deleteSinglePart();
            case 3 -> controller.deleteSingleOrder();
            default -> System.out.println(">> Operacion cancelada.");
        }
    }

    private void showPurgeMenu() {
        System.out.println("\n--- VACIADO COMPLETO ---");
        System.out.print("Desea borrar TODOS los archivos? (1 = Si / 0 = No): ");
        if (readInt() == 1) {
            controller.purgeAllData();
        } else {
            System.out.println(">> Operacion cancelada.");
        }
    }

    private int readInt() {
        try {
            int val = scanner.nextInt();
            scanner.nextLine();
            return val;
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }
}