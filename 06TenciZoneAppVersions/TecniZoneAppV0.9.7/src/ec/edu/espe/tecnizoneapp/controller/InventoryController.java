package ec.edu.espe.tecnizoneapp.controller;

import ec.edu.espe.tecnizoneapp.model.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class InventoryController {

    private final Scanner scanner = new Scanner(System.in);
    private final DataPersistController persistController;

    public InventoryController(DataPersistController persistController) {
        this.persistController = persistController;
    }

    public void manageInventory(ArrayList<Part> parts) {
        int option;
        do {
            System.out.println("\n--- SUBMENU GESTION DE INVENTARIO ---");
            System.out.println("1. Ver Repuestos y Verificar Alertas de Stock");
            System.out.println("2. Registrar Nuevo Repuesto");
            System.out.println("3. Aumentar o Reducir Stock (Agregar / Quitar)");
            System.out.println("4. Eliminar Repuesto por Codigo");
            System.out.println("0. Regresar al Menu Principal");
            System.out.print("Seleccione una opcion: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                option = -1;
            }

            switch (option) {
                case 1 -> viewInventory(parts);
                case 2 -> addPart(parts);
                case 3 -> modifyStock(parts);
                case 4 -> deleteSinglePart(parts);
                case 0 -> System.out.println(">> Regresando al menu principal...");
                default -> System.out.println(">> Opcion no valida.");
            }
        } while (option != 0);
    }

    public void viewInventory(ArrayList<Part> parts) {
        System.out.println("\n--- INVENTARIO DE REPUESTOS ---");
        if (parts.isEmpty()) {
            System.out.println("(No hay repuestos registrados en el inventario)");
        } else {
            for (Part p : parts) {
                System.out.println("- " + p.toString());

                StockAlert alert = p.verifyLowStock();
                if (alert != null) {
                    persistController.saveStockAlert(alert);
                    System.out.println("  [ALERTA DE STOCK BAJO REGISTRADA EN CSV]");
                }
            }
        }

        System.out.print("\nPresione Enter o ingrese '0' para regresar al Submenu de Inventario: ");
        scanner.nextLine();
    }

    public void addPart(ArrayList<Part> parts) {
        System.out.println("\n--- REGISTRAR NUEVO REPUESTO ---");
        System.out.print("Codigo del Repuesto (Ej: P01) o '0' para regresar al Submenu: ");
        String code = scanner.nextLine();
        
        if (code.equals("0")) {
            System.out.println(">> Registro cancelado. Regresando al Submenu de Inventario...");
            return;
        }

        System.out.print("Nombre del Repuesto: ");
        String name = scanner.nextLine();
        
        int stock = readInt("Cantidad Inicial en Stock: ");
        int minStock = readInt("Umbral Minimo de Stock: ");
        double price = readDouble("Precio Unitario: ");

        Part newPart = new Part(code, name, stock, minStock, price);
        parts.add(newPart);
        persistController.savePart(newPart);
        System.out.println(">> Repuesto registrado y guardado en parts.json exitosamente.");
    }

    public void modifyStock(ArrayList<Part> parts) {
        System.out.println("\n--- AUMENTAR O REDUCIR STOCK ---");
        System.out.print("Codigo o nombre del repuesto a modificar (o '0' para regresar al Submenu): ");
        String query = scanner.nextLine();

        if (query.equals("0")) {
            System.out.println(">> Operacion cancelada. Regresando al Submenu de Inventario...");
            return;
        }

        Part found = parts.stream()
                .filter(p -> p.toString().toLowerCase().contains(query.toLowerCase()))
                .findFirst()
                .orElse(null);

        if (found == null) {
            System.out.println(">> Repuesto no encontrado.");
            return;
        }

        System.out.println("Repuesto encontrado: " + found.toString());
        System.out.println("1. Aumentar Stock (+)");
        System.out.println("2. Reducir Stock (-)");
        System.out.println("0. Cancelar y regresar al Submenu");
        System.out.print("Seleccione opcion: ");
        
        int opt = readInt("");
        if (opt == 0) {
            System.out.println(">> Operacion cancelada. Regresando al Submenu...");
            return;
        }

        int amount = readInt("Cantidad a " + (opt == 1 ? "agregar" : "quitar") + ": ");

        if (opt == 1) {
            found.increaseStock(amount);
            updateAllPartsFile(parts);
            System.out.println(">> Stock incrementado con exito. Nuevo stock: " + found.getCurrentStock());
        } else if (opt == 2) {
            found.decreaseStock(amount);
            updateAllPartsFile(parts);
            System.out.println(">> Stock reducido con exito. Nuevo stock: " + found.getCurrentStock());
        } else {
            System.out.println(">> Opcion no valida.");
        }
    }

    public void deleteSinglePart(ArrayList<Part> parts) {
        System.out.println("\n--- ELIMINAR REPUESTO ---");
        System.out.print("Codigo o nombre del repuesto a eliminar (o '0' para regresar al Submenu): ");
        String code = scanner.nextLine();

        if (code.equals("0")) {
            System.out.println(">> Borrado cancelado. Regresando al Submenu...");
            return;
        }

        boolean removed = parts.removeIf(p -> p.toString().toLowerCase().contains(code.toLowerCase()));
        if (removed) {
            updateAllPartsFile(parts);
            System.out.println(">> Repuesto " + code + " eliminado con exito.");
        } else {
            System.out.println(">> Repuesto no encontrado en el inventario.");
        }
    }

    private void updateAllPartsFile(ArrayList<Part> parts) {
        persistController.overwriteParts(parts);
    }

    private int readInt(String msg) {
        while (true) {
            try {
                if (!msg.isEmpty()) System.out.print(msg);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.print("Ingrese un numero entero valido: ");
            }
        }
    }

    private double readDouble(String msg) {
        while (true) {
            try {
                if (!msg.isEmpty()) System.out.print(msg);
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.print("Ingrese un numero decimal valido: ");
            }
        }
    }
}