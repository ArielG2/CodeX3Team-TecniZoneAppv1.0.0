package ec.edu.espe.tecnizoneapp.controller;

import ec.edu.espe.tecnizoneapp.model.*;
import ec.edu.espe.tecnizoneapp.utils.*;

import java.util.ArrayList;
import java.util.Date;
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
            System.out.println("4. Eliminar Repuesto por Código");
            System.out.println("5. Volver al Menu Principal");
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
                case 5 -> System.out.println(">> Regresando al menu principal...");
                default -> System.out.println(">> Opcion no valida.");
            }
        } while (option != 5);
    }

    public void viewInventory(ArrayList<Part> parts) {
        System.out.println("\n--- INVENTARIO DE REPUESTOS ---");
        if (parts.isEmpty()) {
            System.out.println("(No hay repuestos registrados en el inventario)");
            return;
        }
        for (Part p : parts) {
            System.out.println("- " + p.toString());
            
            StockAlert alert = new StockAlert("ALT-" + System.currentTimeMillis(), p, new Date().toString(), "Stock Bajo", false);
            StockAlertCsvManager.save(alert);
            System.out.println("  [ALERTA DE STOCK VERIFICADA Y REGISTRADA EN CSV]");
        }
    }

    public void addPart(ArrayList<Part> parts) {
        System.out.println("\n--- REGISTRAR NUEVO REPUESTO ---");
        System.out.print("Codigo del Repuesto (Ej: P01): ");
        String code = scanner.nextLine();
        System.out.print("Nombre del Repuesto: ");
        String name = scanner.nextLine();
        
        int stock = readInt("Cantidad Inicial en Stock: ");
        int minStock = readInt("Umbral Minimo de Stock: ");
        double price = readDouble("Precio Unitario ($): ");

        Part newPart = new Part(code, name, stock, minStock, price);
        parts.add(newPart);
        PartJsonManager.save(newPart);
        System.out.println(">> Repuesto registrado y guardado en parts.json exitosamente.");
    }

    public void modifyStock(ArrayList<Part> parts) {
        System.out.println("\n--- AUMENTAR O REDUCIR STOCK ---");
        System.out.print("Codigo o nombre del repuesto a modificar: ");
        String query = scanner.nextLine();

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
        System.out.print("Seleccione opción: ");
        int opt = readInt("");

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
        System.out.print("Codigo o nombre del repuesto a eliminar: ");
        String code = scanner.nextLine();

        boolean removed = parts.removeIf(p -> p.toString().toLowerCase().contains(code.toLowerCase()));
        if (removed) {
            updateAllPartsFile(parts);
            System.out.println(">> Repuesto " + code + " eliminado con exito de memoria y disco.");
        } else {
            System.out.println(">> Repuesto no encontrado en el inventario.");
        }
    }

    private void updateAllPartsFile(ArrayList<Part> parts) {
        persistController.clearFileContent("parts.json");
        for (Part p : parts) {
            PartJsonManager.save(p);
        }
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
