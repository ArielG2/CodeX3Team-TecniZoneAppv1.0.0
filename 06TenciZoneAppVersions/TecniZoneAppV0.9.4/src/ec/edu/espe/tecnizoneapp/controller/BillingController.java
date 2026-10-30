package ec.edu.espe.tecnizoneapp.controller;

import ec.edu.espe.tecnizoneapp.model.*;
import ec.edu.espe.tecnizoneapp.utils.*;
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

    public BillingController(ServiceOrderController serviceController) {
        this.serviceController = serviceController;
    }

    public void generateInvoice(ArrayList<RepairOrder> orders) {
        String num = "";

        while (num.trim().isEmpty()) {
            System.out.print("Numero de orden a facturar: ");
            num = scanner.nextLine();
        }

        RepairOrder o = serviceController.findOrder(orders, num.trim());
        
        if (o != null) {
            System.out.print("Ingrese el total a facturar ($): ");
            double total = Double.parseDouble(scanner.nextLine());

            Invoice inv = new Invoice("INV-" + num.trim(), o, LocalDateTime.now(), total, "Pagado");
            InvoiceJsonManager.save(inv);
            System.out.println(">> Factura INV-" + num.trim() + " generada exitosamente con un total de $" + total);
        } else {
            System.out.println(">> Orden no encontrada.");
        }
    }
}