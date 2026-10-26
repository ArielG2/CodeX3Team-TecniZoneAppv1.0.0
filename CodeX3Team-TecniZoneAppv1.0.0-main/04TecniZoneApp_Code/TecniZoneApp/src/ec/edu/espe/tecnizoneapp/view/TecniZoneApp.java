package ec.edu.espe.tecnizoneapp.view;

import ec.edu.espe.tecnizoneapp.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Ariel Giler, Stalyn Guerrero, Lesly Muzo, CodeX3Team, @ESPE
 */
public class TecniZoneApp {

    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("      INICIANDO SISTEMA TECNIZONE APP - ESPE       ");
        System.out.println("====================================================\n");

        System.out.println("--- 1. AUTENTICACIÓN DE USUARIOS ---");
        SystemUser admin = new SystemUser("admin_stalyn", "secr3tPass", "ADMINISTRADOR");
        boolean loginSuccess = admin.login("secr3tPass");
        System.out.println("Usuario: " + admin.getUsername() + " | Autenticación exitosa: " + loginSuccess + "\n");

        System.out.println("--- 2. REGISTRO DE CLIENTE Y EQUIPO ---");
        Client client = new Client("CLI-001", "Ariel Giler", "0991234567", "Tech Solutions");
        System.out.println("Cliente registrado: " + client.getFullName() + " (" + client.getCompanyName() + ")");

        Equipment laptop = new Equipment("SN-987654321", "Laptop", "ASUS", "ROG Zephyrus", "Pantalla parpadea y sobrecalentamiento", client);
        System.out.println("Equipo registrado: " + laptop.getBrand() + " " + laptop.getModel() + " - S/N: " + laptop.getSerialNumber() + "\n");

        System.out.println("--- 3. VERIFICACIÓN DE GARANTÍA ---");
        WarrantyChecklist warrantyCheck = laptop.createWarrantyCheck();
        warrantyCheck.setIncludesAccessories(true);
        boolean isWarrantyValid = warrantyCheck.validateWarrantyStatus();
        System.out.println("ID Checklist: " + warrantyCheck.getChecklistId());
        System.out.println("¿Garantía válida?: " + isWarrantyValid + "\n");

        System.out.println("--- 4. CATÁLOGO DE SERVICIOS Y TÉCNICO ASIGNADO ---");
        ServiceCatalog service = new ServiceCatalog("SERV-01", "Mantenimiento Preventivo y Cambio de Pasta Térmica", 35.00);
        Technician tech = new Technician("TECH-101", "Stalyn Guerrero", "Mantenimiento de Hardware");
        tech.assignToOrder(null);
        System.out.println("Servicio seleccionado: " + service.getServiceName() + " | Costo M.O.: $" + service.getFixedLaborCost() + "\n");

        System.out.println("--- 5. INVENTARIO DE PIEZAS ---");
        Part displayPart = new Part("PART-10", "Pantalla OLED 15.6", 3, 2, 120.00);
        Part thermalPaste = new Part("PART-22", "Pasta Térmica Noctua", 1, 3, 15.00); // Stock bajo para activar alerta
        System.out.println("Pieza 1: " + displayPart.getPartName() + " | Stock: " + displayPart.getStockQuantity());
        System.out.println("Pieza 2: " + thermalPaste.getPartName() + " | Stock: " + thermalPaste.getStockQuantity() + "\n");

        System.out.println("--- 6. CREACIÓN Y PROCESAMIENTO DE ORDEN DE REPARACIÓN ---");
        RepairOrder repairOrder = new RepairOrder(
                "ORD-2026-001",
                client,
                laptop,
                tech,
                "En Diagnóstico",
                LocalDate.now().plusDays(3),
                service.getFixedLaborCost(),
                0.0,
                0.0
        );

        OrderPartDetail detail1 = repairOrder.addPartToOrder(displayPart, 1);
        displayPart.reduceStock(1);

        System.out.println("Detalle agregado: " + detail1.getUsedPart().getPartName() + " x" + detail1.getQuantityUsed() + " = $" + detail1.getSubtotal());
        System.out.println("Costo total acumulado de la orden: $" + repairOrder.getTotalAmount());

        StatusLog statusLog = repairOrder.changeStatus("En Reparación", admin);
        System.out.println("Estado actualizado a: '" + repairOrder.getCurrentStatus() + "' por " + statusLog.getChangedByUser().getUsername() + "\n");

        System.out.println("--- 7. FACTURACIÓN ---");
        Invoice repairInvoice = repairOrder.generateInvoice();
        repairInvoice.processPayment("Tarjeta de Crédito");
        repairInvoice.printReceipt();
        System.out.println();

        System.out.println("--- 8. VENTA DIRECTA ---");
        DirectSale directSale = new DirectSale("SALE-001", LocalDateTime.now(), 0.0);
        directSale.sellPart(thermalPaste, 1);
        thermalPaste.reduceStock(1);

        Invoice saleInvoice = directSale.generateInvoice();
        saleInvoice.processPayment("Efectivo");
        System.out.println("Venta realizada por un total de: $" + saleInvoice.getFinalTotal() + "\n");

        System.out.println("--- 9. CONTROL DE ALERTAS DE STOCK ---");
        StockAlert alert = thermalPaste.checkMinimumStock();
        if (alert != null) {
            System.out.println("¡ALERTA GENERADA!: " + alert.getAlertMessage());
            System.out.println("Stock actual de " + thermalPaste.getPartName() + ": " + thermalPaste.getStockQuantity() + " (Mínimo: " + thermalPaste.getMinimumStock() + ")");

            Supplier supplier = new Supplier("SUP-01", "Importadora TechEcuador", "022999888");
            supplier.orderParts(thermalPaste, 10);
            thermalPaste.addStock(10);

            alert.markAsResolved(admin);
            System.out.println("Nuevo stock de " + thermalPaste.getPartName() + ": " + thermalPaste.getStockQuantity());
        }
        System.out.println();

        System.out.println("--- 10. GENERACIÓN DE REPORTE MENSUAL ---");
        MonthlyReport report = new MonthlyReport("REP-2026-10", "Octubre 2026", 1, repairInvoice.getFinalTotal() + saleInvoice.getFinalTotal());
        System.out.println(report.exportToText());

        System.out.println("\n====================================================");
        System.out.println("     SISTEMA EJECUTADO Y VERIFICADO CON ÉXITO       ");
        System.out.println("====================================================");
    }
}
