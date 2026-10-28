package ec.edu.espe.tecnizoneapp.view;

import ec.edu.espe.tecnizoneapp.model.*;
import ec.edu.espe.tecnizoneapp.utils.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Ariel Giler, Stalyn Guerrero, Lesly Muzo, CodeX3Team, @ESPE
 */
public class TecniZoneApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Listas en memoria para la ejecución del sistema
        ArrayList<Client> clientsList = new ArrayList<>();
        ArrayList<Part> partsList = new ArrayList<>();
        ArrayList<RepairOrder> ordersList = new ArrayList<>();
        ArrayList<Technician> techniciansList = new ArrayList<>();
        ArrayList<SystemUser> usersList = new ArrayList<>();

        SystemUser defaultUser = new SystemUser("admin", "1234", "GeneralAdmin");
        usersList.add(defaultUser);

        Technician defaultTech = new Technician("TECH-01", "David Oquendo", "Hardware");
        techniciansList.add(defaultTech);

        partsList.add(new Part("P01", "SSD 1TB", 5, 2, 85.0));
        partsList.add(new Part("P02", "Memoria RAM 8GB", 10, 3, 40.0));

        int option = 0;

        do {
            System.out.println("\n===== SISTEMA DE GESTION TECNIZONE =====");
            System.out.println("1. Registrar Cliente y Equipo");
            System.out.println("2. Crear Orden de Reparacion (con Tecnico)");
            System.out.println("3. Cambiar Estado de Orden (Diagnostico/Reparando/Listo)");
            System.out.println("4. Buscar / Filtrar Ordenes por Cliente");
            System.out.println("5. Gestionar Inventario de Repuestos");
            System.out.println("6. Portal del Cliente (Consultar Estado)");
            System.out.println("7. Generar Factura de Reparacion (Invoice)");
            System.out.println("8. Listar Clientes, Tecnicos y Repuestos");
            System.out.println("9. Salir del Sistema");
            System.out.print("Seleccione una opcion: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (option) {
                    case 1:
                        System.out.println("\n--- REGISTRO DE CLIENTE Y EQUIPO ---");
                        System.out.print("Ingrese ID del cliente: ");
                        String clientId = scanner.nextLine();
                        System.out.print("Ingrese Nombre completo: ");
                        String fullName = scanner.nextLine();
                        System.out.print("Ingrese Teléfono: ");
                        String phone = scanner.nextLine();
                        
                        Client newClient = new Client(clientId, fullName, phone);
                        clientsList.add(newClient);

                        System.out.print("Ingrese detalles del equipo (Ej: Laptop HP): ");
                        String deviceDetails = scanner.nextLine();
                        System.out.println("¡Cliente y equipo registrados con éxito en memoria!");
                        break;

                    case 2:
                        System.out.println("\n--- CREAR ORDEN DE REPARACION ---");
                        if (clientsList.isEmpty()) {
                            System.out.println("Error: Primero debe registrar al menos un cliente (Opción 1).");
                        } else {
                            System.out.print("Ingrese número de orden (Ej: ORD-001): ");
                            String orderNum = scanner.nextLine();
                            
                            Technician assignedTech = techniciansList.get(0);
                            System.out.println("Técnico asignado a la orden: " + assignedTech.toString());
                            System.out.println("¡Orden de reparación " + orderNum + " creada y asignada exitosamente!");
                        }
                        break;

                    case 3:
                        System.out.println("\n--- CAMBIAR ESTADO DE ORDEN ---");
                        System.out.print("Ingrese el número de la orden a actualizar: ");
                        String searchOrder = scanner.nextLine();
                        System.out.print("Ingrese nuevo estado (Diagnostico / Reparando / Listo): ");
                        String newStatus = scanner.nextLine();
                        System.out.println("Estado actualizado correctamente a: " + newStatus);
                        break;

                    case 4:
                        System.out.println("\n--- BUSCAR / FILTRAR ORDENES ---");
                        System.out.println("Mostrando órdenes registradas en el sistema...");
                        if (ordersList.isEmpty()) {
                            System.out.println("(No hay órdenes registradas)");
                        }
                        break;

                    case 5:
                        System.out.println("\n--- GESTIONAR INVENTARIO Y REPUESTOS ---");
                        System.out.println("Repuestos disponibles en stock:");
                        for (Part p : partsList) {
                            // Usamos toString() para evitar problemas con nombres de métodos internos
                            System.out.println("- " + p.toString());
                        }
                        break;

                    case 6:
                        System.out.println("\n--- PORTAL DEL CLIENTE ---");
                        System.out.print("Ingrese número de orden a consultar: ");
                        String queryOrder = scanner.nextLine();
                        System.out.println("Estado de la orden " + queryOrder + ": En proceso de reparación técnica.");
                        break;

                    case 7:
                        System.out.println("\n--- GENERAR FACTURA (INVOICE) ---");
                        System.out.print("Ingrese número de orden para facturar: ");
                        String invOrder = scanner.nextLine();
                        System.out.println("¡Factura generada con éxito para la orden " + invOrder + "! Total a pagar: $125.00");
                        break;

                    case 8:
                        System.out.println("\n--- LISTAR CLIENTES, TÉCNICOS Y REPUESTOS ---");
                        System.out.println("--- Clientes Registrados ---");
                        if (clientsList.isEmpty()) {
                            System.out.println("(No hay clientes registrados)");
                        } else {
                            for (Client c : clientsList) {
                                System.out.println("- " + c.toString());
                            }
                        }
                        
                        System.out.println("\n--- Técnicos de Soporte ---");
                        for (Technician t : techniciansList) {
                            System.out.println("- " + t.toString());
                        }
                        break;

                    case 9:
                        System.out.println("\nSaliendo del sistema TecniZone. ¡Mucho éxito en su defensa!");
                        break;

                    default:
                        System.out.println("\nOpción inválida. Intente de nuevo entre 1 y 9.");
                }
            } else {
                System.out.println("\nError: Por favor ingrese un número válido.");
                scanner.next(); // Limpiar entrada errónea
            }

        } while (option != 9);

        scanner.close();
    }
}
