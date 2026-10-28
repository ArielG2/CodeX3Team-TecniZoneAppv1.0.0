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

    public void deleteSinglePart(ArrayList<Part> parts) {
        System.out.print("Código o nombre del repuesto a eliminar: ");
        String code = scanner.nextLine();

        boolean removed = parts.removeIf(p -> p.toString().toLowerCase().contains(code.toLowerCase()));
        if (removed) {
            persistController.clearFileContent("parts.json");
            for (Part p : parts) {
                PartJsonManager.save(p);
            }
            System.out.println(">> Repuesto " + code + " eliminado con éxito de memoria y disco.");
        } else {
            System.out.println(">> Repuesto no encontrado en el inventario.");
        }
    }
}
