package ec.edu.espe.tecnizoneapp.controller;

import ec.edu.espe.tecnizoneapp.model.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class BillingController {

    private final Scanner scanner = new Scanner(System.in);
    private final ServiceOrderController serviceController;
    private final DataPersistController persistController;

    public BillingController(ServiceOrderController serviceController, DataPersistController persistController) {
        this.serviceController = serviceController;
        this.persistController = persistController;
    }

    public void generateInvoice(ArrayList<RepairOrder> orders) {
        String num = "";

        while (num.trim().isEmpty()) {
            System.out.print("Numero de orden a facturar: ");
            num = scanner.nextLine();
        }

        RepairOrder o = serviceController.findOrder(orders, num.trim());
        
        if (o != null) {
            double total = readValidDouble("Ingrese el total a facturar ($): ");

            Invoice inv = new Invoice("INV-" + num.trim(), o, LocalDateTime.now(), total, "Pagado");
            persistController.saveInvoice(inv);
            System.out.println(">> Factura INV-" + num.trim() + " generada exitosamente con un total de $" + total);
        } else {
            System.out.println(">> Orden no encontrada.");
        }
    }

    private double readValidDouble(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value >= 0) {
                    return value;
                }
                System.out.println(">> El monto no puede ser negativo.");
            } catch (NumberFormatException e) {
                System.out.println(">> Ingrese un monto numerico valido (ej: 45.50).");
            }
        }
    }
}